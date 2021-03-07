package com.android3.siegertpclient.ui.dummyretrofit.model

data class User(
    val forename: String,
    val invitationList: List<String>,
    val surname: String,
    val teamList: List<String>,
    val tournamentList: List<String>,
    val userId: String,
    val username: String
)