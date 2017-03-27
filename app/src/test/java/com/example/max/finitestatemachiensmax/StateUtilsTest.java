package com.example.max.finitestatemachiensmax;

import android.os.Build;
import android.view.View;
import android.widget.TextView;

import com.example.max.finitestatemachiensmax.Activities.MainActivity;
import com.example.max.finitestatemachiensmax.Objects.FiniteMachineState;
import com.example.max.finitestatemachiensmax.Utils.StateUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)
public class StateUtilsTest {

    private MainActivity activity;

    private String [] statesArray;

    FiniteMachineState finiteMachineState;


    TextView stateTextView;

    TextView armedTextView;

    TextView disarmedTextView;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        statesArray = activity.getResources().getStringArray(R.array.alarms_state);
        stateTextView = (TextView) activity.findViewById(R.id.state_text_view);
        armedTextView = (TextView) activity.findViewById(R.id.armed_text_view);
        disarmedTextView = (TextView) activity.findViewById(R.id.disarmed_text_view);
        finiteMachineState = FiniteMachineState.getFiniteMachineState(statesArray[2]);
        finiteMachineState.setArmed(false);
    }



    @Test
    public void shouldDefineLockButtonState(){

        finiteMachineState.setState(statesArray[2]);
        StateUtils.defineLockButtonState(finiteMachineState,statesArray);
        assertEquals(finiteMachineState.getState(),statesArray[1]);
        assertFalse(finiteMachineState.isArmed());

        finiteMachineState.setState(statesArray[0]);
        finiteMachineState.setArmed(true);
        StateUtils.defineLockButtonState(finiteMachineState,statesArray);
        assertEquals(finiteMachineState.getState(),statesArray[0]);
        assertTrue(finiteMachineState.isArmed());
    }

    @Test
    public void shoulDefineLockx2ButtonState(){
        finiteMachineState.setState(statesArray[1]);
        StateUtils.defineLockx2ButtonState(finiteMachineState,statesArray);
        assertEquals(finiteMachineState.getState(),statesArray[0]);
        assertTrue(finiteMachineState.isArmed());
    }

    @Test
    public void shouldefineUnLockButtonState(){
        finiteMachineState.setState(statesArray[1]);
        StateUtils.defineUnLockButtonState(finiteMachineState,statesArray);
        assertEquals(finiteMachineState.getState(),statesArray[3]);
        assertFalse(finiteMachineState.isArmed());

        finiteMachineState.setState(statesArray[2]);
        finiteMachineState.setArmed(false);
        StateUtils.defineUnLockButtonState(finiteMachineState,statesArray);
        assertEquals(finiteMachineState.getState(),statesArray[2]);
        assertFalse(finiteMachineState.isArmed());
    }

    @Test
    public void shoulDefineUnLockx2ButtonState(){
        finiteMachineState.setState(statesArray[2]);
        StateUtils.defineUnLockx2ButtonState(finiteMachineState,statesArray);
        assertEquals(finiteMachineState.getState(),statesArray[2]);
        assertFalse(finiteMachineState.isArmed());

        finiteMachineState.setState(statesArray[3]);
        finiteMachineState.setArmed(false);
        StateUtils.defineUnLockx2ButtonState(finiteMachineState,statesArray);
        assertEquals(finiteMachineState.getState(),statesArray[3]);
        assertFalse(finiteMachineState.isArmed());

    }

    @Test
    public void shouldSetStateDependentViews() {
        finiteMachineState.setState(statesArray[3]);
        finiteMachineState.setArmed(false);
        StateUtils.setStateDependentViews(finiteMachineState, stateTextView,
                armedTextView, disarmedTextView);
        assertEquals(finiteMachineState.getState(), stateTextView.getText().toString());
        assertEquals(View.INVISIBLE, armedTextView.getVisibility());
        assertEquals(View.VISIBLE, disarmedTextView.getVisibility());

        finiteMachineState.setState(statesArray[0]);
        finiteMachineState.setArmed(true);
        StateUtils.setStateDependentViews(finiteMachineState, stateTextView,
                armedTextView, disarmedTextView);
        assertEquals(finiteMachineState.getState(), stateTextView.getText().toString());
        assertEquals(View.VISIBLE, armedTextView.getVisibility());
        assertEquals(View.INVISIBLE, disarmedTextView.getVisibility());
    }




}
