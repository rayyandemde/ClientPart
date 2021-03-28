package com.android3.siegertpclient.ui.homepage


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
@RunWith(AndroidJUnit4ClassRunner::class)
class HomepageActivityTest{
    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToCreateTournament() {
        //set up
        val activityScenario = ActivityScenario.launch(HomepageActivity::class.java)

        //Nav Fragment createTournament
        onView(withId(R.id.navigation_createtournament)).perform(click())

        //vertify
        onView(withId(R.id.create_tournament_container)).check(matches(isDisplayed()))


    }
    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToJoinTeam() {
        //set up
        val activityScenario = ActivityScenario.launch(HomepageActivity::class.java)

        //Nav fragment to jointeam page
        onView(withId(R.id.navigation_jointeam)).perform(click())
        onView(withId(R.id.join_team_container)).check(matches(isDisplayed()))
    }

    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToUserprofile() {
        //set up
        val activityScenario = ActivityScenario.launch(HomepageActivity::class.java)
        //Nav fragment to userprofile page
        onView(withId(R.id.navigation_userprofile)).perform(click())
        onView(withId(R.id.userprofile_container)).check(matches(isDisplayed()))

    }

    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToCreateTeam() {
        //set up
        val activityScenario = ActivityScenario.launch(HomepageActivity::class.java)
        //Nav fragment to createteam page
        onView(withId(R.id.navigation_createteam)).perform(click())
        onView(withId(R.id.create_team_container)).check(matches(isDisplayed()))

    }
}