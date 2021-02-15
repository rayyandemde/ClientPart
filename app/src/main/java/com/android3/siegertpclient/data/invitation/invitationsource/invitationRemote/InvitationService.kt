package com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote

import com.android3.siegertpclient.data.invitation.Invitation
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface InvitationService {

    @POST("invitations")
    fun createInvitation(@Body invitation: Invitation) : Response<Invitation>

}