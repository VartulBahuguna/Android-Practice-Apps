package com.codingblocks.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ConstraintLayout cl;
    ListView lv;
    private static final String TAG = "ASYNC";

    String[] item = {
            "Alpha",
            "Beta",
            "Gamma",
            "Delta",
            "Phi",
            "Curo",
            "Strata",
            "Humo"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnChngColor);
        cl = findViewById(R.id.clBackground);
        lv = findViewById(R.id.lvItems);

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                item
        );

        lv.setAdapter(itemAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //waitNSec(10);

                Handler h = new Handler();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG,"run: We have waited 5 secs " + System.currentTimeMillis());

                        cl.setBackgroundColor(Color.RED);
                    }
                };
                h.postDelayed(r, 5000);

            }
        });
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