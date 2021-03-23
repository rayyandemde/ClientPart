package com.android3.siegertpclient.utils.recyclerviewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.databinding.CardTournamentOverviewBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.TournamentAdapter.TournamentHolder

class TournamentAdapter(private val listener: OnTournamentItemClickListener) : RecyclerView.Adapter<TournamentHolder>() {

    private var tournamentList = emptyList<Tournament>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentHolder {
        return TournamentHolder(
            CardTournamentOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TournamentHolder, position: Int) {
    }

    override fun getItemCount() = tournamentList.size

    fun setData(newList: List<Tournament>) {
        tournamentList = newList
        notifyDataSetChanged()
    }

    inner class TournamentHolder(val binding: CardTournamentOverviewBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onTournamentItemClick(position)
            }
        }
    }

    interface OnTournamentItemClickListener {
        fun onTournamentItemClick(position: Int)
    }
}
