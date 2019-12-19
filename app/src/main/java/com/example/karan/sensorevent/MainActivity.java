package com.example.karan.sensorevent;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
TextView tv;
SensorManager sm;
Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textview);
        sm= (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        tv.setText("x: "+ sensorEvent.values[0]);//+"\nY:" +sensorEvent.values[1]+"\nZ: "+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
