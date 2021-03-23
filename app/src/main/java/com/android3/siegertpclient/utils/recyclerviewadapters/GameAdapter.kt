package com.android3.siegertpclient.utils.recyclerviewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.databinding.CardGameOverviewBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.GameAdapter.GameHolder

class GameAdapter(private val listener: OnGameItemClickListener) : RecyclerView.Adapter<GameHolder>() {

    private var gameList = emptyList<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(
            CardGameOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
    }

    override fun getItemCount() = gameList.size

    fun setData(newList: List<Game>) {
        gameList = newList
        notifyDataSetChanged()
    }

    inner class GameHolder(val binding: CardGameOverviewBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onGameItemClick(position)
            }
        }
    }

    interface OnGameItemClickListener {
        fun onGameItemClick(position: Int)
    }
}
