package com.mainafelix.globalnews;

import static junit.framework.TestCase.assertTrue;

import android.content.Intent;
import android.widget.TextView;

import com.mainafelix.globalnews.ui.MainActivity;
import com.mainafelix.globalnews.ui.NewsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

//package com.mainafelix.globalnews;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertTrue;
//
//import android.content.Intent;
//import android.os.Build;
//import android.widget.TextView;
//
//import com.mainafelix.globalnews.ui.MainActivity;
//import com.mainafelix.globalnews.ui.NewsActivity;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.robolectric.Robolectric;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.annotation.Config;
//import org.robolectric.shadows.ShadowActivity;
//
//@Config(sdk =  {Build.VERSION_CODES.N_MR1})
//@RunWith(RobolectricTestRunner.class)
//public class MainActivityTest {
//    private MainActivity activity;
//
//    @Before
//    public void setUp() throws Exception {
//        activity = Robolectric.buildActivity(MainActivity.class)
//                .create()
//                .resume()
//                .get();
//    }
//
//    @Test
//    public void validateTextViewContent() {
//        TextView appNameTextView = activity.findViewById(R.id.appNameTextView);
//        assertEquals(true, "GLOBAL NEWS ".equals(appNameTextView.getText().toString()));
//    }
//
////    @Test
////    public void secondActivityStarted() {
////        activity.findViewById(R.id.findNewsButton).performClick();
////        Intent expectedIntent = new Intent(activity, NewsActivity.class);
////        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
////        Intent actualIntent = shadowActivity.getNextStartedActivity();
////        assertTrue(actualIntent.filterEquals(expectedIntent));
////
////    }
//
//}
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 29)
public class MainActivityTest {
    private MainActivity activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void validateTextViewContent() {
        TextView appNameTextView = activity.findViewById(R.id.appNameTextView);
        assertTrue("GLOBAL NEWS".equals(appNameTextView.getText().toString()));
    }

    @Test
    public void SecondActivityStarted() {
        activity.findViewById(R.id.findNewsButton).performClick();
        Intent intent = new Intent(activity, NewsActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(intent));
    }
}