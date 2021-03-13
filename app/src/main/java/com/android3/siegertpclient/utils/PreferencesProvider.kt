package com.android3.siegertpclient.utils

import android.content.Context

class PreferencesProvider(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("appPreferences", Context.MODE_PRIVATE)

    fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key : String) : String? {
        return sharedPreferences.getString(key, null)
    }
}