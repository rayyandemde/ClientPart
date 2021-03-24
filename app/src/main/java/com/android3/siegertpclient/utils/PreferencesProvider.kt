package com.android3.siegertpclient.utils

import android.content.Context
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.Constants.Companion.KEY_CURRENT_TEAM
import com.android3.siegertpclient.utils.Constants.Companion.KEY_CURRENT_TOURNAMENT
import com.android3.siegertpclient.utils.Constants.Companion.KEY_GAME_LIST
import com.android3.siegertpclient.utils.Constants.Companion.KEY_INVITATION_LIST
import com.android3.siegertpclient.utils.Constants.Companion.KEY_TEAM_LIST
import com.android3.siegertpclient.utils.Constants.Companion.KEY_TOURNAMENT_LIST
import com.android3.siegertpclient.utils.Constants.Companion.KEY_USER
import com.android3.siegertpclient.utils.Constants.Companion.KEY_USER_LIST
import com.google.gson.Gson

class PreferencesProvider(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("appPreferences", Context.MODE_PRIVATE)

    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String) : Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key : String) : String? {
        return sharedPreferences.getString(key, "")
    }

    fun putCurrentUser(user: User) {
        val json = Gson().toJson(user)
        putString(KEY_USER, json)
    }

    fun getCurrentUser() : User? {
        val json = getString(KEY_USER)
        return if (json != null) Gson().fromJson(json, User::class.java) else null
    }

    fun putCurrentUserList(users: List<User>) {
        val json = Gson().toJson(users)
        putString(KEY_USER_LIST, json)
    }

    fun getCurrentUserList() : List<User> {
        var json = getString(KEY_USER_LIST)
        return if (json != null) Gson().fromJson(json) else listOf()
    }

    fun putCurrentTournament(tournament : Tournament) {
        var json = Gson().toJson(tournament)
        putString(KEY_CURRENT_TOURNAMENT, json)
    }

    fun getCurrentTournament() : Tournament? {
        val json = getString(KEY_CURRENT_TOURNAMENT)
        return if (json != null) Gson().fromJson(json, Tournament::class.java) else null
    }

    fun putCurrentTournamentList(tournaments: List<Tournament>) {
        val json = Gson().toJson(tournaments)
        putString(KEY_TOURNAMENT_LIST, json)
    }

    fun getCurrentTournamentList() : List<Tournament> {
        var json = getString(KEY_TOURNAMENT_LIST)
        return if (json != null) Gson().fromJson(json) else listOf()
    }

    fun putCurrentGameList(games: List<Game>) {
        val json = Gson().toJson(games)
        putString(KEY_GAME_LIST, json)
    }

    fun getCurrentGameList() : List<Game> {
        var json = getString(KEY_GAME_LIST)
        return if (json != null) Gson().fromJson(json) else listOf()
    }

    fun putCurrentTeam(team : Team) {
        val json = Gson().toJson(team)
        putString(KEY_CURRENT_TEAM, json)
    }

    fun getCurrentTeam() : Team? {
        val json = getString(KEY_CURRENT_TEAM)
        return if (json != null) Gson().fromJson(json, Team::class.java) else null
    }

    fun putCurrentTeamList(teams: List<Team>) {
        val json = Gson().toJson(teams)
        putString(KEY_TEAM_LIST, json)
    }

    fun getCurrentTeamList() : List<Team> {
        var json = getString(KEY_TEAM_LIST)
        return if (json != null) Gson().fromJson(json) else listOf()
    }

    fun putCurrentInvitationList(invitations: List<Invitation>) {
        val json = Gson().toJson(invitations)
        putString(KEY_INVITATION_LIST, json)
    }

    fun getCurrentInvitationList() : List<Invitation> {
        var json = getString(KEY_INVITATION_LIST)
        return if (json != null) Gson().fromJson(json) else listOf()
    }

    fun clearData() {
        sharedPreferences.edit().clear().apply()
    }
}