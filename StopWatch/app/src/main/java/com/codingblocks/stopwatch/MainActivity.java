package com.codingblocks.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button start,reset;
    TextView time;
    boolean running = false;
    int secs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        reset = findViewById(R.id.reset);
        time = findViewById(R.id.time);

       runTimer();
    }

    private void runTimer()
    {
        final Handler handler = new Handler();

        handler.post(new Runnable(){

            @Override
            public void run()
            {
                int hr = secs/3600;
                int min = (secs%3600)/60;
                int sec = secs%60;

                @SuppressLint("DefaultLocale")
                String timer = String.format("%d:%02d:%02d",hr,min,sec);

                time.setText(timer);

                if(running)
                {
                    secs++;
                }

                handler.postDelayed(this,1000);
            }
        });

    }

    public void onStart(View view)
    {
        if(running)
        {
            running = false;
            start.setText(getResources().getString(R.string.Start));
        }
        else
        {
            running = true;
            start.setText(getResources().getString(R.string.Stop));
            reset.setVisibility(View.VISIBLE);
            reset.setClickable(true);
        }
    }

    @SuppressLint("SetTextI18n")
    public void onReset(View view)
    {
        running = false;
        secs = 0;
        reset.setVisibility(View.INVISIBLE);
        reset.setClickable(false);
        time.setText("0:00:00");
        start.setText(getResources().getString(R.string.Start));
    }
}