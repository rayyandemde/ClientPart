package com.android3.siegertpclient.utils.tokenservice

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import androidx.core.app.JobIntentService
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

//Still so many errors so its on pending
class TokenUpdateJobIntentService : JobIntentService() {
    companion object {
        const val TAG = "TestService"
        // var isRunning = false

        fun enqueueWork(context: Context, work: Intent) {
            enqueueWork(context, TokenUpdateJobIntentService::class.java, 123, work)
        }

        fun stopHandle() {
            Log.d(TAG, "Process Stopped...")
            // isRunning = false
        }
    }

    override fun onHandleWork(intent: Intent) {
        // isRunning = true
        Log.d(TAG, "onHandleWork")
        /*
        for(i in 1..5) {
            Log.d(TAG, "This is :: $i")
            SystemClock.sleep(1000)
        }
        while (isRunning) {
            try {
                val user = FirebaseAuth.getInstance().currentUser
                if (user != null) {
                    user.getIdToken(true).addOnCompleteListener({ task ->
                        if (task.isSuccessful) {
                            val token = task.result!!.token!!
                            val tokenBearer = "Bearer ".plus(token)
                            Log.d(TAG, "You got new token :: $tokenBearer")
                            SystemClock.sleep(20000)
                        } else {
                            Log.e(TAG, "Error getting Token")
                            SystemClock.sleep(20000)
                        }
                    })
                }
                Log.e(TAG, "User haven't logged in yet exist yet")
                SystemClock.sleep(20000)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }*/
        try {
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                user.getIdToken(true).addOnCompleteListener({ task ->
                    if (task.isSuccessful) {
                        val token = task.result!!.token!!
                        val tokenBearer = "Bearer ".plus(token)
                        Log.d(TAG, "You got new token :: $tokenBearer")
                    } else {
                        Log.e(TAG, "Error getting Token")
                    }
                })
            }
            Log.e(TAG, "User haven't logged in yet")
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }


    /*
    init {
        instance = this
    }

    companion object {
        private lateinit var instance: TokenUpdateIntentService
        var isRunning = false

        fun stopService() {
            Log.d("TheService", "Service is stopping...")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("TheService", "Service is running...")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            Log.e("TheService", "Service failed...")
        }
    }*/
}