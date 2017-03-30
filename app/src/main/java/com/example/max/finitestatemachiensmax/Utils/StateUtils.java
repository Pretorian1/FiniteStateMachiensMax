package com.example.max.finitestatemachiensmax.Utils;

import android.view.View;
import android.widget.TextView;

import com.example.max.finitestatemachiensmax.Objects.FiniteMachineState;
import com.example.max.finitestatemachiensmax.Objects.StatesFromJSON;

/**
 * Created by Max on 26.03.2017.
 */

public class StateUtils {

    public static void defineLockButtonState(FiniteMachineState finiteMachineState, StatesFromJSON statesFromJSON){

        if(!statesFromJSON.getAlarmArmedAllLocked().equals(finiteMachineState.getState())){
              finiteMachineState.setState(statesFromJSON.getAlarmDisarmedAllLocked());
              finiteMachineState.setArmed(false);
        }

    }

    public static void defineLockx2ButtonState(FiniteMachineState finiteMachineState, StatesFromJSON statesFromJSON){

        finiteMachineState.setState(statesFromJSON.getAlarmArmedAllLocked());
        finiteMachineState.setArmed(true);

    }

    public static void defineUnLockButtonState(FiniteMachineState finiteMachineState, StatesFromJSON statesFromJSON){

        if(!statesFromJSON.getAlarmdisarmedAllUnlocked().equals(finiteMachineState.getState())){
            finiteMachineState.setState(statesFromJSON.getAlarmDisarmedDriverunLocked());
            finiteMachineState.setArmed(false);
        }

    }

    public static void defineUnLockx2ButtonState(FiniteMachineState finiteMachineState, StatesFromJSON statesFromJSON){

        if(!statesFromJSON.getAlarmDisarmedDriverunLocked().equals(finiteMachineState.getState())){
            finiteMachineState.setState(statesFromJSON.getAlarmdisarmedAllUnlocked());
            finiteMachineState.setArmed(false);
        }
    }
    public static void setStateDependentViews(FiniteMachineState finiteMachineState, TextView stateTextView,
                                              TextView armedTextView, TextView disarmedTextView){

        stateTextView.setText(finiteMachineState.getState());
        if(finiteMachineState.isArmed()){
            armedTextView.setVisibility(View.VISIBLE);
            disarmedTextView.setVisibility(View.INVISIBLE);
        }
        else{
            armedTextView.setVisibility(View.INVISIBLE);
            disarmedTextView.setVisibility(View.VISIBLE);
        }
    }

}
