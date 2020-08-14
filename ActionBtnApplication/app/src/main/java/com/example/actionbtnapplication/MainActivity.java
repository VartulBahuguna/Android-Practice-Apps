package com.example.actionbtnapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "BTN";

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    Button btn2;
    Button btn3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Created");

        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button2 clicked");
            }
        });

        btn3.setOnClickListener(this);
    }
    public void sendMessage(View view) {
        // Do something in response to button

        tv = findViewById(R.id.textView);
        Log.d(TAG, "Button1 Clicked");
        System.out.println("Button1 Clicked");
        Intent intent = new Intent(this, MainActivity2.class);
        String message = "HELLO";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Destroyed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Pause");
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Button3 Clicked");
    }

    public void ButtononClick(View v)
    {
        Log.d(TAG, "Button1 Clicked");
    }


}
