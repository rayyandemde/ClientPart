package com.android3.siegertpclient.ui.team

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R

class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val dummyImageView: ImageView = itemView.findViewById<ImageView>(R.id.dummy_image)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.dummy_overview)
}
