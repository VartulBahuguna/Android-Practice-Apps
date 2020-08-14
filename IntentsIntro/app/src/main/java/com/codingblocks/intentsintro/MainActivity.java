package com.codingblocks.intentsintro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    EditText etVar1, etVar2, etUrl;
    TextView tvResult;
    ImageButton btnBrowse;

    public static final String TAG = "MFA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        etUrl = findViewById(R.id.etUrl);
        btnBrowse = findViewById(R.id.btnBrowse);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var1 = Integer.parseInt(etVar1.getText().toString());
                int var2 = Integer.parseInt(etVar2.getText().toString());
                tvResult.setText(String.valueOf(var1 + var2));

                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("result", var1 + var2);
                i.putExtra("Hello", "Vartul");
                startActivity(i);

            }
        });

        String url = etUrl.getText().toString();
        Uri uri = Uri.parse(url);

        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(i);
        } catch (ActivityNotFoundException anfe) {
            Log.e(TAG, "Could not open activity", anfe);
            Toast.makeText(MainActivity.this, "Not a valid URI", Toast.LENGTH_SHORT).show();
        }
    }


}
