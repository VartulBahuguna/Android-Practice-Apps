package com.codingblocks.customview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView flag ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mToolbar = findViewById(R.id.tb);
        flag = findViewById(R.id.iv);

        Bundle b = getIntent().getExtras();



        if(b != null)
        {
            mToolbar.setTitle(b.getString("countryName"));
            if (mToolbar.getTitle().toString().equalsIgnoreCase("Australia")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_australia));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("Brazil")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_brazil));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("France")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_france));
            } else if ("Germany".equalsIgnoreCase(mToolbar.getTitle().toString())) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_germany));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("India")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_india));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("Ireland")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_ireland));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("Italy")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_italy));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("Mexico")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_mexico));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("Poland")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_poland));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("Russia")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_russia));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("Spain")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_spain));
            } else if (mToolbar.getTitle().toString().equalsIgnoreCase("US")) {
                flag.setImageDrawable(ContextCompat.getDrawable(MainActivity2.this, R.drawable.flag_usa));
            }
        }

    }
}