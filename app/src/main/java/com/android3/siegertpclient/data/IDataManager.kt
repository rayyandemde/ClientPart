package com.android3.siegertpclient.data

interface IDataManager : IPreference{

    fun updateApiHeader(userId: Long, accessToken: String)
    fun setUserAsLoggedOut()

    fun updateUserInfo(
            accessToken: String,
            userId: Long,
            loggedInMode: LoggedInMode,
            userName: String,
            email: String)

    enum class LoggedInMode private constructor(type: Int){
        LOGGED_IN(0),
        LOGGED_OUT(1);

        val type: Int

        init{
            this.type = type
        }
    }
}