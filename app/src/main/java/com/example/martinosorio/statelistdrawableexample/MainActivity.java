package com.example.martinosorio.statelistdrawableexample;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView TextView_OrientationLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int buttonPressedResourceID = R.drawable.state_one;
        int buttonDefaultResourceID = R.drawable.state_two;

        Resources resources = getApplicationContext().getResources();

        StateListDrawable states = new StateListDrawable();
        states.addState(new int[] {android.R.attr.state_pressed}, resources.getDrawable(buttonPressedResourceID));
        states.addState(new int[] {android.R.attr.state_focused}, resources.getDrawable(buttonPressedResourceID));
        states.addState(new int[] {}, resources.getDrawable(buttonDefaultResourceID));

        ((Button) findViewById(R.id.Button_SLDExample)).setBackgroundDrawable(states);
    }

    //this code was derived from an example online
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_main);

        TextView_OrientationLabel = (TextView) findViewById(R.id.TextView_OrientationLabel);
        int orientation = newConfig.orientation;

        switch (orientation) {
            case Configuration.ORIENTATION_LANDSCAPE:
                TextView_OrientationLabel.setText("My orientation is LANDSCAPE");
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                TextView_OrientationLabel.setText("My orientation is  ");
                break;
        }
    }
}
