package com.Learnovate.switches;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity{


    private Switch mySwitch;
    private boolean isOn = false;
    ImageButton bigRedButton;
    CheckBox lightSwitch;
    private ImageView lightImage;
    private ImageView tvImage;
    private ImageView disposalImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        lightImage = (ImageView) findViewById(R.id.lightImage);
        tvImage = (ImageView) findViewById(R.id.tvImage);
        disposalImage = (ImageView) findViewById(R.id.disposalImage);

        TV myTV = new TV();
        Disposal myDisposal = new Disposal();
        Light myLight = new Light();
        mySwitch = new Switch();
        mySwitch.wireUp(myDisposal);
        mySwitch.wireUp(myTV);
        mySwitch.switchUp();
        mySwitch.wireUp(myLight);
        bigRedButton = (ImageButton) findViewById(R.id.bigRedButton);
        bigRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySwitch.remotePressed();
            }
        });
        lightSwitch = (CheckBox) findViewById(R.id.lightSwitch);
        lightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mySwitch.switchUp();
                } else {
                    mySwitch.switchDown();
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void turnOn() {
        isOn = true;
    }


    public void turnOff() {
        //mySwitch.switchDown();
        isOn = false;
    }

    public boolean isItOn() {
        return isOn;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
