package com.android3.siegertpclient.data.user

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("username")
    val username : String,
    @SerializedName("surname")
    val surname : String,
    @SerializedName("forename")
    val forename : String,
    @SerializedName("userId")
    val userId : String,
    @SerializedName("tournamentList")
    val tournamentList: List<String>,
    @SerializedName("teamList")
    val teamList: List<String>,
    @SerializedName("invitationList")
    val invitationList : List<String>
)