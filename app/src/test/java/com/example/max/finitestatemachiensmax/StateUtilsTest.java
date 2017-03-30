package com.example.max.finitestatemachiensmax;

import android.os.Build;
import android.view.View;
import android.widget.TextView;

import com.example.max.finitestatemachiensmax.Activities.MainActivity;
import com.example.max.finitestatemachiensmax.Objects.FiniteMachineState;
import com.example.max.finitestatemachiensmax.Objects.StatesFromJSON;
import com.example.max.finitestatemachiensmax.Utils.StatesMachineJsonLoader;
import com.example.max.finitestatemachiensmax.Utils.StateUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)
public class StateUtilsTest {

    private MainActivity activity;

    private String [] statesArray;

    private StatesFromJSON statesFromJSON;

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
        statesFromJSON = StatesMachineJsonLoader.convertJSONStatesToStatesFromJSON(activity.getBaseContext(), R.raw.states_of_machine);
    }



    @Test
    public void shouldDefineLockButtonState(){

        finiteMachineState.setState(statesFromJSON.getAlarmdisarmedAllUnlocked());
        StateUtils.defineLockButtonState(finiteMachineState,statesFromJSON);
        assertEquals(finiteMachineState.getState(),statesFromJSON.getAlarmDisarmedAllLocked());
        assertFalse(finiteMachineState.isArmed());

        finiteMachineState.setState(statesFromJSON.getAlarmArmedAllLocked());
        finiteMachineState.setArmed(true);
        StateUtils.defineLockButtonState(finiteMachineState,statesFromJSON);
        assertEquals(finiteMachineState.getState(),statesFromJSON.getAlarmArmedAllLocked());
        assertTrue(finiteMachineState.isArmed());
    }

    @Test
    public void shoulDefineLockx2ButtonState(){
        finiteMachineState.setState(statesFromJSON.getAlarmDisarmedAllLocked());
        StateUtils.defineLockx2ButtonState(finiteMachineState,statesFromJSON);
        assertEquals(finiteMachineState.getState(),statesFromJSON.getAlarmArmedAllLocked());
        assertTrue(finiteMachineState.isArmed());
    }

    @Test
    public void shouldefineUnLockButtonState(){
        finiteMachineState.setState(statesFromJSON.getAlarmDisarmedAllLocked());
        StateUtils.defineUnLockButtonState(finiteMachineState,statesFromJSON);
        assertEquals(finiteMachineState.getState(),statesFromJSON.getAlarmDisarmedDriverunLocked());
        assertFalse(finiteMachineState.isArmed());

        finiteMachineState.setState(statesFromJSON.getAlarmdisarmedAllUnlocked());
        finiteMachineState.setArmed(false);
        StateUtils.defineUnLockButtonState(finiteMachineState,statesFromJSON);
        assertEquals(finiteMachineState.getState(),statesFromJSON.getAlarmdisarmedAllUnlocked());
        assertFalse(finiteMachineState.isArmed());
    }

    @Test
    public void shoulDefineUnLockx2ButtonState(){
        finiteMachineState.setState(statesFromJSON.getAlarmdisarmedAllUnlocked());
        StateUtils.defineUnLockx2ButtonState(finiteMachineState,statesFromJSON);
        assertEquals(finiteMachineState.getState(),statesFromJSON.getAlarmdisarmedAllUnlocked());
        assertFalse(finiteMachineState.isArmed());

        finiteMachineState.setState(statesFromJSON.getAlarmDisarmedDriverunLocked());
        finiteMachineState.setArmed(false);
        StateUtils.defineUnLockx2ButtonState(finiteMachineState,statesFromJSON);
        assertEquals(finiteMachineState.getState(),statesFromJSON.getAlarmDisarmedDriverunLocked());
        assertFalse(finiteMachineState.isArmed());

    }

    @Test
    public void shouldSetStateDependentViews() {
        finiteMachineState.setState(statesFromJSON.getAlarmDisarmedDriverunLocked());
        finiteMachineState.setArmed(false);
        StateUtils.setStateDependentViews(finiteMachineState, stateTextView,
                armedTextView, disarmedTextView);
        assertEquals(finiteMachineState.getState(), stateTextView.getText().toString());
        assertEquals(View.INVISIBLE, armedTextView.getVisibility());
        assertEquals(View.VISIBLE, disarmedTextView.getVisibility());

        finiteMachineState.setState(statesFromJSON.getAlarmArmedAllLocked());
        finiteMachineState.setArmed(true);
        StateUtils.setStateDependentViews(finiteMachineState, stateTextView,
                armedTextView, disarmedTextView);
        assertEquals(finiteMachineState.getState(), stateTextView.getText().toString());
        assertEquals(View.VISIBLE, armedTextView.getVisibility());
        assertEquals(View.INVISIBLE, disarmedTextView.getVisibility());
    }




}
