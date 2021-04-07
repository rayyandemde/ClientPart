package com.android3.siegertpclient.ui.team


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
class TeamActivityTest{
    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToTeamMember() {
        //set up
        val activityScenario = ActivityScenario.launch(TeamActivity::class.java)

        //Nav Fragment createTournament
        onView(withId(R.id.navigation_team_member)).perform(click())

        //vertify
        onView(withId(R.id.member_container)).check(matches(isDisplayed()))


    }
    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToTeamTournament() {
        //set up
        val activityScenario = ActivityScenario.launch(TeamActivity::class.java)

        //Nav fragment to jointeam page
        onView(withId(R.id.navigation_team_tournaments)).perform(click())
        onView(withId(R.id.team_tournament_container)).check(matches(isDisplayed()))
    }

    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToInvitation() {
        //set up
        val activityScenario = ActivityScenario.launch(TeamActivity::class.java)
        //Nav fragment to userprofile page
        onView(withId(R.id.navigation_team_invitation)).perform(click())
        onView(withId(R.id.team_invitation_container)).check(matches(isDisplayed()))

    }

}