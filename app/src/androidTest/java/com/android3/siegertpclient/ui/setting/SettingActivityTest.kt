package com.android3.siegertpclient.ui.setting



import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.matcher.ViewMatchers.*
import com.android3.siegertpclient.ui.homepage.HomepageActivity

@RunWith(AndroidJUnit4ClassRunner::class)
class SettingActivityTest {
    /**
     * To test if the go back button works.

    @Test
    fun test_NavToUserprofile() {
        //set up
        val activityScenario = ActivityScenario.launch(SettingActivity::class.java)

        onView(withId(R.id.fab_back)).perform(click())

        onView(withId(R.id.userprofile_container)).check(matches(isDisplayed()))


    }
*/
    /**
     * To test if the homepage button can work.
     */
    @Test
    fun test_NavToHomepage() {
        //set up
        val activityScenario = ActivityScenario.launch(SettingActivity::class.java)

        onView(withId(R.id.tv_logout)).perform(click())
        onView(withId(R.id.login_container)).check(matches(isDisplayed()))
    }

}