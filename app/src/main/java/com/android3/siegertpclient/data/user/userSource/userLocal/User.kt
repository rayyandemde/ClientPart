package com.android3.siegertpclient.data.user.userSource.userLocal

import android.app.Notification
import androidx.room.*
import com.android3.siegertpclient.data.tournament.tournamentSource.tournamentLocal.GameList
import com.android3.siegertpclient.data.tournament.tournamentSource.tournamentLocal.ParticipantConverter
import com.android3.siegertpclient.data.tournament.tournamentSource.tournamentLocal.ParticipantList
import com.android3.siegertpclient.data.tournament.tournamentSource.tournamentLocal.Tournament

@Entity
class User(
    @field:ColumnInfo(name = "user_name") var userName: String,
    @field:ColumnInfo(name = "vorname") var vorName: String,
    @field:ColumnInfo(name = "surname") var surName: String,
    @field:ColumnInfo(name = "email") var Email: String,
    @field:ColumnInfo(name = "password") var password: String,
    @TypeConverters(RoomConverter::class)
    @field:ColumnInfo(name = "notification_list") var notificationList: NotificationList,

    @TypeConverters(RoomConverter::class)
    @field:ColumnInfo(name = "team_list") var teamList: TeamList,

    @TypeConverters(RoomConverter::class)
    @field:ColumnInfo(name = "tournament_list") var tournamentList: TournamentList
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}


data class TeamList(
    val teamList: ArrayList<String> = ArrayList()
)
data class NotificationList(
    val notificationList: ArrayList<String> = ArrayList()
)

data class TournamentList(
    val tournamentList: ArrayList<String> = ArrayList()
)
class RoomConverter {
    @TypeConverter
    fun toTeamList(value: String?): TeamList {
        if (value == null || value.isEmpty()) {
            return TeamList()
        }

        val list: List<String> = value.split(",")
        val stringList = ArrayList<String>()
        for (item in list) {
            if (!item.isEmpty()) {
                stringList.add(item.toString())
            }
        }
        return TeamList(stringList)
    }
    @TypeConverter
    fun toString(teamList: TeamList?):String{
        var string = ""

        if (teamList == null) {
            return string
        }

        teamList.teamList.forEach {
            string += "$it,"
        }
        return string
    }
    @TypeConverter
    fun toNotificationList(value: String?):NotificationList {
        if (value == null || value.isEmpty()) {
            return NotificationList()
        }

        val list: List<String> = value.split(",")
        val stringList = ArrayList<String>()
        for (item in list) {
            if (!item.isEmpty()) {
                stringList.add(item.toString())
            }
        }
        return NotificationList(stringList)
    }
    @TypeConverter
    fun toString(notificationList: NotificationList?): String {

        var string = ""

        if (notificationList == null) {
            return string
        }

       notificationList.notificationList.forEach {
            string += "$it,"
        }
        return string
    }
    @TypeConverter
    fun toTournamentList(value: String?): TournamentList {
        if (value == null || value.isEmpty()) {
            return TournamentList()
        }

        val list: List<String> = value.split(",")
        val stringList = ArrayList<String>()
        for (item in list) {
            if (!item.isEmpty()) {
                stringList.add(item.toString())
            }
        }
        return TournamentList(stringList)
    }
    @TypeConverter
    fun toString(tournamentList: TournamentList?):String{
        var string = ""

        if (tournamentList == null) {
            return string
        }

        tournamentList.tournamentList.forEach {
            string += "$it,"
        }
        return string
    }
}
