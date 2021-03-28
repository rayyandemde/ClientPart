package com.android3.siegertpclient.ui.register

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.ToastMatcher
import com.android3.siegertpclient.ui.login.LoginActivity
import org.hamcrest.CoreMatchers.endsWith
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class RegisterActivityTest{



    @Test
    fun test_isActivityInView(){
        val activityScenario = ActivityScenario.launch(RegisterActivity::class.java)
        onView(withId(R.id.register_container)).check(matches(isDisplayed()))
    }


    /**
     * To see if the toast can be show when the information is not comlpete, but we must try to test it one by one because the toast may
     * continue show several seconds.
     */
    @Test
    fun test_toast_incompleteInfo() {
        //Given
        val activityScenario = ActivityScenario.launch(RegisterActivity::class.java)

        //to see if toast is displayed to show incomplete information
        onView(withId(R.id.btn_sign_up)).perform(ViewActions.click())
        onView(ViewMatchers.withText("Please fill in all of the field"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))

    }


    /**
     *To test if the toast show the right message when the email not valid.
     */
    @Test
    fun test_toast_emailNotValid() {
        //Given
        val activityScenario = ActivityScenario.launch(RegisterActivity::class.java)
        val false_email = "sdf"
        val email = "123@123.com"
        val name = "qiqi"
        val firstname = "s"
        val lastname = "sd"

        val password = "123344"
        val repassword = "123344"

        //enter some input
        onView(withId(R.id.et_username)).perform(ViewActions.typeText(name))
        onView(withId(R.id.et_first_name)).perform(ViewActions.typeText(firstname))
        onView(withId(R.id.et_last_name)).perform(ViewActions.typeText(lastname))
        onView(withId(R.id.et_email)).perform(ViewActions.typeText(false_email))
        onView(withId(R.id.et_password)).perform(ViewActions.typeText(password))
        pressBack();
       onView(withId(R.id.et_retype_password)).perform(ViewActions.typeText(password))

        Espresso.pressBack();
        onView(withId(R.id.btn_sign_up)).perform(ViewActions.click())

        //show the invalid email toast
        onView(ViewMatchers.withText("Email is not valid"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }



    /**
     *To test if the toast show the right message when the password not valid.
     */
    @Test
    fun test_toast_passwordNotValid() {
        //Given
        val activityScenario = ActivityScenario.launch(RegisterActivity::class.java)
        val false_email = "sdf"
        val email = "123@123.com"
        val name = "qiqi"
        val firstname = "s"
        val lastname = "sd"

        val password = "123"
        val repassword = "123"

        //enter some input
        onView(withId(R.id.et_username)).perform(ViewActions.typeText(name))
        onView(withId(R.id.et_first_name)).perform(ViewActions.typeText(firstname))
        onView(withId(R.id.et_last_name)).perform(ViewActions.typeText(lastname))
        onView(withId(R.id.et_email)).perform(ViewActions.typeText(email))
        onView(withId(R.id.et_password)).perform(ViewActions.typeText(password))
        pressBack();
        onView(withId(R.id.et_retype_password)).perform(ViewActions.typeText(repassword))

        Espresso.pressBack();
        onView(withId(R.id.btn_sign_up)).perform(ViewActions.click())

        //show the invalid email toast
        onView(ViewMatchers.withText(endsWith("]")))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }


    /**
     *To test if the toast show the right message when the repeatpassword is not equal to the
     * original password.
     */
    @Test
    fun test_toast_passwordNotSame() {
        //Given
        val activityScenario = ActivityScenario.launch(RegisterActivity::class.java)
        val false_email = "sdf"
        val email = "123@123.com"
        val name = "qiqi"
        val firstname = "s"
        val lastname = "sd"

        val password = "123123123"
        val repassword = "12341234"

        //enter some input
        onView(withId(R.id.et_username)).perform(ViewActions.typeText(name))
        onView(withId(R.id.et_first_name)).perform(ViewActions.typeText(firstname))
        onView(withId(R.id.et_last_name)).perform(ViewActions.typeText(lastname))
        onView(withId(R.id.et_email)).perform(ViewActions.typeText(email))
        onView(withId(R.id.et_password)).perform(ViewActions.typeText(password))
        pressBack();
        onView(withId(R.id.et_retype_password)).perform(ViewActions.typeText(repassword))

        Espresso.pressBack();
        onView(withId(R.id.btn_sign_up)).perform(ViewActions.click())

        //show the invalid email toast
        onView(ViewMatchers.withText("Password doesn't match"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))

    }


}