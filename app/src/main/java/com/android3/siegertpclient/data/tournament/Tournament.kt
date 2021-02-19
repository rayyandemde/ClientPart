package com.android3.siegertpclient.data.tournament
import androidx.room.*

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentState
import com.android3.siegertpclient.utils.TournamentTypesUtil

@Entity
data class Tournament(
    @PrimaryKey
    var tournamentId: String,
    @ColumnInfo(name = "participant_form") var participantForm: ParticipantFormUtil,
    @ColumnInfo(name = "admin_id") var adminId:String,
    @ColumnInfo(name = "tournament_types") var tournamentTypes: TournamentTypesUtil,
    @ColumnInfo(name = "type_of_game") var TypeOfGame: String,
    @ColumnInfo(name = "location") var location: String,
    @ColumnInfo(name = "registration_deadline") var registrationDeadline: String,
    @ColumnInfo(name = "start_time") var startTime: String,
    @ColumnInfo(name = "end_time") var endTime: String,
    @ColumnInfo(name = "tournament_name") var tournamentName: String,
    var maxParticipantNumber : Int,
    var currentState : TournamentState,

    @TypeConverters(ParticipantConverter::class)
    @ColumnInfo(name = "participant_list") var participantList: ParticipantList?,

    @TypeConverters(ParticipantConverter::class)
    @ColumnInfo(name = "game_list") var gameList: GameList?,

    )

data class GameList(
    val gameList: ArrayList<String> = ArrayList()
)

data class ParticipantList(
    val participantList: ArrayList<String> = ArrayList()
)
class ParticipantConverter {
    @TypeConverter
    fun toParticipantList(value: String?): ParticipantList {
        if (value == null || value.isEmpty()) {
            return ParticipantList()
        }

        val list: List<String> = value.split(",")
        val stringList = ArrayList<String>()
        for (item in list) {
            if (!item.isEmpty()) {
                stringList.add(item.toString())
            }
        }
        return ParticipantList(stringList)
    }
    @TypeConverter
    fun toString(participantList: ParticipantList?): String {

        var string = ""

        if (participantList == null) {
            return string
        }

        participantList.participantList.forEach {
            string += "$it,"
        }
        return string
    }
    @TypeConverter
    fun toGameList(value: String?): GameList {
        if (value == null || value.isEmpty()) {
            return GameList()
        }

        val list: List<String> = value.split(",")
        val stringList = ArrayList<String>()
        for (item in list) {
            if (!item.isEmpty()) {
                stringList.add(item.toString())
            }
        }
        return GameList(stringList)
    }
    @TypeConverter
    fun toString(gameList: GameList?): String {

        var string = ""

        if (gameList == null) {
            return string
        }

        gameList.gameList.forEach {
            string += "$it,"
        }
        return string
    }

}


