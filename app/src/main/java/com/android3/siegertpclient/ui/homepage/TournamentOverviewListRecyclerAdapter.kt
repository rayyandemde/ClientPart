package com.android3.siegertpclient.ui.homepage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R

class TournamentOverviewListRecyclerAdapter : RecyclerView.Adapter<ListHolder>() {

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        //not yet implemented
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        var listItem = LayoutInflater.from(parent?.context).inflate(R.layout.tournament_overview_list, parent, false)
        return ListHolder(listItem)
    }
}
