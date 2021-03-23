package com.android3.siegertpclient.ui.tournament

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamMemberBinding
import com.android3.siegertpclient.databinding.FragmentTournamentdetailsBinding
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
    fun showTournamentDetails() {
        TODO("Not yet implemented")
    }

    fun showJoinTournamentSuccessful(message: String) {
        TODO("Not yet implemented")
    }

    override fun showTournamentDetailsFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentParticipantsFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentScheduleFragment() {
        TODO("Not yet implemented")
    }

    override fun showResultFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentUpdatesFragment() {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }

    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }

}