package com.codingblocks.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Teachers> teachers = Teachers.getTeacher();
    ListView lvTeachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTeachers = findViewById(R.id.lvTeachers);

        lvTeachers.setAdapter(new TeacherAdapter());

    }

    private class TeacherAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return teachers.size();
        }

        @Override
        public Teachers getItem(int position) {
            return teachers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            @SuppressLint("ViewHolder") View itemview = getLayoutInflater().inflate(
                R.layout.list_item_teacher,
                    parent,
                    false
            );

            TextView tvName = itemview.findViewById(R.id.tvName);
            TextView tvCourse = itemview.findViewById(R.id.tvCourse);

            tvName.setText(teachers.get(position).name);
            tvCourse.setText(teachers.get(position).course);

            return itemview;
        }
    }

}