package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class HomepageDummyActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_dummy)

        // Enables Always-on
        setAmbientEnabled()
    }
}