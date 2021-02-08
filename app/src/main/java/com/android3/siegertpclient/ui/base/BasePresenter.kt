package com.android3.siegertpclient.base

import androidx.annotation.StringRes

interface BasePresenter<V : BaseView> {

    fun onAttach(view: V)

    fun onDetach()
}