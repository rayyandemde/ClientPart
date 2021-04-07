package com.android3.siegertpclient.ui.createtournament


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
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
import com.android3.siegertpclient.ui.createteam.CreateTeamActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.login.LoginActivity

@RunWith(AndroidJUnit4ClassRunner::class)
class CreateTournamentActivityTest{

    /**
     * To test if click the button can navigate to team page.
     */
    @Test
    fun test_validCreate() {
        //Given
        val activityScenario = ActivityScenario.launch(CreateTournamentActivity::class.java)
        val Tournamentname = "bibi"
        val typename = "ball"

        //enter some input
        onView(withId(R.id.et_tournament_name)).perform(ViewActions.typeText(Tournamentname))
        onView(withId(R.id.et_type_of_game)).perform(ViewActions.typeText(typename))
        Espresso.pressBack();
        onView(withId(R.id.btn_create)).perform(click())

        onView(withText("Please input all of the field"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }
}