package com.android3.siegertpclient.data.team

import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamRemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class TeamRemoteDataSourceTest {

    private var teamRemote = TeamRemoteDataSource()

    @Test
    fun responseSuccessfulDeleteTeam() = runBlocking{
        var answer = teamRemote.deleteTeam("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Ignore//add  @JvmSuppressWildcards to Interface necessary
    @Test
    fun responseSuccessfulCreateNewTeam() = runBlocking{
        var answer = teamRemote.createNewTeam("", "name", "123", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTeamById() = runBlocking{
        var answer = teamRemote.getTeamById("123", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTeamByName() = runBlocking{
        var answer = teamRemote.getTeamByName("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTeamInvitations() = runBlocking{
        var answer = teamRemote.getTeamInvitations("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTeamMembers() = runBlocking{
        var answer = teamRemote.getTeamMembers("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulGetTeamTournaments() = runBlocking{
        var answer = teamRemote.getTeamTournaments("name", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulJoinTeam() = runBlocking{
        var answer = teamRemote.joinTeam("name", "123", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulKickTeamMember() = runBlocking{
        var answer = teamRemote.kickTeamMember("name", "123", "123")
        Assert.assertNotEquals(null, answer)
    }

    @Test
    fun responseSuccessfulQuitTeam() = runBlocking{
        var answer = teamRemote.quitTeam("name", "123")
        Assert.assertNotEquals(null, answer)
    }
}