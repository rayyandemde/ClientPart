package com.android3.siegertpclient.ui.createtournament

import android.content.Context
import android.text.TextUtils
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.data.tournament.tournamentsource.TournamentRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.Constants.Companion.MATCH_TYPE
import com.android3.siegertpclient.utils.Constants.Companion.PARTICIPANT_FORM
import com.android3.siegertpclient.utils.Constants.Companion.TOURNAMENT_TYPE
import com.android3.siegertpclient.utils.LocalCache
import com.android3.siegertpclient.utils.OnlineChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateTournamentPresenter(private val context: Context) : BasePresenter<CreateTournamentContract.ICreateTournamentView>(), CreateTournamentContract.ICreateTournamentPresenter{
    private var onlineChecker = OnlineChecker(context)

    private var tournamentRepo = TournamentRepo(context)

    override fun onBackBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onCreateBtnClicked(
        name: String,
        typeOfGame: String,
        matchType: String,
        tournamentType: String,
        participantForm: String,
        registrationDeadline: String,
        startTime: String,
        endTime: String,
        location: String,
        maxParticipantNumber: Int
    ) {
        view?.showProgress()

        when {
            TextUtils.isEmpty(name) or TextUtils.isEmpty(typeOfGame)
                    or TextUtils.isEmpty(registrationDeadline) or TextUtils.isEmpty(startTime) or TextUtils.isEmpty(endTime)
                    or TextUtils.isEmpty(location) -> {
                view?.showIncompleteInput()
                view?.hideProgress()
            }
            matchType == MATCH_TYPE -> {
                view?.showError("Please select a match type")
                view?.hideProgress()
            }
            tournamentType == TOURNAMENT_TYPE -> {
                view?.showError("Please select a tournament type")
                view?.hideProgress()
            }
            participantForm == PARTICIPANT_FORM -> {
                view?.showError("Please select a participant form")
                view?.hideProgress()
            }
            !validDateDifference(startTime, endTime) -> {
                view?.showError("End date must ends after start date")
                view?.hideProgress()
            }
            !onlineChecker.isOnline() -> {
                view?.showNoInternetConnection()
                view?.hideProgress()
            }
            else -> {
                val tournamentDetail = TournamentDetail(LocalCache.getCurrentUserId(context)!!, endTime, location, participantForm, registrationDeadline, startTime, tournamentType, typeOfGame)

                GlobalScope.launch(Dispatchers.IO) {
                    try {
                        val tournament = tournamentRepo.createNewTournament(matchType, maxParticipantNumber, name, tournamentDetail)
                        if (tournament != null) {
                            withContext(Dispatchers.Main) {
                                view?.showSuccess()
                                view?.hideProgress()
                                view?.navigateToTournamentActivity()
                            }
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            view?.showError(e.message.toString())
                            //view?.showError("Oops... It seems there's unexpected error. Please try again.")
                            view?.hideProgress()
                        }
                    }
                }
            }
        }
    }

    private fun validDateDifference(start: String, end: String): Boolean {
        val startYear = start.substring(0,3).toInt()
        val startMonth = start.substring(5,6).toInt()
        val startDate = start.substring(8,9).toInt()

        val endYear = end.substring(0,3).toInt()
        val endMonth = end.substring(5,6).toInt()
        val endDate = end.substring(8,9).toInt()

        if ((endYear - startYear) < 0) {
            return false
        }

        if (endYear - startYear == 0) {
            if(endMonth - startMonth < 0) {
                return false
            }
        }

        if (endYear - startYear == 0) {
            if(endMonth - startMonth == 0) {
                if(endDate - startDate < 0) {
                    return false
                }
            }
        }

        return true
    }
}