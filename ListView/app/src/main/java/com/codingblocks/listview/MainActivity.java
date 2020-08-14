package com.codingblocks.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.codingblocks.listview.R.*;

public class MainActivity extends AppCompatActivity {

    ListView lvFruits;
    TextView tvFruitName;
    String[] fruits = {"apple", "mangoes", "Bananas", "Kiwis" ,"oranges", "melons", "papayas", "pears", "grapes", "litchis",
            "apples", "mangoes", "Bananas", "Kiwis" ,"oranges", "melons", "papayas", "pears", "grapes", "litchis",
            "apples", "mangoes", "Bananas", "Kiwis" ,"oranges", "melons", "papayas", "pears", "grapes", "litchis",
            "apples", "mangoes", "Bananas", "Kiwis" ,"oranges", "melons", "papayas", "pears", "grapes", "litchis",
            "apples","mangoes", "Bananas", "Kiwis" ,"oranges", "melons", "papayas", "pears", "grapes", "litchis"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);


        lvFruits = findViewById(R.id.lvFruits);
        tvFruitName = findViewById(R.id.tvFruitName);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this,
                layout.list_item_fruit,
                id.tvFruitName,
                fruits);

        lvFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Jhonny ate " + (position+1) + " " + tvFruitName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lvFruits.setAdapter(listAdapter);


    }
}