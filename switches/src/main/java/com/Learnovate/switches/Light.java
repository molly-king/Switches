package com.Learnovate.switches;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by mollyrand on 2/17/14.
 */
public class Light implements SwitchInterface {

    private ImageView pictureOfLight;
    private boolean isOn = false;

    @Override
    public void turnOn() {
        Log.e("LIGHT", "It's so bright in here");
        isOn = true;
    }

    @Override
    public void turnOff() {
        Log.e("LIGHT", "Gee, I hope there's no monsters hiding in here.");
        isOn = false;
    }

    public void setPicture(ImageView picture){
        this.pictureOfLight = picture;
    }

    public ImageView getPicture(){
        return pictureOfLight;
    }

    public boolean isItOn(){
        return isOn;
    }
}
