package com.android3.siegertpclient.data.game

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey
    var gameId: String,
    @ColumnInfo(name = "time") var time: String,
    @ColumnInfo(name = "result") var result: String,
    @ColumnInfo(name = "typeOfGame") var typeOfGame: String,
    @ColumnInfo(name = "firstParticipantId") var firstParticipantId: String,
    @ColumnInfo(name = "secondParticipantId") var secondParticipantId: String,
    @ColumnInfo(name = "firstParticipantResult") var firstParticipantResult: String,
    @ColumnInfo(name = "secondParticipantResult") var secondParticipantResult: String,
    @ColumnInfo(name = "firstParticipantScore") var firstParticipantScore: String,
    @ColumnInfo(name = "secondParticipantScore") var secondParticipantScore: String,

)

