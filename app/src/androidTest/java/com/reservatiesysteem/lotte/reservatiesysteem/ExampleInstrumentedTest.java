package com.reservatiesysteem.lotte.reservatiesysteem;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.internal.util.Checks;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import com.reservatiesysteem.lotte.reservatiesysteem.activity.StartActivity;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<StartActivity>mActivityRule = new ActivityTestRule<StartActivity>(StartActivity.class);

    @Test
    public void useAppContext() throws Exception {
        onView(withId(R.id.searchCity))
                .perform(typeText("- 2550"), closeSoftKeyboard());
        onView(withId(R.id.numberPersons))
                .perform(typeText("azerty2"),closeSoftKeyboard());
        onView(withId(R.id.btnReserveer)).perform(click());
        onView(withId(R.id.lytList)).check(matches(withBgColor(Color.RED)));
        onView(withText("Filiaal Kontich")).perform(click());
    }

    public static Matcher<View> withBgColor(final int color) {
        Checks.checkNotNull(color);
        return new BoundedMatcher<View, LinearLayout>(LinearLayout.class) {
            @Override
            public boolean matchesSafely(LinearLayout row) {
                ColorDrawable colorDrawable = new ColorDrawable(color);
                Drawable drawable = colorDrawable;

                return drawable == row.getBackground();
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("with text color: ");
            }
        };
    }
}
