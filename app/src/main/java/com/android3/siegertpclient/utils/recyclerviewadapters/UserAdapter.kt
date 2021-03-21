package com.android3.siegertpclient.utils.recyclerviewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.CardUserOverviewBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.UserAdapter.UserHolder

class UserAdapter(private val listener: OnUserItemClickListener) :
    RecyclerView.Adapter<UserHolder>() {

    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            CardUserOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val current = userList[position]
        holder.userOverviewTv.text =
            current.username + " | " + current.surname + ", " + current.forename
    }

    override fun getItemCount() = userList.size

    fun setData(newList: List<User>) {
        userList = newList
        notifyDataSetChanged()
    }

    inner class UserHolder(val binding: CardUserOverviewBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        val userOverviewTv = binding.tvUserOverview

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onUserItemClick(position)
            }
        }
    }

    interface OnUserItemClickListener {
        fun onUserItemClick(position: Int)
    }
}
