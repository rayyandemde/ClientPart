package com.android3.siegertpclient.data.setting.settingsource.settingLocal;

import com.android3.siegertpclient.data.setting.Setting;

import org.jetbrains.annotations.NotNull;


public class SettingLocalDataSource {

    final SettingDao settingDao;

    public SettingLocalDataSource(SettingDao settingDao) {
        this.settingDao = settingDao;
    }

    public boolean check(@NotNull String Language) {

        if(Language.equals("English"))  {
            return true;
        }
        if(Language.equals("German")){
            return true;
        }
        return false;
    }

    public void saveSetting(@NotNull Setting newSetting) {
        settingDao.insertSetting(newSetting);
    }

}
