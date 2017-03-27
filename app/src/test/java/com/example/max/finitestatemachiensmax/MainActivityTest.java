package com.example.max.finitestatemachiensmax;

import android.os.Build;
import android.widget.TextView;

import com.example.max.finitestatemachiensmax.Activities.MainActivity;
import com.google.firebase.FirebaseApp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Max on 26.03.2017.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity activity;


    @Before
    public void setup() {

        activity = Robolectric.setupActivity(MainActivity.class);
    }


    @Test
    public void validatedefaultStateTextViewContent() {
        TextView mainText = (TextView) activity.findViewById(R.id.state_text_view);
       // assertNotNull("TextView could not be found", mainText);
        assertTrue("TextView contains incorrect text", "AlarmDisarmed_AllUnlocked".equals(mainText.getText().toString()));
      //  assertNull(mainText.getText().toString());
    }
}
