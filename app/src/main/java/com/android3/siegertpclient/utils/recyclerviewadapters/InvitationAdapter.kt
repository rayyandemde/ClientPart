package com.android3.siegertpclient.utils.recyclerviewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.databinding.CardInvitationOverviewBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.InvitationAdapter.InvitationHolder

class InvitationAdapter(private val listener: OnInvitationItemClickListener) : RecyclerView.Adapter<InvitationHolder>() {

    private var invitationList = emptyList<Invitation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvitationHolder {
        return InvitationHolder(
            CardInvitationOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InvitationHolder, position: Int) {
        val current = invitationList[position]
        holder.invitationOverviewTv.text = "You've been invited too : " + current.tournamentName + "\n" + "By " + current.senderUsername
    }

    override fun getItemCount() = invitationList.size

    fun setData(newList: List<Invitation>) {
        invitationList = newList
        notifyDataSetChanged()
    }

    inner class InvitationHolder(val binding: CardInvitationOverviewBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        val invitationOverviewTv = binding.tvInvitationOverview

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onInvitationItemClick(position)
            }
        }
    }

    interface OnInvitationItemClickListener {
        fun onInvitationItemClick(position: Int)
    }
}
