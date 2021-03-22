package com.android3.siegertpclient.utils

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
        const val KEY_USER_TEAMS = "KEY_USER_TEAMS"

        //Tournament
        const val KEY_CURRENT_TOURNAMENT = "KEY_CURRENT_TOURNAMENT"
        const val KEY_TOURNAMENT_ID = "KEY_TOURNAMENT_ID"
        const val KEY_TOURNAMENT_NAME = "KEY_TOURNAMENT_NAME"

        //Team
        const val KEY_CURRENT_TEAM = "KEY_CURRENT_TEAM"
        const val KEY_TEAM_ID = "KEY_TEAM_ID"
        const val KEY_TEAM_NAME = "KEY_TEAM_NAME"

        //Invitation
        const val KEY_INVITATION_ID = "KEY_INVITATION_ID"
    }
}