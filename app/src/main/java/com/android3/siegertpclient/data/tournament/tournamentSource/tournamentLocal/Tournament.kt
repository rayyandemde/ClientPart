package com.android3.siegertpclient.data.tournament.tournamentSource.tournamentLocal
import androidx.room.ColumnInfo
import  androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Tournament(
    @PrimaryKey(autoGenerate = true)
    var tournamentId: Int,
    @ColumnInfo(name = "participant_form") var participantForm: String,
    @ColumnInfo(name = "admin_id") var adminId: Int,
    @ColumnInfo(name = "tournament_name") var tournamentName: String,
    @ColumnInfo(name = "tournament_types") var tournamentTypes: String,
    @ColumnInfo(name = "type_of_game") var TypeOfGame: String,
    @ColumnInfo(name = "location") var location: String,
    @ColumnInfo(name = "registration_deadline") var registrationDeadline: String,
    @ColumnInfo(name = "start_time") var startTime: String,
    @ColumnInfo(name = "end_time") var endTime: String,
    @ColumnInfo(name = "participant_list") var participantList: List<String>,
    @ColumnInfo(name = "game_list") var gameList: List<String>
)


data class Participant(  @ColumnInfo(name = "participant_list") var participantList: List<String>,)