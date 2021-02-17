package com.android3.siegertpclient.data.setting.settingsource.settingLocal

import com.android3.siegertpclient.data.setting.Setting

class SettingLocalDataSource(val settingDao: SettingDao) {
    fun check(Language: String): Boolean {
        if (Language == "English") {
            return true
        }
        return if (Language == "German") {
            true
        } else false
    }

    fun saveSetting(newSetting: Setting) {
        settingDao.insertSetting(newSetting)
    }
}