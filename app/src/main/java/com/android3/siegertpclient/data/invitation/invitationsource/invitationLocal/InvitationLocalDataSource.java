package com.android3.siegertpclient.data.invitation.invitationsource.invitationLocal;

import com.android3.siegertpclient.data.invitation.Invitation;
import com.android3.siegertpclient.data.setting.Setting;
import com.android3.siegertpclient.data.setting.settingsource.settingLocal.SettingDao;

import org.jetbrains.annotations.NotNull;

public class InvitationLocalDataSource {

        final InvitationDao invitationDao;

    public InvitationLocalDataSource(InvitationDao invitationDao) {
        this.invitationDao = invitationDao;
    }

        public void saveInvitation(@NotNull Invitation newInvitation) {
            invitationDao.insertInvitation(newInvitation);
        }

    }


