package com.android3.siegertpclient.utils

import android.content.Context

class LocalCache {
    companion object {
        fun getBearerToken(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_TOKEN)
        }

        fun getCurrentUserId(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_USER_ID)
        }

        fun getCurrentUsername(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_USERNAME)
        }

        fun getCurrentFirstName(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_FORENAME)
        }

        fun getCurrentLastName(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_SURNAME)
        }

        fun getCurrentTournamentId(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_TOURNAMENT_ID)
        }

        fun getCurrentTournamentName(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_TOURNAMENT_NAME)
        }

        fun getCurrentTeamId(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_TEAM_ID)
        }

        fun getCurrentTeamName(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_TEAM_NAME)
        }

        fun getCurrentInvitationId(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_INVITATION_ID)
        }
    }
}