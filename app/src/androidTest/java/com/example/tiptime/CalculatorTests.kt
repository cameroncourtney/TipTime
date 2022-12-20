package com.example.tiptime
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    // This tests whether or not the percentage works.
    @Test
    fun calculate_20_percent_tip() {
        // Our amount is typed in and the keyboard is closed.
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("100.00"))
        closeSoftKeyboard()

        onView(withId(R.id.calculate_button)).perform(click())

        // We check if the tip was correctly calculated.
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$20.00"))))
    }
}