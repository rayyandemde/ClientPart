package com.android3.siegertpclient.data.team.teamsource

import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamRemoteDataSource
import com.android3.siegertpclient.utils.RestClient

class TeamRepo {

    private val restClient = RestClient()
    private val teamService = restClient.getTeamService()

    var teamRemote = TeamRemoteDataSource(teamService)
}