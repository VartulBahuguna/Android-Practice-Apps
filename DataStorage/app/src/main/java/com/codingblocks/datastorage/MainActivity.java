package com.codingblocks.datastorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity{

    EditText et;
    TextView tv;
    LinearLayout ll;
    Button btn1, btn2, red, green, blue;
    SharedPreferences sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et1);
        tv = findViewById(R.id.tv);
        btn1 = findViewById(R.id.btnWrite);
        btn2 = findViewById(R.id.btnRead);
        red = findViewById(R.id.Red);
        blue = findViewById(R.id.Blue);
        green = findViewById(R.id.Green);
        ll = findViewById(R.id.ll);

        sf = getPreferences(MODE_PRIVATE);
        ll.setBackgroundColor(sf.getInt("Color", Color.WHITE));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dataDir = ContextCompat.getDataDir(MainActivity.this);
                File myFile = new File(dataDir, "file.txt");

                String text = et.getText().toString();

                try {
                    FileOutputStream fos = new FileOutputStream(myFile);
                    fos.write(text.getBytes());
                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "FILE NOT FOUND", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "ERROR WRITING FILE", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dataDir = ContextCompat.getDataDir(MainActivity.this);
                File myFile = new File(dataDir, "file.txt");

                try {
                    FileInputStream fis = new FileInputStream(myFile);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);

                    StringBuilder sb = new StringBuilder();

                    String buff = br.readLine();

                    while (buff != null)
                    {
                        sb.append(buff);
                        buff = br.readLine();
                    }
                    tv.setText(sb.toString());
                }
                catch (FileNotFoundException e)
                {
                    Toast.makeText(MainActivity.this, "FILE NOT FOUND", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    Toast.makeText(MainActivity.this, "ERROR READING FILE", Toast.LENGTH_SHORT).show();
                }
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.setBackgroundColor(Color.RED);
                saveColor(Color.RED, sf);
            }
        });

        blue.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.setBackgroundColor(Color.BLUE);
                saveColor(Color.BLUE, sf);
            }
        }));

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.setBackgroundColor(Color.GREEN);
                saveColor(Color.GREEN, sf);
            }
        });

//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);


    }

    public static void saveColor(int color, SharedPreferences sf)
    {
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor ed = sf.edit();
        ed.putInt("Color", color);
        ed.apply();
    }


//    @Override
//    public void onClick(View v) {
//
//        File dataDir = ContextCompat.getDataDir(this);
//        File myFile = new File(dataDir, "file.txt");
//
//        switch (v.getId()) {
//            case R.id.btnWrite:
//
//                String text = et.getText().toString();
//
//                try {
//                    FileOutputStream fos = new FileOutputStream(myFile);
//                    fos.write(text.getBytes());
//                } catch (FileNotFoundException e) {
//                    Toast.makeText(this, "FILE NOT FOUND", Toast.LENGTH_SHORT).show();
//                } catch (IOException e) {
//                    Toast.makeText(this, "ERROR WRITING FILE", Toast.LENGTH_SHORT).show();
//                }
//
//            case R.id.btnRead:
//
//                try {
//                    FileInputStream fis = new FileInputStream(myFile);
//                    InputStreamReader isr = new InputStreamReader(fis);
//                    BufferedReader br = new BufferedReader(isr);
//
//                    StringBuilder sb = new StringBuilder();
//
//                    String buff = br.readLine();
//
//                    while (buff != null)
//                    {
//                        sb.append(buff);
//                        buff = br.readLine();
//                    }
//                    tv.setText(sb.toString());
//                }
//                catch (FileNotFoundException e)
//                {
//                    Toast.makeText(this, "FILE NOT FOUND", Toast.LENGTH_SHORT).show();
//                }
//                catch (IOException e)
//                {
//                    Toast.makeText(this, "ERROR READING FILE", Toast.LENGTH_SHORT).show();
//                }
//        }
//
//    }
}