package com.android3.siegertpclient.utils

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class TokenUtil {
    companion object {
        fun getBearerToken() : String {
            var tokenBearer = "Bearer "

            val user = FirebaseAuth.getInstance().currentUser!!
            user.getIdToken(true)
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful()) {
                        val tokenCode = task.result!!.token!!
                        tokenBearer = tokenBearer.plus(tokenCode)
                        Log.i("TokenSuccess", tokenBearer)
                    } else {
                        Log.e("TokenError", task.exception!!.message.toString())
                    }
                })
            Log.i("TokenCheck", tokenBearer)
            return tokenBearer
        }
    }
}