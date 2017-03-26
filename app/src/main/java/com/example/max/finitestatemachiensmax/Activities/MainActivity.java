package com.example.max.finitestatemachiensmax.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.max.finitestatemachiensmax.Objects.FiniteMachineState;
import com.example.max.finitestatemachiensmax.R;
import com.example.max.finitestatemachiensmax.Utils.StateUtils;
import com.google.firebase.crash.FirebaseCrash;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView stateTextView;

    private TextView armedTextView;

    private TextView disarmedTextView;

    private Button lockButton;

    private Button unLockButton;

    private Button lockx2Button;

    private Button unLockx2Button;

    private String [] statesArray;

    private FiniteMachineState finiteMachineState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseCrash.report(new Exception("My first Android non-fatal error"));//crash reporting
        initViews();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lock_button:
                Toast.makeText(this,"Lock pressed",Toast.LENGTH_SHORT).show();
                StateUtils.defineLockButtonState(finiteMachineState,statesArray);
                StateUtils.setStateDependentViews(finiteMachineState,stateTextView, armedTextView, disarmedTextView);
                break;
            case R.id.unlock_button:
                Toast.makeText(this,"UnLock pressed",Toast.LENGTH_SHORT).show();
                StateUtils.defineUnLockButtonState(finiteMachineState,statesArray);
                StateUtils.setStateDependentViews(finiteMachineState,stateTextView, armedTextView, disarmedTextView);
                break;
            case R.id.lockx2_button:
                Toast.makeText(this,"Lockx2 pressed",Toast.LENGTH_SHORT).show();
                StateUtils.defineLockx2ButtonState(finiteMachineState,statesArray);
                StateUtils.setStateDependentViews(finiteMachineState,stateTextView, armedTextView, disarmedTextView);
                break;
            case R.id.unlockx2_button:
                Toast.makeText(this,"UnLockx2 pressed",Toast.LENGTH_SHORT).show();
                StateUtils.defineUnLockx2ButtonState(finiteMachineState,statesArray);
                StateUtils.setStateDependentViews(finiteMachineState,stateTextView, armedTextView, disarmedTextView);
                break;
        }
    }
    private void initViews(){
        stateTextView = (TextView) findViewById(R.id.state_text_view);
        armedTextView = (TextView) findViewById(R.id.armed_text_view);
        disarmedTextView = (TextView) findViewById(R.id.disarmed_text_view);
        lockButton = (Button) findViewById(R.id.lock_button);
        unLockButton = (Button) findViewById(R.id.unlock_button);
        lockx2Button = (Button) findViewById(R.id.lockx2_button);
        unLockx2Button = (Button) findViewById(R.id.unlockx2_button);

        statesArray = getResources().getStringArray(R.array.alarms_state);
        finiteMachineState = FiniteMachineState.getFiniteMachineState(statesArray[2]);//AlarmDisarmed_AllUnlocked default
        finiteMachineState.setArmed(false);
        StateUtils.setStateDependentViews(finiteMachineState,stateTextView, armedTextView, disarmedTextView);
        lockButton.setOnClickListener(this);
        unLockButton.setOnClickListener(this);
        lockx2Button.setOnClickListener(this);
        unLockx2Button.setOnClickListener(this);
    }

}
