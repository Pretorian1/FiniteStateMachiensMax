package com.example.max.finitestatemachiensmax;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.max.finitestatemachiensmax.Activities.MainActivity;
import com.example.max.finitestatemachiensmax.Objects.FiniteMachineState;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Max on 26.03.2017.
 */
@FixMethodOrder(MethodSorters.DEFAULT)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity activity;

    private Button lockButton;

    private Button unLockButton;

    private Button lockx2Button;

    private Button unLockx2Button;


    TextView stateTextView;

    TextView armedTextView;

    TextView disarmedTextView;

    private String [] statesArray;

    @Mock
    FiniteMachineState finiteMachineState;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        statesArray = activity.getResources().getStringArray(R.array.alarms_state);
        stateTextView = (TextView) activity.findViewById(R.id.state_text_view);
        armedTextView = (TextView) activity.findViewById(R.id.armed_text_view);
        disarmedTextView = (TextView) activity.findViewById(R.id.disarmed_text_view);
        lockButton = (Button) activity.findViewById(R.id.lock_button);
        unLockButton = (Button) activity.findViewById(R.id.unlock_button);
        lockx2Button = (Button) activity.findViewById(R.id.lockx2_button);
        unLockx2Button = (Button) activity.findViewById(R.id.unlockx2_button);
    }
    @Test
    public void shouldDefineDefaultStateTextViewContent() {
        assertTrue("TextView contains incorrect text", statesArray[2].equals(stateTextView.getText().toString()));
    }

    @Test
    public void shouldDefineAndChangeStateButtonLockClick(){
        lockButton.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Lock pressed"));
        assertEquals(statesArray[1], stateTextView.getText().toString());
        assertEquals(View.INVISIBLE, armedTextView.getVisibility());
        assertEquals(View.VISIBLE, disarmedTextView.getVisibility());
    }

    @Test
    public void shouldDefineAndChangeStateButtonLockx2Click(){
        lockx2Button.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Lockx2 pressed"));
        assertEquals(statesArray[0], stateTextView.getText().toString());
        assertEquals(View.VISIBLE, armedTextView.getVisibility());
        assertEquals(View.INVISIBLE, disarmedTextView.getVisibility());
    }

    @Test
    public void shouldDefineAndChangeStateButtonUnLockClick(){
        unLockButton.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("UnLock pressed"));
        assertEquals(statesArray[3], stateTextView.getText().toString());
        assertEquals(View.INVISIBLE, armedTextView.getVisibility());
        assertEquals(View.VISIBLE, disarmedTextView.getVisibility());
    }

    @Test
    public void shouldDefineAndChangeStateButtonUnLockx2Click(){
        unLockx2Button.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("UnLockx2 pressed"));
        assertEquals(statesArray[2], stateTextView.getText().toString());
        assertEquals(View.INVISIBLE, armedTextView.getVisibility());
        assertEquals(View.VISIBLE, disarmedTextView.getVisibility());
    }

    @Test
    public void setFiniteMachineStateMock(){
        finiteMachineState = Mockito.mock(FiniteMachineState.class);
        Mockito.when(finiteMachineState.getState()).thenReturn("Some state must be here");
        Mockito.when(finiteMachineState.isArmed()).thenReturn(true);
        assertEquals(finiteMachineState.getState(),"Some state must be here");
        assertTrue(finiteMachineState.isArmed());
    }

}
