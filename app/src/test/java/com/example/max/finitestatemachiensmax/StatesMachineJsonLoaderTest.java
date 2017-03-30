package com.example.max.finitestatemachiensmax;


import android.os.Build;

import com.example.max.finitestatemachiensmax.Activities.MainActivity;
import com.example.max.finitestatemachiensmax.Objects.StatesFromJSON;
import com.example.max.finitestatemachiensmax.Utils.StatesMachineJsonLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.*;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)
public class StatesMachineJsonLoaderTest {

    String jsonLoadedString = "{  \"alarmarmed_alllocked\":\"AlarmArmed_AllLocked\",  \"alarmdisarmed_alllocked\":\"AlarmDisarmed_AllLocked\", " +
        " \"alarmdisarmed_allunlocked\":\"AlarmDisarmed_AllUnlocked\",  \"alarmdisarmed_driverunlocked\":\"AlarmDisarmed_DriverUnlocked\"}";

    private MainActivity activity;

    private StatesFromJSON statesFromJSON;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        statesFromJSON = new StatesFromJSON();
        statesFromJSON.setAlarmArmedAllLocked("AlarmArmed_AllLocked");
        statesFromJSON.setAlarmDisarmedAllLocked("AlarmDisarmed_AllLocked");
        statesFromJSON.setAlarmdisarmedAllUnlocked("AlarmDisarmed_AllUnlocked");
        statesFromJSON.setAlarmDisarmedDriverunLocked("AlarmDisarmed_DriverUnlocked");

    }

    @Test
    public void shouldRetunSameValueAsjsonLoadedString(){
        assertEquals(jsonLoadedString, StatesMachineJsonLoader.readRawJSONFile(activity.getBaseContext(), R.raw.states_of_machine));
    }

    @Test
    public void shouldReturnSameValueAsstatesFromJSON(){
        StatesFromJSON otherStatesFromJSON = StatesMachineJsonLoader.convertJSONStatesToStatesFromJSON(activity.getBaseContext(), R.raw.states_of_machine);
        assertEquals(otherStatesFromJSON.getAlarmArmedAllLocked(),statesFromJSON.getAlarmArmedAllLocked());
        assertEquals(otherStatesFromJSON.getAlarmDisarmedAllLocked(),statesFromJSON.getAlarmDisarmedAllLocked());
        assertEquals(otherStatesFromJSON.getAlarmdisarmedAllUnlocked(),statesFromJSON.getAlarmdisarmedAllUnlocked());
        assertEquals(otherStatesFromJSON.getAlarmDisarmedDriverunLocked(),statesFromJSON.getAlarmDisarmedDriverunLocked());
    }
}
