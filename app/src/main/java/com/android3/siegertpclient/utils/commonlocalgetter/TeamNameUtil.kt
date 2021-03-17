package com.android3.siegertpclient.utils.commonlocalgetter

import android.content.Context
import com.android3.siegertpclient.utils.Constants
import com.android3.siegertpclient.utils.PreferencesProvider

class TeamNameUtil {
    companion object {
        fun getCurrentTeamName(context: Context) : String? {
            val localData = PreferencesProvider(context)
            return localData.getString(Constants.KEY_TEAM_NAME)
        }
    }
}