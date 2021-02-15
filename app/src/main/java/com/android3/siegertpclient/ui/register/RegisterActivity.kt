package com.android3.siegertpclient.ui.register

import android.os.Bundle
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity

class RegisterActivity : BaseActivity() {

    private val registerPresenter: RegisterPresenter = RegisterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }

}