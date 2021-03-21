package com.android3.siegertpclient.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class OnlineChecker(private val context: Context) {

    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    fun isOnline() : Boolean {
        val capability =
            cm.getNetworkCapabilities(cm.activeNetwork)
        return capability?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    }
}