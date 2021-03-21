package com.android3.siegertpclient.utils.recyclerviewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.databinding.CardTeamOverviewBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.TeamAdapter.TeamHolder

class TeamAdapter(private val listener: OnTeamItemClickListener) : RecyclerView.Adapter<TeamHolder>() {

    private var teamList = emptyList<Team>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        return TeamHolder(
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

    inner class TeamHolder(val binding: CardTeamOverviewBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        val teamOverViewTv = binding.tvTeamOverview

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onTeamItemClick(position)
            }
        }
    }

    interface OnTeamItemClickListener {
        fun onTeamItemClick(position: Int)
    }
}
