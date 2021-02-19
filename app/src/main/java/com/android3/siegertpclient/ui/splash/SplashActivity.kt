package com.android3.siegertpclient.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.login.LoginActivity

class SplashActivity : BaseActivity() ,SplashContract.ISplashView{

    private val splashPresenter: SplashPresenter = SplashPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }, 1000)
    }

    override fun onResume() {
        super.onResume()
        splashPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter.onDetach()
    }

    override fun navigateToLoginActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        TODO("Not yet implemented")
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