package com.example.quikblox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if we are running on Android 5.0 or higher
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        }else { // For below API 21

        }

    }

    public void showStandaloneToolbar(View view) {
        Intent i = new Intent(this, StandaloneToolbar.class);
        startActivity(i);
    }

    public void showToolbarAsActionbar(View view) {
        Intent i = new Intent(this, ActionBarToolbar.class);
        startActivity(i);
    }

    public void showContextualMenu(View view) {
        Intent i = new Intent(this, ContextualMenu.class);
        startActivity(i);
    }
}