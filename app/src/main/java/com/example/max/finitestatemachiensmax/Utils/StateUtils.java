package com.example.max.finitestatemachiensmax.Utils;

import android.view.View;
import android.widget.TextView;

import com.example.max.finitestatemachiensmax.Objects.FiniteMachineState;

/**
 * Created by Max on 26.03.2017.
 */

public class StateUtils {

    public static void defineLockButtonState(FiniteMachineState finiteMachineState, String [] statesArray){

     /*   <item>AlarmArmed_AllLocked</item>
        <item>AlarmDisarmed_AllLocke</item>
        <item>AlarmDisarmed_AllUnlocked</item>
        <item>AlarmDisarmed_DriverUnlocked</item>*/
        if(!statesArray[0].equals(finiteMachineState.getState())){
              finiteMachineState.setState(statesArray[1]);
              finiteMachineState.setArmed(false);
        }

    }

    public static void defineLockx2ButtonState(FiniteMachineState finiteMachineState, String [] statesArray){

     /*   <item>AlarmArmed_AllLocked</item>
        <item>AlarmDisarmed_AllLocke</item>
        <item>AlarmDisarmed_AllUnlocked</item>
        <item>AlarmDisarmed_DriverUnlocked</item>*/
        finiteMachineState.setState(statesArray[0]);
        finiteMachineState.setArmed(true);

    }

    public static void defineUnLockButtonState(FiniteMachineState finiteMachineState, String [] statesArray){

     /*   <item>AlarmArmed_AllLocked</item>
        <item>AlarmDisarmed_AllLocke</item>
        <item>AlarmDisarmed_AllUnlocked</item>
        <item>AlarmDisarmed_DriverUnlocked</item>*/
        if(!statesArray[2].equals(finiteMachineState.getState())){
            finiteMachineState.setState(statesArray[3]);
            finiteMachineState.setArmed(false);
        }

    }

    public static void defineUnLockx2ButtonState(FiniteMachineState finiteMachineState, String [] statesArray){

     /*   <item>AlarmArmed_AllLocked</item>
        <item>AlarmDisarmed_AllLocke</item>
        <item>AlarmDisarmed_AllUnlocked</item>
        <item>AlarmDisarmed_DriverUnlocked</item>*/
        if(!statesArray[3].equals(finiteMachineState.getState())){
            finiteMachineState.setState(statesArray[2]);
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
