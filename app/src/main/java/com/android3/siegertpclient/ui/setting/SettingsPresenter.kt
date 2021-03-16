package com.android3.siegertpclient.ui.setting

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_FORENAME
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_SURNAME
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_USER
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_USERNAME
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.utils.OnlineChecker
import com.android3.siegertpclient.utils.PreferencesProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SettingsPresenter(private val context: Context) :
    BasePresenter<SettingsContract.ISettingView>(), SettingsContract.ISettingPresenter {

    private var onlineChecker = OnlineChecker(context)
    private var preferencesProvider = PreferencesProvider(context)

    private var userRepo = UserRepo(context)

    fun getUser(): String {
        val username = preferencesProvider.getString(KEY_USERNAME)!!
        val user = preferencesProvider.getUser()
        val forename = user!!.forename
        val surname = user!!.surname
        return "Username :: $username \nFirst Name :: $forename \nLast Name :: $surname"
    }

    override fun onBackBtnClicked() {
        view?.navigateToUserProfileActivity()
    }

    override fun onChangeLanguageSpinnerSelected() {
        //Not yet implemented
    }

    override fun onSaveBtnClicked(
        changedUsername: String,
        changedForename: String,
        changedSurname: String
    ) {
        view?.showProgress()

        if (!onlineChecker.isOnline()) {
            view?.showNoInternetConnection()
            view?.hideProgress()
        } else {
            val currentUser = userRepo.getUserLocal()
            var newUsername =
                if (TextUtils.isEmpty(changedUsername)) currentUser!!.username else changedUsername
            var newForename =
                if (TextUtils.isEmpty(changedForename)) currentUser!!.forename else changedForename
            var newSurname =
                if (TextUtils.isEmpty(changedSurname)) currentUser!!.surname else changedSurname
            val token = userRepo.getToken()

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val user = userRepo.updateUserDetail(
                        currentUser!!.username,
                        newUsername,
                        newSurname,
                        newForename,
                        token!!
                    )
                    if (user != null) {
                        withContext(Dispatchers.Main) {
                            view?.setTestUserText()
                            view?.hideProgress()
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        view?.showError("Oops... It seems there's unexpected error. Please try again.")
                        view?.hideProgress()
                    }
                }
            }
        }
    }

    override fun onLogoutTextClicked() {
        FirebaseAuth.getInstance().signOut()
        preferencesProvider.clearData()
        view?.navigateToLoginActivity()
    }

}