package com.android3.siegertpclient.ui.dummyretrofit.util.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.databinding.TournamentOverviewCardBinding

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.CardHolder>() {
    class CardHolder(val binding: TournamentOverviewCardBinding) : RecyclerView.ViewHolder(binding.root) {
        // private val dummyImageView: ImageView = itemView.findViewById<ImageView>(R.id.dummy_image)
        // private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.dummy_overview)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val image = holder.binding.dummyImage
        val text = holder.binding.dummyOverview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        /*
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.tournament_overview_card, parent, false)
        return CardHolder(cardItem)*/
        return CardHolder(TournamentOverviewCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}
