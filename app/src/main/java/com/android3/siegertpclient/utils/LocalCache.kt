package com.android3.siegertpclient.utils

import android.content.Context

class LocalCache {
    companion object {
        fun getBearerToken(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_TOKEN)
        }

        fun getCurrentTeamName(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_TEAM_NAME)
        }
    }
}