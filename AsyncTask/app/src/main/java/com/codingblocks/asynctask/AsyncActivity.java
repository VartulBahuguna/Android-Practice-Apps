package com.codingblocks.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AsyncActivity extends AppCompatActivity {

    TextView tv;
    Button btn, btn2;
    public static final String TAG = "ASYNC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        tv = findViewById(R.id.tv);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                tv.setText(String.valueOf(r.nextInt(100)));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountTask ct = new CountTask();

                ct.execute(5);
            }
        });
    }

    class CountTask extends AsyncTask<Integer, Integer, Void>
    {

        @Override
        protected Void doInBackground(Integer... num) {

            Log.d(TAG, "donInBackground: started");

            int n = num[0];
            
            for (int i = 1; i <= n; i++) {
                wait1Sec();
                publishProgress(i);
            }

            Log.d(TAG, "donInBackground: ended");
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            tv.setText(String.valueOf(values[0]));
        }
    }

    void wait1Sec()
    {
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() < startTime + 1000);
    }

    void waitNSec(int n)
    {
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() < startTime + (n*1000));
    }
}