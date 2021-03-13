package com.android3.siegertpclient.data.setting

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity Setting of the class.
 */
@Entity
data class Setting(
    @ColumnInfo(name = "language") var language: String,
    @PrimaryKey
    var fullName: String,


    )
