package com.codingblocks.permissions;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.NetworkInterface;

public class MainActivity extends AppCompatActivity {

    Button btn , btnDial;
    TextView tv;
    EditText etNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        btnDial = findViewById(R.id.btnDial);
        etNum = findViewById(R.id.etNum);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                assert cm != null;
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                boolean isConnected = netInfo != null && netInfo.isConnected() ;

                tv.setText(isConnected ? "CONNECTED" : "DISCONNECTED");
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int perm = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);

                if(perm == PackageManager.PERMISSION_GRANTED)
                {
                    call();
                }
                else
                {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{
                                    Manifest.permission.CALL_PHONE
                            },
                            101
                            );
                }

            }
        });
    }

    void call()
    {
        String telno = etNum.getText().toString();
        Uri uri = Uri.parse("tel:" + telno);
        Intent i = new Intent(Intent.ACTION_CALL, uri);
    }
}