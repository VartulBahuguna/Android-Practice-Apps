package com.codingblocks.roomlib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pools;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity<Synchronized> extends AppCompatActivity {

    AppDb db;
    Button btn1,btn2;
    TextView tv1, tv2, tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDb.getAppDbInstance(this);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    db.userDao().insert(new User("Vartul", 19));
                }
                catch (Exception e)
                {
                    System.out.println(e.toString());
                    Log.d("Error", e.toString());
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {


                try
                {
                   List<User> lst = db.userDao().getALlUsers();

                   if(!lst.isEmpty())
                   {
                       tv1.setText(Integer.toString(lst.get(0).getId()));
                       tv2.setText(lst.get(0).getName());
                       tv3.setText(Integer.toString(lst.get(0).getAge()));
                   }
                }
                catch (Exception e)
                {
                    System.out.println(e.toString());
                    Log.d("Error", e.toString());
                }

            }
        });
    }
}