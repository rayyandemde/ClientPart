package com.android3.siegertpclient.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GetTokenResult

class TokenUtil {

    companion object {
        fun getBearerToken(): String {
            var token = "Bearer "
            val auth = FirebaseAuth.getInstance()
            val user = auth.currentUser
            token += user?.getIdToken(true)?.result?.token
            return token
        }
    }
}