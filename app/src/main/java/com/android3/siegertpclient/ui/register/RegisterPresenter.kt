package com.android3.siegertpclient.ui.register

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterPresenter(private val context: Context) :
    BasePresenter<RegisterContract.IRegisterView>(), RegisterContract.IRegisterPresenter {

    private var onlineChecker = OnlineChecker(context)

    private var userRepo = UserRepo(context)

    override fun onRegisterBtnClicked(
        email: String,
        password: String,
        retypePassword: String,
        surname: String,
        forename: String,
        username: String
    ) {
        view?.showProgress()

        when {
            TextUtils.isEmpty(email) or TextUtils.isEmpty(password)
                    or TextUtils.isEmpty(retypePassword) or TextUtils.isEmpty(surname)
                    or TextUtils.isEmpty(forename) or TextUtils.isEmpty(username) -> {
                view?.showIncompleteInput()
                view?.hideProgress()
            }

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                view?.showErrorOnEmail()
                view?.hideProgress()
            }

            password != retypePassword -> {
                view?.showErrorOnPassword()
                view?.hideProgress()
            }
            else -> {
                if (onlineChecker.isOnline()) {
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener({ task ->
                            if (task.isSuccessful) {
                                val firebaseUser = task.result!!.user!!

                                firebaseUser.getIdToken(true).addOnCompleteListener({ task2 ->
                                    if (task2.isSuccessful()) {
                                        val token = task2.result!!.token!!
                                        val tokenBearer = "Bearer ".plus(token)
                                        GlobalScope.launch(Dispatchers.IO) {
                                            try {
                                                val user = userRepo
                                                    .createNewUser(
                                                        username, forename,
                                                        surname, firebaseUser.uid, tokenBearer
                                                    )
                                                if (user != null) {
                                                    withContext(Dispatchers.Main) {
                                                        view?.navigateToHomepageActivity()
                                                    }
                                                }
                                            } catch (e: Exception) {
                                                withContext(Dispatchers.Main) {
                                                    view?.hideProgress()
                                                    view?.showError("Oops... It seems there's unexpected error. Please try again.")
                                                }
                                            }
                                        }
                                    } else {
                                        view?.hideProgress()
                                        view?.showError(task2.exception!!.message.toString())
                                    }
                                })
                            } else {
                                view?.hideProgress()
                                view?.showError(task.exception!!.message.toString())
                            }

                        })
                } else {
                    view?.hideProgress()
                    view?.showNoInternetConnection()
                }
            }
        }
    }

    override fun onLoginTxtClicked() {
        view?.navigateToLoginActivity()
    }
}