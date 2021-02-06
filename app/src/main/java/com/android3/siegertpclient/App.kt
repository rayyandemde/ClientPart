package com.android3.siegertpclient

import android.app.Application

open class App : Application() {

    companion object {
        private var instance: Application? = null

        val getInstance: Application
            get() {
                if (instance == null) {
                    synchronized(Application::class.java) {
                        if (instance == null) {
                            instance = App()
                        }
                    }
                }
                return instance!!
            }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}