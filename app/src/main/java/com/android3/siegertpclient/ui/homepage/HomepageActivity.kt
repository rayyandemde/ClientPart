package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity

class HomepageActivity : BaseActivity() {

    private val homepagePresenter: HomepagePresenter = HomepagePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
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