package com.example.android.testing.espresso.BasicSample;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityUiTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testInitialText() {
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText("Hello Espresso!")));
    }

    @Test
    public void testChangeTextButton() {
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("Hello"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt))
                .perform(click());
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText("Hello")));
    }
}