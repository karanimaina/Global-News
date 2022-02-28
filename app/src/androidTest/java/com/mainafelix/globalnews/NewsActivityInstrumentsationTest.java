package com.mainafelix.globalnews;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class NewsActivityInstrumentsationTest {
    @Rule
    public ActivityScenarioRule<NewsActivity> activityTestRule =
            new ActivityScenarioRule<>(NewsActivity.class);
    private View activityDecorView;
    @Before
    public void setUp() {
        activityTestRule.getScenario().onActivity(new ActivityScenario.ActivityAction<NewsActivity>() {
            @Override
            public void perform(NewsActivity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }}

