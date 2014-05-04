package com.Learnovate.switches;

import android.util.Log;
import android.util.StringBuilderPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mollyrand on 2/17/14.
 */
public class Switch <T extends SwitchInterface>{

    StringBuilderPrinter a;

    private List<T> wiredThings = new ArrayList<T>();

    public void wireUp(T thing){
        if(wiredThings.contains(thing)){
            Log.e("ERROR", "This is already wired to the switch");
        } else {
            wiredThings.add(thing);
        }
    }

    public void unWire(T thing){
        if (wiredThings.contains(thing)){
            wiredThings.remove(thing);
        } else {
            Log.e("ERROR", "You can't remove something that isn't there");
        }
    }

    public void switchUp(){
        for(T thing : wiredThings){
            if(thing.isItOn() == false){
                thing.turnOn();
            }
        }
    }

    public void switchDown(){
        for(T thing : wiredThings){
            if(thing.isItOn()){
                thing.turnOff();
            }
        }
    }

    public void remotePressed(){
        for(T thing : wiredThings){
            if (thing.isItOn()){
                thing.turnOff();
            } else {
                thing.turnOn();
            }
        }
    }
}
