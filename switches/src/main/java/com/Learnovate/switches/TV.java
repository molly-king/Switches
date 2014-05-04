package com.Learnovate.switches;

import android.util.Log;

/**
 * Created by mollyrand on 2/17/14.
 */
public class TV implements SwitchInterface {

    private boolean isOn = false;
    @Override
    public void turnOn() {
        Log.e("TV", "Obey the magic box");
        isOn = true;
    }

    @Override
    public void turnOff() {
        Log.e("TV" , "Go outside and get some fresh air");
        isOn = false;
    }

    public boolean isItOn(){
        return isOn;
    }
}

