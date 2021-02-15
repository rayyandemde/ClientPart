package com.android3.siegertpclient.data

import android.content.SharedPreferences

class Preference : IPreference {

    private lateinit var preferences: SharedPreferences

    override val currentUserLoggedInMode: Int
        get() = TODO("Not yet implemented")
    override var currentUserId: Long
        get() = TODO("Not yet implemented")
        set(value) {}
    override var currentUserName: String
        get() = TODO("Not yet implemented")
        set(value) {}
    override var currentUserEmail: String
        get() = TODO("Not yet implemented")
        set(value) {}
    override var currentUserProfilePicUrl: String
        get() = TODO("Not yet implemented")
        set(value) {}
    override var accessToken: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun setCurrentUserLoggedInMode(mode: IDataManager.LoggedInMode) {
        TODO("Not yet implemented")
    }
}