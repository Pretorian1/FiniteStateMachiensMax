package com.example.max.finitestatemachiensmax.Objects;

import android.support.v7.app.AppCompatActivity;

import com.example.max.finitestatemachiensmax.R;

/**
 * Created by Max on 26.03.2017.
 */

public class FiniteMachineState {

    private static FiniteMachineState finiteMachineState;

    private String state;

    private boolean isArmed;

    private FiniteMachineState(String state){
        this.state = state;
    }

    public boolean isArmed() {
        return isArmed;
    }

    public void setArmed(boolean armed) {
        isArmed = armed;
    }

    public static FiniteMachineState getFiniteMachineState(String state){
        if(finiteMachineState == null){
            synchronized (FiniteMachineState.class){}
            if(finiteMachineState == null){
                finiteMachineState = new FiniteMachineState(state);
            }
        }
        return finiteMachineState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
