package com.android3.siegertpclient.ui.tournament

import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.team.TeamActivity


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.android3.siegertpclient.R

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.matcher.ViewMatchers.*


@RunWith(AndroidJUnit4ClassRunner::class)
class TournamentActivityTest{
    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToTournamentDetail() {
        //set up
        val activityScenario = ActivityScenario.launch(TournamentActivity::class.java)

        //Nav Fragment createTournament
        onView(withId(R.id.navigation_tournament_info)).perform(click())

        //vertify
        onView(withId(R.id.tournament_detail_container)).check(matches(isDisplayed()))


    }
    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToParticipant() {
        //set up
        val activityScenario = ActivityScenario.launch(TournamentActivity::class.java)

        //Nav fragment to jointeam page
        onView(withId(R.id.navigation_participants)).perform(click())
        onView(withId(R.id.participant_container)).check(matches(isDisplayed()))
    }

    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToSchedules() {
        //set up
        val activityScenario = ActivityScenario.launch(TournamentActivity::class.java)
        //Nav fragment to userprofile page
        onView(withId(R.id.navigation_schedule)).perform(click())
        onView(withId(R.id.schedules_container)).check(matches(isDisplayed()))

    }

    /**
     * To test if the navigationbar can work.
     */
    @Test
    fun test_NavToMatches() {
        //set up
        val activityScenario = ActivityScenario.launch(TournamentActivity::class.java)
        //Nav fragment to userprofile page
        onView(withId(R.id.navigation_match_info)).perform(click())
        onView(withId(R.id.matches_container)).check(matches(isDisplayed()))

    }

}