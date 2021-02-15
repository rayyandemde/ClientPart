package com.android3.siegertpclient.data

import android.content.Context

class DataManager : IDataManager {

    private lateinit var context: Context
    private lateinit var preference: IPreference

    override fun updateApiHeader(userId: Long, accessToken: String) {
        TODO("Not yet implemented")
    }

    override fun setUserAsLoggedOut() {
        TODO("Not yet implemented")
    }

    override fun updateUserInfo(accessToken: String, userId: Long, loggedInMode: IDataManager.LoggedInMode, userName: String, email: String) {
        TODO("Not yet implemented")
    }

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