package com.codingblocks.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btnFruit, btnVeg;

    FragmentManager Fru;
    FragmentManager Veg;
    FragmentTransaction

    boolean vegFrag = false;
    boolean fruFrag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnFruit = findViewById(R.id.Fruits);
        btnVeg = findViewById(R.id.Veg);

        Fru = getSupportFragmentManager();
        Veg = getSupportFragmentManager();

        btnFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fruFrag)
                {
                    Fru.beginTransaction().remove(new Fruit()).commit();
             //       Fru.beginTransaction().replace(R.id.frag, new Fruit()).commit();
                    fruFrag = false;
                }
                else
                {
                    Fru.beginTransaction().replace(R.id.frag, new Fruit()).commit();
                    fruFrag = true;
                    vegFrag = false;
                }
                System.out.println(fruFrag + " " + vegFrag);
            }
        });

        btnVeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(vegFrag)
            {
                Veg.beginTransaction().remove(new Vegetables()).commit();
                //Veg.beginTransaction().replace(R.id.frag, new Vegetables()).commit();
                vegFrag = false;
            }
            else
            {
                Veg.beginTransaction().replace(R.id.frag, new Vegetables()).commit();
                fruFrag = false;
                vegFrag = true;
            }
            System.out.println(fruFrag + " " + vegFrag);

            }
        });
    }
}