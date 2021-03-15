package com.android3.siegertpclient.ui.login

import LoginContract
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

class LoginPresenter(private val context: Context) : BasePresenter<LoginContract.ILoginView>(),
    LoginContract.ILoginPresenter {

    private var onlineChecker = OnlineChecker(context)

    private var userRepo = UserRepo(context)

    override fun checkSession() {
        if (userRepo.checkUserLoggedIn()) {
            view?.navigateToHomepageActivity()
        }
    }

    override fun onLoginBtnClicked(email: String, password: String) {
        view?.showProgress()

        when {
            TextUtils.isEmpty(email) or TextUtils.isEmpty(password) -> {
                view?.showIncompleteInput()
                view?.hideProgress()
            }

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                view?.showErrorOnEmail()
                view?.hideProgress()
            }
            else -> {
                if (onlineChecker.isOnline()) {
                    FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener({ task ->
                            if (task.isSuccessful) {
                                val firebaseUser = task.result!!.user!!

                                firebaseUser.getIdToken(true).addOnCompleteListener({ task2 ->
                                    if (task2.isSuccessful()) {
                                        val token = task2.result!!.token!!
                                        val tokenBearer = "Bearer ".plus(token)
                                        GlobalScope.launch(Dispatchers.IO) {
                                            try {
                                                val user = userRepo.getUserById(
                                                    firebaseUser.uid,
                                                    tokenBearer
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

    override fun onForgotPasswordTextClicked() {
        view?.navigateToForgotPasswordActivity()
    }

    override fun onRegisterTextClicked() {
        view?.navigateToRegisterActivity()
    }
}