package com.android3.siegertpclient.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamMemberBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.UserAdapter

class TeamMemberFragment : Fragment(), TeamContract.ITeamView {
    private var _binding: FragmentTeamMemberBinding? = null
    private val binding get() = _binding!!

    private var teamPresenter: TeamPresenter? = null

    private val userAdapter by lazy { UserAdapter() }

    //
    private var testDummyUsers: List<User>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamMemberBinding.inflate(inflater, container, false)
        teamPresenter = TeamPresenter(requireContext())

        binding.rvTeamMember.adapter = userAdapter

        val noUser = User("no user", listOf("aa"), "are", listOf("aa"), listOf("aa"), "aaId","There")
        val dummyUser2 = User("bbFN", listOf("bb"), "bbSN", listOf("bb"), listOf("bb"), "bbId","bbUN")
        val dummyUser3 = User("ccFN", listOf("bb"), "ccSN", listOf("cc"), listOf("cc"), "ccId","ccUN")

        //userAdapter.setData(listOf(noUser))
        //binding.tvNoUsers.visibility = View.VISIBLE
        teamPresenter?.onMembersRefresh()

        binding.srlRvTeamMember.setOnRefreshListener {
            teamPresenter?.onMembersRefresh()
        }

        binding.btnAdd.setOnClickListener {

        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        teamPresenter?.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        teamPresenter?.onDetach()
    }

    override fun navigateToTournamentActivity() {
        TODO("Not yet implemented")
    }

    override fun showMembers(teamMembers: List<User>) {
        userAdapter.setData(teamMembers)
        //binding.tvNoUsers.visibility = View.GONE
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        binding.srlRvTeamMember.isRefreshing = false
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun doToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}