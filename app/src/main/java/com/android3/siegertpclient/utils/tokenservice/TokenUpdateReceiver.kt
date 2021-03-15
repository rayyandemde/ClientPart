package com.android3.siegertpclient.utils.tokenservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

//Still error
class TokenUpdateReceiver : BroadcastReceiver() {
    companion object {
        const val REQUEST_CODE = 12345
        const val ACTION = "com.android3.siegertpclient"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val i = Intent(context, TokenUpdateJobIntentService::class.java)
        context?.startService(i)
    }
}