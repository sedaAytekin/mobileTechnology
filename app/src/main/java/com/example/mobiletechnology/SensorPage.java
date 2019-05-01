package com.example.mobiletechnology;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SensorPage extends AppCompatActivity implements SensorEventListener {

    @BindView(R.id.text)
    TextView text;
    private SensorManager sensorManager;
    private float mAccelCurrent; // current acceleration including gravity
    private Vibrator vibrator;
    @BindView(R.id.layout)
    LinearLayout layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_page);
        ButterKnife.bind(this);
        //actionbarı saklıyoruz.
        getSupportActionBar().hide();

        layout.setBackgroundColor(Color.WHITE);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager == null) {
            Toast.makeText(this, "Cihazınız sensörü desteklemiyor :(", Toast.LENGTH_SHORT).show();
            throw new UnsupportedOperationException("Sensors not supported");
        }
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI);

        mAccelCurrent = SensorManager.GRAVITY_EARTH;


    }

    //Accelerometer adlı sensörden gelen hareketler onSensorChanged metodu içerisinde dinlenmeye başlanacaktır.
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //x,y ve z eksenine göre değişiklikleri bize veriyor.
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));

            //cihaz hareketlerine bakıyoruz.Bu gerçekleştiğinde de vibrate metoduyla 500 ms süre boyunca cihazı titreterek kullanıcıya bir uyarı veriyoruz.
            if (mAccelCurrent > 10){
                layout.setBackgroundColor(Color.BLACK);
                vibrator.vibrate(500);
            }else{
                layout.setBackgroundColor(Color.WHITE);
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }

}
