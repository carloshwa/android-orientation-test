package com.example.orientationtest;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private static final int ORIENTATION_DEFAULT = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    private static final int ORIENTATION_TARGET = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;

    ToggleButton orientationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getRequestedOrientation() != ORIENTATION_TARGET) {
            setRequestedOrientation(ORIENTATION_DEFAULT);
        }

        setContentView(R.layout.activity_main);

        orientationButton = ((ToggleButton) findViewById(R.id.orientation_button));
        orientationButton.setChecked(getRequestedOrientation() == ORIENTATION_TARGET);
        orientationButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        setRequestedOrientation(isChecked ? ORIENTATION_TARGET : ORIENTATION_DEFAULT);
    }
}
