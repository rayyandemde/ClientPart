package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentLocal

import androidx.room.*
import com.android3.siegertpclient.data.tournament.ParticipantList
import com.android3.siegertpclient.data.tournament.Tournament

@Dao
interface TournamentDao {
    @Insert
    fun insertTournaments(vararg tournaments: Tournament?)

    @Update
    fun updateTournaments(vararg tournaments: Tournament?)

    @Delete
    fun deleteTournaments(vararg tournaments: Tournament?)

    @Query("DELETE FROM Tournament")
    fun deleteAllTournaments()

    @get:Query("SELECT * FROM Tournament ORDER BY tournamentId DESC")
    val allTournaments: List<Tournament?>?

    @Query("SELECT * FROM Tournament WHERE tournament_name = :name")
    fun findTournamentByName(name: String?): Tournament?

    @Query(
        "SELECT * FROM Tournament WHERE tournament_name LIKE '%' || :keyword || '%' " +
                "OR tournament_types Like '%' || :keyword || '%'" +
                "OR location LIKE '%' || :keyword || '%'" +
                "OR type_of_game LIKE '%' || :keyword || '%'" +
                "OR registration_deadline LIKE '%' || :keyword || '%'" +
                "OR start_time LIKE '%' || :keyword || '%'" +
                "OR end_time LIKE '%' || :keyword || '%'" +
                "OR participant_form LIKE '%' || :keyword || '%'"
    )
    fun getTournamentsBvyKeyword(keyword: String?): List<Tournament?>?

    @Query("SELECT participant_list FROM Tournament WHERE tournamentId = :id")
    fun findParticipant(id: Int): ParticipantList
}