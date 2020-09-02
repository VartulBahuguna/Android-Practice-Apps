package com.codingblocks.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et ;
    Button btn;
    ListView lv;

    ArrayList<String> lst = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);
        lv = findViewById(R.id.lv);
       // Adapter listAdapter = new Adapter();

        final ArrayAdapter<String> lvAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, lst);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = et.getText().toString();
                if(!str.isEmpty())
                {
                    lst.add(str);
                    et.setText("");
                    System.out.println(lst);
//                    Adapter listAdapter = new Adapter();
//                    listAdapter.notifyDataSetChanged();
                    lvAdapter.notifyDataSetChanged();

                }
            }
        });


        //lv.setAdapter(listAdapter);
        lv.setAdapter(lvAdapter);
    }

//    class Adapter extends BaseAdapter
//    {
//
//        @Override
//        public int getCount() {
//            return lst.size();
//        }
//
//        @Override
//        public String getItem(int position) {
//            return lst.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent)
//        {
//            ListViewHolder holder;
//
//            if(convertView == null)
//            {
//                convertView = getLayoutInflater().inflate(
//                        R.layout.list_view_content,
//                        parent,
//                        false
//                );
//
//                holder = new ListViewHolder(convertView);
//                convertView.setTag(holder);
//            }
//            else
//            {
//                holder = (ListViewHolder) convertView.getTag();
//            }
//
//            String item = getItem(position);
//
//            holder.tvNum.setText(position+1);
//            holder.tvTask.setText(item);
//
//            return convertView;
//        }
//    }
//
//    class ListViewHolder
//    {
//        TextView tvNum, tvTask;
//
//        public ListViewHolder(View convertView) {
//            this.tvNum = convertView.findViewById(R.id.tvNum);
//            this.tvTask = convertView.findViewById(R.id.tvTask);
//        }
//    }
}