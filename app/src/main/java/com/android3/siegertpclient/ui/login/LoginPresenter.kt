package com.android3.siegertpclient.ui.login

import LoginContract
import android.content.Context
import com.android3.siegertpclient.ui.base.BasePresenter
import com.google.firebase.auth.FirebaseAuth


class LoginPresenter() : BasePresenter<LoginContract.ILoginView>(), LoginContract.ILoginPresenter{
    private lateinit var auth: FirebaseAuth
    override fun onLoginBtnClicked(email: String, password: String) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.getIdToken(true)?.addOnSuccessListener { it ->
                        var token = it.token
                        //use the token
                    }
                } else {
                    view?.showError("Login failed, check your email and password")
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