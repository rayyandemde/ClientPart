package com.android3.siegertpclient.ui.tournament

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R

class TournamentOverviewCardRecyclerAdapter : RecyclerView.Adapter<CardHolder>() {

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        //Not yet implemented
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.tournament_overview_card, parent, false)
        return CardHolder(cardItem)
    }
}
