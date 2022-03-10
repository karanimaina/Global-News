package com.mainafelix.globalnews;

import static android.os.Looper.getMainLooper;
import static junit.framework.TestCase.assertTrue;

import static org.robolectric.Shadows.shadowOf;

import android.content.Intent;

import com.mainafelix.globalnews.ui.MainActivity;
import com.mainafelix.globalnews.ui.NewsActivity;
import com.mainafelix.globalnews.ui.NewsDetailActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 29)
public class NewsActivityTest {
    private NewsActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(NewsActivity.class)
                .create()
                .resume()
                .get();
    }

//    @Test
//    public void BusinessActivityStarted() {
//        activity.findViewById(R.id.btn_1).performClick();
//        Intent intent = new Intent(activity, NewsDetailActivity.class);
//        ShadowActivity shadowActivity = shadowOf(activity);
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        assertTrue(actualIntent.filterEquals(intent));
//    }
//    @Test
//    public void EntertainmentActivityStarted() {
//        activity.findViewById(R.id.btn_2).performClick();
//        shadowOf(getMainLooper()).idle();
//        Intent intent = new Intent(activity, NewsDetailActivity.class);
//        ShadowActivity shadowActivity = shadowOf(activity);
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        assertTrue(actualIntent.filterEquals(intent));
//
//    }
//    @Test
//    public void General_ActivityStarted() {
//        activity.findViewById(R.id.btn_3).performClick();
//        shadowOf(getMainLooper()).idle();
//        Intent intent = new Intent(activity, NewsDetailActivity.class);
//        ShadowActivity shadowActivity = shadowOf(activity);
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        assertTrue(actualIntent.filterEquals(intent));
//    }
//    @Test
//    public void Health_ActivityStarted() {
//        activity.findViewById(R.id.btn_4).performClick();
//        Intent intent = new Intent(activity, NewsDetailActivity.class);
//        ShadowActivity shadowActivity = shadowOf(activity);
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        shadowOf(getMainLooper()).idle();
//        assertTrue(actualIntent.filterEquals(intent));
//    }
//    @Test
//    public void Science_ActivityStarted() {
//        activity.findViewById(R.id.btn_5).performClick();
//        shadowOf(getMainLooper()).idle();
//        Intent intent = new Intent(activity, NewsDetailActivity.class);
//        ShadowActivity shadowActivity = shadowOf(activity);
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        assertTrue(actualIntent.filterEquals(intent));
//    }
//    @Test
//    public void technology_ActivityStarted() {
//        activity.findViewById(R.id.btn_7).performClick();
//        shadowOf(getMainLooper()).idle();
//        Intent intent = new Intent(activity, NewsDetailActivity.class);
//        ShadowActivity shadowActivity = shadowOf(activity);
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        assertTrue(actualIntent.filterEquals(intent));
//
//    }}
}