package com.codingblocks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button btn;
    TextView DisplayTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        String result = i.getStringExtra("result");
        DisplayTv = findViewById(R.id.displayTV);
        btn = findViewById(R.id.btn);
        DisplayTv.setText(result);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                Intent it = new Intent(MainActivity2.this, MainActivity.class);
//                it.putExtra("DoReset", true);
//                startActivity(it);
            }
        });

    }
}