package com.android3.siegertpclient.utils

import com.android3.siegertpclient.data.tournament.LeagueTournament
import com.android3.siegertpclient.data.tournament.Tournament2
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentService2
import com.android3.siegertpclient.data.user.usersource.userRemote.UserService2
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.BASE_URL
import com.google.gson.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.reflect.Type

object RestClient2 {
    /*
    object TournamentDeserializer : JsonDeserializer<Tournament2> {
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): Tournament2 {
            val obj = json!!.asJsonObject
            val type = obj!!.get("type").asString
            val currentState = obj!!.get("currentState").asString
            val gameList = obj!!.get("currentState").asJsonObject

            when {
                type.equals("League", ignoreCase = true) -> {
                    return LeagueTournament(currentState, listOf("a"), "", true, listOf("b"), "")
                }
                type.equals("KnockOut", ignoreCase = true) -> {

                }
                type.equals("KnockOutWithGroup", ignoreCase = true) -> {

                }
            }
        }
    }*/

    object TournamentSerializer : JsonSerializer<Tournament2> {
        override fun serialize(
            src: Tournament2?,
            typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement {
            TODO("Not yet implemented")
        }
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /*
    private val tournamentRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(getTournamentGson()))
            .build()
    }*/

    val userService: UserService2 by lazy {
        retrofit.create(UserService2::class.java)
    }

/*
    val tournamentService: TournamentService2 by lazy {
        tournamentRetrofit.create(TournamentService2::class.java)
    }


    private fun getTournamentGson(): Gson {
        return GsonBuilder().registerTypeAdapter(Tournament2::class.java, TournamentDeserializer)
            .registerTypeAdapter(Tournament2::class.java, TournamentSerializer).create()
    }*/
}