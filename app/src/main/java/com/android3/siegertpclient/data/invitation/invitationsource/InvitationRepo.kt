package com.android3.siegertpclient.data.invitation.invitationsource

import android.content.Context
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationRemoteDataSource
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.utils.LocalCache
import com.android3.siegertpclient.utils.PreferencesProvider
import java.time.LocalDate

/**
 * Invitation repository that calls the remote and local data source.
 */
class InvitationRepo(private val context: Context) {
    private val invitationRemoteDataSource = InvitationRemoteDataSource()
    private var localData = PreferencesProvider(context)

    suspend fun createInvitation(recipientId: String): ApiResponse? {
        var currentTournament = localData.getCurrentTournament()!!

        val response = invitationRemoteDataSource.createInvitation(
            LocalCache.getCurrentUserId(context)!!,
            recipientId,
            currentTournament.tournamentId,
            currentTournament.tournamentDetail.participantForm,
            LocalCache.getBearerToken(context)!!
        )
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun handleInvitationAcceptation(invitationID: String, accept: Boolean): ApiResponse? {
        val response = invitationRemoteDataSource.handleInvitationAcceptation(
            invitationID,
            accept,
            LocalCache.getBearerToken(context)!!
        )
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    fun getCurrentUserInvitations() : List<Invitation> {
        return localData.getCurrentInvitationList()
    }
}