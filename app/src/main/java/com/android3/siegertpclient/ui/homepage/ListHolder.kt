package com.android3.siegertpclient.ui.homepage

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R

class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val dummyImageView: ImageView = itemView.findViewById<ImageView>(R.id.dummy_imageL)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.dummy_overviewL)
}
