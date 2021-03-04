package com.android3.siegertpclient.utils

import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class TokenUtil {
    companion object {
        fun getBearerToken(): String {
            var tokenBearer = "Bearer "
            val user = FirebaseAuth.getInstance().currentUser!!
            user.getIdToken(true)
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful()) {
                        val tokenCode = task.result!!.token!!
                        tokenBearer.plus(tokenCode)
                    } else {
                        Log.e("Token Error", task.exception!!.message.toString())
                    }
                })
            return tokenBearer
        }
    }
}