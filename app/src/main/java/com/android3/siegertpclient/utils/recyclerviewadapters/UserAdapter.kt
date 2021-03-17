package com.android3.siegertpclient.utils.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.CardUserOverviewBinding

class UserAdapter :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {

    private var userList = emptyList<User>()

    class UserHolder(val binding: CardUserOverviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val userOverviewTv = binding.tvUserOverview
    }

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
}
