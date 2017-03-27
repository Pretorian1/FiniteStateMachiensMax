package com.example.max.finitestatemachiensmax;

import com.example.max.finitestatemachiensmax.Objects.FiniteMachineState;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class FiniteMachineStateTest {

    private FiniteMachineState finiteMachineState;

    private String defaultState ="AlarmDisarmed_AllUnlocked";

    private String newState = "Test";

    @Before
    public void setup() {
     finiteMachineState = FiniteMachineState.getFiniteMachineState(defaultState);
     finiteMachineState.setArmed(true);

    }

    @Test
    public void shouldReturnDefaultState() {
       assertEquals(defaultState,finiteMachineState.getState());
    }

    @Test
    public void shouldReturnTrue(){
        assertTrue(finiteMachineState.isArmed());
    }

    @Test
    public void shouldSetNewState(){
        finiteMachineState.setState(newState);
        assertEquals(newState,finiteMachineState.getState());
    }

    @Test
    public void shouldReturnFalse(){
        finiteMachineState.setArmed(false);
        assertFalse(finiteMachineState.isArmed());
    }
}
