package com.example.max.finitestatemachiensmax.Utils;


import android.content.Context;
import android.provider.SyncStateContract;

import com.example.max.finitestatemachiensmax.Objects.StatesFromJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StatesMachineJsonLoader {

    public static String readRawJSONFile(Context ctx, int resId)
    {
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        StringBuffer buffer = new StringBuffer();
        String line;

        try {
            while (( line = buffreader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            return null;
        }
        return buffer.toString();
    }

    public static StatesFromJSON convertJSONStatesToStatesFromJSON(Context ctx, int resId){
        StatesFromJSON statesFromJSON = null;
        try {
            JSONObject oneObject = new JSONObject(readRawJSONFile(ctx,resId));
            statesFromJSON  = new StatesFromJSON();
            statesFromJSON.setAlarmArmedAllLocked(oneObject.getString(Constans.ALARM_ARMED_ALL_LOCKED));
            statesFromJSON.setAlarmDisarmedAllLocked(oneObject.getString(Constans.ALARM_DISARMED_ALL_LOCKED));
            statesFromJSON.setAlarmdisarmedAllUnlocked(oneObject.getString(Constans.ALARM_DISARMED_ALL_UNLOCKED));
            statesFromJSON.setAlarmDisarmedDriverunLocked(oneObject.getString(Constans.ALARM_DISARMED_DRIVER_UNLOCKED));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return statesFromJSON;
    }


}
