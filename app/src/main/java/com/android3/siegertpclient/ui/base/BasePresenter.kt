package com.android3.siegertpclient.base

import androidx.annotation.StringRes

open class BasePresenter<V : BaseView> {

    var view: V? = null

    fun onAttach(view: V) {
        this.view = view
    }

    fun onDetach() {
        view = null
    }
}