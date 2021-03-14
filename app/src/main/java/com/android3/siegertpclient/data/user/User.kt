package com.android3.siegertpclient.data.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val forename: String,
    val invitationList: List<String>,
    val surname: String,
    val teamList: List<String>,
    val tournamentList: List<String>,
    val userId: String,
    val username: String
) : Parcelable