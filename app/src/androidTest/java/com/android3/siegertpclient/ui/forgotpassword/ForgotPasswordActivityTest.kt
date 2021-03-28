package com.android3.siegertpclient.ui.forgotpassword

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.ToastMatcher
import com.android3.siegertpclient.ui.login.LoginActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ForgotPasswordActivityTest{
    /**
     * To see if the toast can be show when we don't input email.
     */
    @Test
    fun test_toast_incompleteInfo() {
        //Given
        val activityScenario = ActivityScenario.launch(ForgotPasswordActivity::class.java)

        //to see if toast is displayed to show incomplete information
        onView(ViewMatchers.withId(R.id.btn_send)).perform(click())
        onView(withText("Email address is not valid"))
            .inRoot(ToastMatcher())
            .check(ViewAssertions.matches(isDisplayed()))

    }
}