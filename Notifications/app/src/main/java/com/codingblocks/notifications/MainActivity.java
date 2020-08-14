package com.codingblocks.notifications;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3;
    NotificationManager nm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn1);
        btn3 = findViewById(R.id.btn2);

        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
       {
           NotificationChannel channel = new NotificationChannel("first", "default", NotificationManager.IMPORTANCE_HIGH);
           channel.setLightColor(Color.GREEN);
           channel.enableLights(true);
           nm.createNotificationChannel(channel);
       }

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn1:
                Notification sn1 = new NotificationCompat.Builder(this, "first")
                        .setContentTitle("Notification from button 1")
                        .setContentText("Hey there")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();

                nm.notify(1,sn1);
                break;

            case R.id.btn2:
                Notification sn2 = new NotificationCompat.Builder(this, "first")
                        .setContentTitle("Notification from button 2")
                        .setContentText("How you Do'in")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();

                nm.notify(2,sn2);
                break;

            case R.id.btn3:
                Notification sn3 = new NotificationCompat.Builder(this, "first")
                        .setContentTitle("Notification from button 3")
                        .setContentText("Bye Bye")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();

                nm.notify(3,sn3);

        }
    }
}