package com.android3.siegertpclient.data.user.userSource.userLocal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @field:ColumnInfo(name = "user_name") var userName: String,
    @field:ColumnInfo(name = "vorname") var vorName: String,
    @field:ColumnInfo(name = "surname") var surName: String,
    @field:ColumnInfo(name = "email") var Email: String,
    @field:ColumnInfo(name = "password") var password: String,
    @field:ColumnInfo(name = "notification_list") var notificationList: List<String>,
    @field:ColumnInfo(name = "team_list") var teamList: List<String>,
    @field:ColumnInfo(name = "tournament_list") var tournamentList: List<String>
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}
data class TeamOfUser(  @ColumnInfo(name = "team_list") var teamList : List<String>,)

data class TournamentOfUser(  @ColumnInfo(name = "tournament_list") var tournamentList : List<String>,)

data class NotificationOfUser(  @ColumnInfo(name = "Notification_list") var NotificationList : List<String>,)