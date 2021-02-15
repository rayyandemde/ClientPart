package com.android3.siegertpclient.data

interface IPreference {
    val currentUserLoggedInMode:Int
    var currentUserId:Long
    var currentUserName:String
    var currentUserEmail:String
    var currentUserProfilePicUrl:String
    var accessToken:String
    fun setCurrentUserLoggedInMode(mode: IDataManager.LoggedInMode)
}