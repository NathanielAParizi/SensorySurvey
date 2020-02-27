package com.example.sensorysurvey;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sensorysurvey.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Holds an instance of the SensorManager system service.
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the sensor service and retrieve the list of sensors.
        mSensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList  =
                mSensorManager.getSensorList(Sensor.TYPE_ALL);

        // Iterate through the list of sensors, get the sensor name,
        // append it to the string.
        StringBuilder sensorText = new StringBuilder();
        //String sensorText = "";
        for (Sensor currentSensor : sensorList ) {
            sensorText.append(currentSensor.getName()).append(
                    System.getProperty("line.separator"));
        }

        // Update the sensor list text view to display the list of sensors.
        TextView sensorTextView = (TextView) findViewById(R.id.sensor_list);
        sensorTextView.setText(sensorText);
    }
}