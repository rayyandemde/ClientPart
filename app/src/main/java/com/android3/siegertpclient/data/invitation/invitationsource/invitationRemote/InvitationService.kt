package com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote

import com.android3.siegertpclient.data.invitation.Invitation
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface InvitationService {

    @POST("invitations")
    fun createInvitation(@Body senderId : String, recipientId : String, tournamentId : String,
                         participantForm : String, @Header("currentUserId") ownUserId: String) : Response<Invitation>

    @POST("invitations/{id}")
    fun handleInvitationAcceptation(@Path("username") username: String,
                                    @Path("id") invitationId: String, @Body accept : Boolean,//TODO add name for boolean
                                    @Header("currentUserId") ownUserId: String)

}