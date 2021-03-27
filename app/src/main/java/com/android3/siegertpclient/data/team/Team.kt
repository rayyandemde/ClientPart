package com.android3.siegertpclient.data.team

data class Team(
    val adminId: String,
    val invitationList: List<String>,
    val memberList: List<String>,
    val teamId: String,
    val teamName: String,
    val teamPassword: String,
    val tournamentList: List<String>
)