package com.example.mobiletechnology;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.calculator)
    AppCompatImageView calculator;
    @BindView(R.id.sensor)
    AppCompatImageView sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //actionbarı saklıyoruz.
        getSupportActionBar().hide();

    }

    @OnClick({R.id.calculator, R.id.sensor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calculator:
                Intent intentCalc = new Intent(getApplicationContext(), Calculator.class);
                startActivity(intentCalc);
                break;
            case R.id.sensor:
                Intent intentSensor = new Intent(getApplicationContext(), SensorPage.class);
                startActivity(intentSensor);
                break;
        }
    }
}
