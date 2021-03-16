package com.android3.siegertpclient.ui.dummyretrofit.util

class Constants {
    companion object {
        //App REST API base URL
        const val BASE_URL = "https://sieger-teamthree.herokuapp.com/"

        //SharedPreference keys
        //Token & Session
        const val KEY_TOKEN = "KEY_TOKEN"
        const val IS_LOGGED_IN = "IS_LOGGED_IN"

        //User
        const val KEY_USER = "KEY_USER"
        const val KEY_USER_ID = "KEY_USER_ID"
        const val KEY_FORENAME = "KEY_FORENAME"
        const val KEY_SURNAME = "KEY_SURNAME"
        const val KEY_USERNAME = "KEY_USERNAME"

        //Tournament
        const val KEY_CURRENT_TOURNAMENT = "KEY_CURRENT_TOURNAMENT"

        //Team
        const val KEY_CURRENT_TEAM = "KEY_CURRENT_TEAM"
        const val KEY_TEAM_NAME = "KEY_TEAM_NAME"
    }
}