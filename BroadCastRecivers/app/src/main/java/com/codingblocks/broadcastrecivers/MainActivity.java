package com.codingblocks.broadcastrecivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerReciver pr = new powerReciver();

        IntentFilter If = new IntentFilter();
        If.addAction(Intent.ACTION_POWER_DISCONNECTED);
        If.addAction(Intent.ACTION_POWER_CONNECTED);

        registerReceiver(pr, If);
    }

    static class powerReciver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
           Toast.makeText(context, "H", Toast.LENGTH_SHORT).show();
        }
    }
}