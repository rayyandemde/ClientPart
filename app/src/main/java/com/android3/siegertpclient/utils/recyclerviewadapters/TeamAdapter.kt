package com.android3.siegertpclient.utils.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.CardTeamOverviewBinding
import com.android3.siegertpclient.databinding.CardUserOverviewBinding
import com.android3.siegertpclient.databinding.TournamentOverviewCardBinding

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.TeamHolder>() {

    private var teamList = emptyList<Team>()

    class TeamHolder(val binding: CardTeamOverviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val teamOverViewTv = binding.tvTeamOverview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.TeamHolder {
        return TeamAdapter.TeamHolder(
            CardTeamOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        val current = teamList[position]
        holder.teamOverViewTv.text = current.teamName
    }

    override fun getItemCount() = teamList.size

    fun setData(newList: List<Team>) {
        teamList = newList
        notifyDataSetChanged()
    }
}
