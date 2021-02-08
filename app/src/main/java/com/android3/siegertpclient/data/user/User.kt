package com.android3.siegertpclient.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(@field:ColumnInfo(name = "user_name") var userName: String,
           @field:ColumnInfo(name = "vorname") var vorName: String, @field:ColumnInfo(name = "surname") var surName: String,
           @field:ColumnInfo(name = "email") var email: String, @field:ColumnInfo(name = "password") var password: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}