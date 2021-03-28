package com.android3.siegertpclient.ui.userprofile

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.ToastMatcher
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class UserProfileActivityTest{
    /**
     * To test navigation to my tournamnet page.
     */
    @Test
    fun test_Nav_mytournament_fragment() {
        //Given
        val activityScenario = ActivityScenario.launch(UserProfileActivity::class.java)

        //to see if toast is displayed to show incomplete information
        onView(ViewMatchers.withId(R.id.navigation_my_tournament)).perform(ViewActions.click())
        onView(withId(R.id.mytournaments_container)).check((matches(isDisplayed())))
    }

    /**
     * To see if the toast can be show when we don't input email.
     */
    @Test
    fun test_Nav_mytwam_fragment() {
        //Given
        val activityScenario = ActivityScenario.launch(UserProfileActivity::class.java)

        //to see if toast is displayed to show incomplete information
        onView(ViewMatchers.withId(R.id.navigation_my_tournament)).perform(ViewActions.click())
        onView(withId(R.id.mytournaments_container)).check((matches(isDisplayed())))
    }



}