package com.android3.siegertpclient.ui.tournament

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamMemberBinding
import com.android3.siegertpclient.databinding.FragmentTournamentdetailsBinding
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.team.TeamPresenter
import com.android3.siegertpclient.utils.recyclerviewadapters.UserAdapter
import java.util.*

class TournamentDetailsFragment : Fragment() , TournamentContract.ITournamentView{
    private var _binding: FragmentTournamentdetailsBinding? = null
    private val binding get() = _binding!!

    private var tournamentPresenter: TournamentPresenter? = null

    private var day: Int? = null
    private var month: Int? = null
    private var year: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTournamentdetailsBinding.inflate(inflater, container, false)
        tournamentPresenter = TournamentPresenter(requireContext())

        tournamentPresenter?.initTournamentDetails()
        tournamentPresenter?.checkEditRights()

        day = 0
        month = 0
        year = 0

        var tournamentNameEt = binding.etTournamentName

        binding.btnRegistrationDeadline.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    val monthCalibrate = monthOfYear + 1
                    binding.btnRegistrationDeadline.text = "$year-$monthCalibrate-$dayOfMonth"

                },
                year!!,
                month!!,
                day!!
            ).show()
        }

        binding.btnStartDate.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val monthCalibrate = monthOfYear + 1
                    binding.btnStartDate.text = "$year-$monthCalibrate-$dayOfMonth"
                },
                year!!,
                month!!,
                day!!
            ).show()
        }

        binding.btnEndDate.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val monthCalibrate = monthOfYear + 1
                    binding.btnEndDate.text = "$year-$monthCalibrate-$dayOfMonth"
                },
                year!!,
                month!!,
                day!!
            ).show()
        }

        var locationEt = binding.etLocation

        binding.btnUpdateDetails.setOnClickListener {
            val tournamentName = editTextTrimmer(tournamentNameEt)
            val registrationDeadline = binding.btnRegistrationDeadline.text.toString()
            val startTime = binding.btnStartDate.text.toString()
            val endTime = binding.btnEndDate.text.toString()
            val location = editTextTrimmer(locationEt)

            tournamentPresenter?.onUpdateBtnClicked(
                tournamentName,
                registrationDeadline,
                startTime,
                endTime,
                location,
            )
        }

        binding.btnHome.setOnClickListener {
            tournamentPresenter?.onHomeBtnClicked()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        tournamentPresenter?.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        tournamentPresenter?.onDetach()
        _binding = null
    }

    override fun showCurrentTournamentDetails(
        tournamentName: String,
        typeOfGame: String,
        matchType: String,
        tournamentType: String,
        participantForm: String,
        registrationDeadline: String,
        startDate: String,
        endDate: String,
        location: String,
        maxPlayer: Int
    ) {
        binding.etTournamentName.setText(tournamentName)
        binding.tvTypeOfGame.text = typeOfGame
        binding.tvMatchType.text = matchType
        binding.tvTournamentType.text = tournamentType
        binding.tvParticipantForm.text = participantForm
        binding.btnRegistrationDeadline.text = registrationDeadline
        binding.etLocation.setText(location)
        binding.tvMaxPlayer.text = maxPlayer.toString()
    }

    override fun disableEdits() {
        binding.etTournamentName.isEnabled = false
        binding.btnRegistrationDeadline.isEnabled = false
        binding.btnStartDate.isEnabled = false
        binding.btnEndDate.isEnabled = false
        binding.etLocation.isEnabled = false
        binding.btnUpdateDetails.isEnabled = false
    }

    override fun showIncompleteInput() {
        doToast("Please input all of the field")
    }

    override fun showSingleParticipants(participants: List<User>?) {
        //Not implemented here
    }

    override fun showTeamParticipants(participants: List<Team>?) {
        //Not implemented here
    }

    override fun showSchedules(schedules: List<Game>?) {
        //Not implemented here
    }

    override fun showGames(games: List<Game>?) {
        //Not implemented here
    }

    override fun navigateToHomepageActivity() {
        val intent = Intent(activity, HomepageActivity::class.java)
        startActivity(intent)
    }

    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnUpdateDetails.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRequest.visibility = View.GONE
        binding.btnUpdateDetails.isEnabled = true
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }

    private fun editTextTrimmer(editText: EditText): String {
        return editText.text.toString().trim { it <= ' ' }
    }

    private fun doToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}