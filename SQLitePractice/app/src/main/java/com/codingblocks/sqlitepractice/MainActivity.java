package com.codingblocks.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.codingblocks.sqlitepractice.db.TodoTable;
import com.codingblocks.sqlitepractice.db.dbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText et;
    ListView lv;
    ArrayList<model> todos = new ArrayList<>();
    ArrayAdapter<model> ad;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ad = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                todos);

        btn = findViewById(R.id.btn);
        et = findViewById(R.id.et);
        lv= findViewById(R.id.lv);

        lv.setAdapter(ad);
        db = new dbHelper(MainActivity.this).getWritableDatabase();

        this.refreshTodoList();//call this function when db is initialized

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String newTodo = et.getText().toString();
//
//                todos.add(newTodo);
//                ad.notifyDataSetChanged();
//            }
//        });
        setOnClick(btn);


    }

    public void  setOnClick(View v) {
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                model newTodo = new model(et.getText().toString(), false);

                TodoTable.insertTodo(db, newTodo);
                refreshTodoList();
                et.setText("");
            }
        });
    }

    private void refreshTodoList() {
        ArrayList<model> todoList = TodoTable.getAllTodos(db);
        todos.clear();
        todos.addAll(todoList);
        ad.notifyDataSetChanged();
        Log.d("TODOS", todoList.toString());
    }
}