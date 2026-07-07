package com.example.lab6;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest2 {
    // Step 7: Define ActivityScenarioRule for LoginActivity
    @Rule
    public ActivityScenarioRule<LoginActivity> loginActivityScenarioRule = new
            ActivityScenarioRule<>(LoginActivity.class);

    // Step 8: Create an Espresso test for invalid login credentials
    @Test
    public void loginIsInvalid() {
        onView(withId(R.id.edtUsername)).perform(typeText("user"));
        onView(withId(R.id.edtPassword)).perform(typeText("test"));
        closeSoftKeyboard();
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.loginTxt))
                .check(matches(withText("Invalid login!")))
                .check(matches(isDisplayed()));
    }
}
