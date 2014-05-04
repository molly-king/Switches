package com.Learnovate.switches;

import android.util.Log;

/**
 * Created by mollyrand on 2/17/14.
 */
public class Disposal implements SwitchInterface {

    private boolean isOn = false;

    @Override
    public void turnOn() {
        Log.e("DISPOSAL", "crunchcrunchcrunch");
        isOn = true;
    }

    @Override
    public void turnOff() {
        Log.e("DISPOSAL", "It's safe to stick your hand in here");
        isOn = false;
    }

    public boolean isItOn(){
        return isOn;
    }
}
