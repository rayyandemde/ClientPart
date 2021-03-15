package com.android3.siegertpclient.ui.invitation

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
class InvitationActivityTest {


    /**
     * To test if the back button can navigate to homepage.
     */
    @Test
    fun test_NavToHomepage() {
        //set up
        val activityScenario = ActivityScenario.launch(InvitationActivity::class.java)
        //Nav fragment to createteam page
        onView(withId(R.id.backBtnInvitation)).perform(click())
        onView(withId(R.id.homepage_container)).check(matches(isDisplayed()))

    }
}