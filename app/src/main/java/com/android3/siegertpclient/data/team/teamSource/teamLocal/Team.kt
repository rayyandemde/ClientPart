package com.android3.siegertpclient.data.team.teamSource.teamLocal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Team(
    @PrimaryKey(autoGenerate = true)
    var teamId: Int,
    @ColumnInfo(name = "team_name") var teamName: String,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "member_list") var memberList: List<String>,

)

data class Member(  @ColumnInfo(name = "member_list") var memberList : List<String>,)