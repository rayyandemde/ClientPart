package com.android3.siegertpclient.data.setting.settingsource.settingLocal

import com.android3.siegertpclient.data.Result.Result
import com.android3.siegertpclient.data.setting.Setting

class SettingLocalDataSource(val settingDao: SettingDao) {
    /**
    fun check(Language: String): Boolean {
        if (Language == "English") {
            return true
        }
        return if (Language == "German") {
            true
        } else false
    }**/

    fun saveSetting(newSetting: Setting) {
        settingDao.insertSetting(newSetting)
    }
    fun getSetting(){
        settingDao.allSettings
    }
    fun deleteSetting(){
        settingDao.deleteAllSetting()
    }
    fun updateSetting(setting:Setting){
        settingDao.updateSetting(setting)
    }
}