package com.android3.siegertpclient.base

import androidx.annotation.StringRes

interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showError(errorMessage: String)

    fun showError(@StringRes errorId : Int)
}