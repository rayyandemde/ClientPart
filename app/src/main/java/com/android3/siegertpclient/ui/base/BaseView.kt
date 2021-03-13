package com.android3.siegertpclient.ui.base

interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showError(errorMessage: String)

    fun showNoInternetConnection()
}