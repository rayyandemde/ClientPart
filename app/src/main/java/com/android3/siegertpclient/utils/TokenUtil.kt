package com.android3.siegertpclient.utils

import com.google.firebase.auth.FirebaseAuth

class TokenUtil {
    companion object {
        fun getBearerToken(): String {
            var token = "Bearer "
            val auth = FirebaseAuth.getInstance()
            val user = auth.currentUser
            user?.getIdToken(true)?.addOnSuccessListener { it ->
                token += it.token.toString()
            }
            return token
        }
    }
}