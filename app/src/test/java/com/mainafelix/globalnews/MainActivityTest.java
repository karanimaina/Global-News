package com.mainafelix.globalnews;

import android.os.Build;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(sdk =  {Build.VERSION_CODES.N_MR1})
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private  MainActivity activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }
}
