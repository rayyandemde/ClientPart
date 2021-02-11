package com.android3.siegertpclient.data.setting.settingSource.settingLocal

import androidx.room.*
import com.android3.siegertpclient.data.setting.Setting

@Dao
interface SettingDao {
    @Insert
    fun insertSetting(vararg settings: Setting?)

    @Update
    fun updateSetting(vararg settings: Setting?)

    @Delete
    fun deleteSetting(vararg settings: Setting?)

    @Query("DELETE FROM Setting")
    fun deleteAllSetting()

    @get:Query("SELECT * FROM Setting ORDER BY fullname DESC")
    val allSettings: List<Setting?>?

    @Query("SELECT * FROM Setting WHERE fullname = :name")
    fun findTeamByName(name: String?): Setting?
}