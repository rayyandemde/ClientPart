package com.android3.siegertpclient.data.game.gamesource.gameRemote

import com.google.gson.annotations.SerializedName
import java.util.*

data class GameResponse (
    val gameId: String,
    val time: Date,
    val result: String,
    val firstParticipantId: String,
    val secondParticipantId: String
)
//TODO differ between two different results

data class ResultResponse (
    @SerializedName("resultType")
    val type : String,
    val firstParticipantResult : String,
    val secondParticipantResult : String,
    @SerializedName("ignore")//2 variables named type last one is auto generated and can be ignored
    val type2 : String
    )