package com.android3.siegertpclient.ui.base

open class BasePresenter<V : BaseView> {

    var view: V? = null

    fun onAttach(view: V) {
        this.view = view
    }

    fun onDetach() {
        view = null
    }
}