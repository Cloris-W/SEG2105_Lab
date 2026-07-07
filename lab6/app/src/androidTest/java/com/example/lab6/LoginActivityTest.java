package com.example.lab6;

import android.widget.TextView;

import androidx.test.annotation.UiThreadTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class LoginActivityTest {
    // Step 5: Setup the ActivityScenarioRule and initialize variables
    @Rule
    public ActivityScenarioRule<LoginActivity> loginActivityTestRule = new ActivityScenarioRule<LoginActivity>(LoginActivity.class);
    private LoginActivity loginActivity = null;
    private TextView text;

    @Before
    public void setUp() throws Exception {
        loginActivityTestRule.getScenario().onActivity(activity -> {
            loginActivity = activity;
        });
    }

    // Step 6: Create an instrumented test to check UI logic on the UI thread
    @Test
    @UiThreadTest
    public void checkFirstName() throws Exception {
        assertNotNull(loginActivity.findViewById(R.id.edtUsername));
        text = loginActivity.findViewById(R.id.edtUsername);
        text.setText("user1");
        String name = text.getText().toString();
        assertNotEquals("user", name);
    }
}
