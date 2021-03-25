package com.android3.siegertpclient.ui.setting

import android.content.Context
import android.text.TextUtils
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
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
            val currentUser = userRepo.getCurrentUser()
            var newUsername =
                if (TextUtils.isEmpty(changedUsername)) currentUser!!.username else changedUsername
            var newForename =
                if (TextUtils.isEmpty(changedForename)) currentUser!!.forename else changedForename
            var newSurname =
                if (TextUtils.isEmpty(changedSurname)) currentUser!!.surname else changedSurname

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val user = userRepo.updateUserDetail(
                        newUsername,
                        newSurname,
                        newForename)
                    if (user != null) {
                        withContext(Dispatchers.Main) {
                            view?.showSuccessful()
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