package com.codingblocks.alarams;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @SuppressLint("ShortAlarm")
    @Override
    public void onClick(View v)
    {
        Intent i = new Intent(this, MainActivity2.class);
        PendingIntent pi = PendingIntent.getActivity(this, 12345, i,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alm = (AlarmManager) getSystemService(ALARM_SERVICE);
        assert alm != null;
        alm.set(AlarmManager.ELAPSED_REALTIME,  SystemClock.elapsedRealtime() +5000, pi);
        //alm.setRepeating(AlarmManager.ELAPSED_REALTIME,  SystemClock.elapsedRealtime() +5000,10000, pi);
    }
}