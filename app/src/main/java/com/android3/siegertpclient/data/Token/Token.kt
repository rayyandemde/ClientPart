package com.android3.siegertpclient.data.Token

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Token(
    @PrimaryKey
    var token : String,
    @ColumnInfo(name = "idtoken") var idtoken: String,

    @ColumnInfo(name = "refreshtoken") var refreshtoken: String,

    )

