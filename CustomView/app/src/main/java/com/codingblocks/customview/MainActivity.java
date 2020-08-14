package com.codingblocks.customview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Toolbar tb;
    ListView lv;
    String[] str = {"India",
        "Australia",
        "Ireland",
        "USA",
        "Brazil",
        "Russia",
        "France",
        "Spain",
        "Italy",
        "Germany",
        "Poland",
        "Mexico"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = findViewById(R.id.tb);
        lv = findViewById(R.id.lv);

        tb.setTitle("Countries");

        ArrayAdapter<String> adpt = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.countries));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);

                i.putExtra("countryName", lv.getItemAtPosition(position).toString());
                startActivity(i);
            }
        });

        lv.setAdapter(adpt);

    }
}