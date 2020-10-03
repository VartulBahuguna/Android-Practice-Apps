package com.codingblocks.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<TodoModel> lst ;
    TodoAdapter adapter;
    AppDatabase db ;
    RecyclerView todoRv;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setSupportActionBar(toolbar);

        todoRv.setLayoutManager(new LinearLayoutManager(this));
        todoRv.setAdapter(this.adapter);

        db.todoDao().getTask().observe(this, new Observer<List<TodoModel>>() {
            @Override
            public void onChanged(List<TodoModel> list) {

                adapter.setTodos(list);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.history:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initialize(){
        toolbar = findViewById(R.id.toolbar);
        todoRv = findViewById(R.id.todoRv);
        db = AppDatabase.getDatabase(this);
        lst = new ArrayList<>();
        adapter = new TodoAdapter(lst);
    }

    public void openNewTask(View view) {
        startActivity(new Intent(this, TaskActivity.class));
    }
}