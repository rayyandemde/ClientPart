package com.android3.siegertpclient.data.setting.settingSource.settingLocal

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Setting(
    @ColumnInfo(name = "language") var language: String,
    @ColumnInfo(name = "fullname") var fullName: String,

    )
