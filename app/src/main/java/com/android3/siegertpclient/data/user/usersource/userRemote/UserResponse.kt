package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.user.User
import com.google.gson.annotations.SerializedName

data class UserResponse (val data : List<singleUser>) {

    data class singleUser(
        @SerializedName("userId")val userId : String?,
    @SerializedName("city_name") val city: String?,
    @SerializedName("rh") val relativeHumidity: Double?,
    @SerializedName("wind_spd") val windSpeed: Double?)


}