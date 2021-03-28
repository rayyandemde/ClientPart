package com.android3.siegertpclient.ui.createteam



import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
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
import com.android3.siegertpclient.ui.ToastMatcher
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.login.LoginActivity

@RunWith(AndroidJUnit4ClassRunner::class)
class CreateTeamActivityTest{

    /**
     * To test if click the button can navigate to team page.
     */
    @Test
    fun test_NavToTeamPage() {
        //Given
        val activityScenario = ActivityScenario.launch(CreateTeamActivity::class.java)
        val expected_email = "115@111.com"
        val password = "111111"

        //enter some input
        onView(withId(R.id.et_team_name)).perform(ViewActions.typeText(expected_email))
        onView(withId(R.id.et_password)).perform(ViewActions.typeText(password))
        onView(withId(R.id.btn_create)).perform(click())

        onView(withId(R.id.team_container)).check(matches(isDisplayed()))
    }
}