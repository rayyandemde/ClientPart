package com.android3.siegertpclient.data.invitation.invitationsource

import android.content.Context
import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationRemoteDataSource
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.utils.LocalCache

/**
 * Invitation repository that calls the remote and local data source.
 */
class InvitationRepo(private val context: Context) {
    private val invitationRemoteDataSource = InvitationRemoteDataSource()

    suspend fun createInvitation(recipientId: String): ApiResponse? {
        val response = invitationRemoteDataSource.createInvitation(
            LocalCache.getCurrentUserId(context)!!,
            recipientId,
            LocalCache.getCurrentTournamentId(context)!!,
            LocalCache.getCurrentTournamentParticipantForm(context)!!,
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
}