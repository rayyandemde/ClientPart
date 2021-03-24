package com.android3.siegertpclient.utils.recyclerviewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.databinding.CardScheduleOverviewBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.ScheduleAdapter.ScheduleHolder

class ScheduleAdapter(private val listener: OnScheduleItemClickListener) : RecyclerView.Adapter<ScheduleHolder>() {

    private var scheduleList = emptyList<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        return ScheduleHolder(
            CardScheduleOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
    }

    override fun getItemCount() = scheduleList.size

    fun setData(newList: List<Game>) {
        scheduleList = newList
        notifyDataSetChanged()
    }

    inner class ScheduleHolder(val binding: CardScheduleOverviewBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        val scheduleOverviewTv = binding.tvScheduleOverview

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onScheduleItemClick(position)
            }
        }
    }

    interface OnScheduleItemClickListener {
        fun onScheduleItemClick(position: Int)
    }
}
