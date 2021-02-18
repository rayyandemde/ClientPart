package com.android3.siegertpclient.data.userdummy.usersource.userRemote

import com.android3.siegertpclient.data.user.NotificationList
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.google.gson.annotations.SerializedName

data class UserResponseDummy (
    val username : String,
    val surname : String,
    val forename : String,
    @SerializedName("userId")
    val userId : String,
    @SerializedName("userTournamentList")
    val tournamentList: TournamentList,
    val notificationList: NotificationList,
    val teamList: TeamList,
    val invitationList : String
)
