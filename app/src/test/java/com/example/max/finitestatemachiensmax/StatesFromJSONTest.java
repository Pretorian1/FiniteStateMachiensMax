package com.example.max.finitestatemachiensmax;


import com.example.max.finitestatemachiensmax.Objects.StatesFromJSON;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatesFromJSONTest {

    StatesFromJSON statesFromJSON;

    String first = "1";

    String second = "2";

    String third = "3";

    String fourth = "4";

    @Before
    public void initObject(){
        statesFromJSON = new StatesFromJSON();
    }

    @Test
    public void shouldSetAndGetValueInAlarmArmedAllLocked(){
        statesFromJSON.setAlarmArmedAllLocked(first);
        assertEquals(statesFromJSON.getAlarmArmedAllLocked(),first);
    };

    @Test
    public void shouldSetAndGetValueInAlarmDisarmedAllLocked(){
        statesFromJSON.setAlarmArmedAllLocked(second);
        assertEquals(statesFromJSON.getAlarmArmedAllLocked(),second);
    };

    @Test
    public void shouldSetAndGetValueInAlarmdisarmedAllUnlocked(){
        statesFromJSON.setAlarmArmedAllLocked(third);
        assertEquals(statesFromJSON.getAlarmArmedAllLocked(),third);
    };

    @Test
    public void shouldSetAndGetValueInAlarmDisarmedDriverunLocked(){
        statesFromJSON.setAlarmArmedAllLocked(fourth);
        assertEquals(statesFromJSON.getAlarmArmedAllLocked(),fourth);
    };

}
