package com.android3.siegertpclient.data.setting.settingsource.settingLocal

import com.android3.siegertpclient.data.Result.Result
import com.android3.siegertpclient.data.setting.Setting

/**
 * class setting local data source is used to set the local data source.
 */
class SettingLocalDataSource(val settingDao: SettingDao) {

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