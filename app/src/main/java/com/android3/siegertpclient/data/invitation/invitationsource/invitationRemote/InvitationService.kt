package com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote

import com.android3.siegertpclient.data.invitation.invitationsource.Invitation
import retrofit2.Response
import retrofit2.http.*

interface InvitationService {

    @POST("invitations")
    fun createInvitation(@Body senderId : String, recipientId : String, tournamentId : String,
                         participantForm : String, @Header("currentUserId") ownUserId: String) : Response<Invitation>

    @POST("invitations/{id}")
    fun handleInvitationAcceptation(@Path("username") username: String,
                                    @Path("id") invitationId: String, @Body accept : Map<String, Boolean>,
                                    @Header("currentUserId") ownUserId: String)

}