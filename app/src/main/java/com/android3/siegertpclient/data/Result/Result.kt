package com.android3.siegertpclient.data.Result

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Result (
    @PrimaryKey
    var gameId: String,
    @ColumnInfo(name = "firstParticipantId") var firstParticipantId: String,
    @ColumnInfo(name = "secondParticipantId") var secondParticipantId: String,
    @ColumnInfo(name = "firstParticipantResult") var firstParticipantResult: String,
    @ColumnInfo(name = "secondParticipantResult") var secondParticipantResult: String,
    @ColumnInfo(name = "firstParticipantScore") var firstParticipantScore: String,
    @ColumnInfo(name = "secondParticipantScore") var secondParticipantScore: String,
)
