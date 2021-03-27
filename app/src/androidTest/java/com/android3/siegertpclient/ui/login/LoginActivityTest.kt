package com.android3.siegertpclient.ui.login

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.ToastMatcher
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class LoginActivityTest {
    /**
     * To test if click register button navigate to register page.
     */
    @Test
    fun test_navRegiActivity() {

        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        onView(withId(R.id.tv_register)).perform(click())
        onView(withId(R.id.register_container)).check(matches(isDisplayed()))

    }

    /**
     * To test if the login page show or not.
     */
    @Test
    fun test_isLoginVisible() {

        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        onView(withId(R.id.login_container)).check(matches(isDisplayed()))
    }

    /**
     * To test if the title in the button visible.
     */
    @Test
    fun test_visibility_title_loginButton(){
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()))
    }

    /**
     * To test if the password on the edittext is displayed.
     */
    @Test
    fun test_isTitleDispalyed(){
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.et_password)).check(matches(isDisplayed()))
    }

    /**
     * To test if the app go to the password forgot page when click the "Forgot password?" text.
     */
    @Test
    fun test_navPasswordForgotPage() {
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        onView(withId(R.id.tv_forgot_password)).perform(click())
        onView(withId(R.id.passwordForget_container)).check(matches(isDisplayed()))
    }

    /**
     * To see if the toast can be show, but we must try to test it one by one because the toast may
     * continue show several seconds.
     */
    @Test
    fun test_toast_incompleteInfo() {
        //Given
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        //to see if toast is displayed to show incomplete information
        onView(withId(R.id.btn_login)).perform(click())
        onView(withText("Please fill in all of the field"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))

    }

    /**
     *To test if the toast show the right message when the email not valid.
     */
    @Test
    fun test_toast_emailNotValid() {
        //Given
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        val false_email = "sdf"

        val expected_password = "123344"

        //enter some input
        onView(withId(R.id.et_email)).perform(typeText(false_email))
        onView(withId(R.id.et_password)).perform(typeText(expected_password))
        pressBack();
        onView(withId(R.id.btn_login)).perform(click())

        //show the invalid email toast
        onView(withText("Email is not valid"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    /**
     * To see if toast appear when type the false password
     */
    @Test
    fun test_toast_invalidPassword() {
        //Given
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        val expected_email = "123@qq.com"
        val false_password = "11"

        //enter some input
        onView(withId(R.id.et_email)).perform(typeText(expected_email))
        onView(withId(R.id.et_password)).perform(typeText(false_password))
        onView(withId(R.id.btn_login)).perform(click())

        //show the invalid password toast
        onView(withText("Password is not valid"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    /**
     * To test the login toast.
     */
    @Test
    fun test_login_succeful(){
        //Given
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        val expected_email = "111@111.com"
        val password = "111111"

        //enter some input
        onView(withId(R.id.et_email)).perform(typeText(expected_email))
        onView(withId(R.id.et_password)).perform(typeText(password))
        onView(withId(R.id.btn_login)).perform(click())

        //show the invalid password toast
        onView(withText("You are logged in successfully."))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
        onView(withId(R.id.homepage_container)).check(matches(isDisplayed()))
    }
}




