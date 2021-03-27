package com.android3.siegertpclient.data.tournament

import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentRemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class TournamentRemoteDataSourceTest {

    private var tournamentRemote = TournamentRemoteDataSource()
    private var tourneyDetail = TournamentDetail("", "", "", "",
        "", "", "", "")

    @Ignore//add  @JvmSuppressWildcards to Interface necessary
    @Test
    fun responseSuccessfulCreateNewTournament() = runBlocking {
        var answer = tournamentRemote.createNewTournament("", 32, "name", tourneyDetail, "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulCreateGames() = runBlocking {
        var answer = tournamentRemote.createGames("name","123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulDeleteGameById() = runBlocking {
        var answer = tournamentRemote.deleteGameById("name", "123", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulDeleteTournament() = runBlocking {
        var answer = tournamentRemote.deleteTournament("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetGameById() = runBlocking {
        var answer = tournamentRemote.getGameById("name", "123", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTournamentById() = runBlocking {
        var answer = tournamentRemote.getTournamentById("", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTournamentByName() = runBlocking {
        var answer = tournamentRemote.getTournamentByName("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTournamentGames() = runBlocking {
        var answer = tournamentRemote.getTournamentGames("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTournamentParticipantsTeam() = runBlocking {
        var answer = tournamentRemote.getTournamentParticipantsTeam("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTournamentParticipantsUser() = runBlocking {
        var answer = tournamentRemote.getTournamentParticipantsUser("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulHandleParticipation() = runBlocking {
        var answer = tournamentRemote.handleParticipation("name", "SINGLE", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulUpdateGameById() = runBlocking {
        var answer = tournamentRemote.updateGameById("name",
            game = Game("", "", result = Result("", "", ""),
                "", ""),"123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulUpdateTournamentDetail() = runBlocking {
        var answer = tournamentRemote.updateTournamentDetail("name", tourneyDetail, "123")
        Assert.assertNotEquals(null, answer)
    }
}