package com.codingblocks.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ExampleAdapter mAdapter;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        setViews();

        buttonInsert.setOnClickListener(this);
        buttonRemove.setOnClickListener(this);


    }

    public void setViews(){
        buttonInsert = findViewById(R.id.btnInsert);
        buttonRemove = findViewById(R.id.btnRemove);
        editTextInsert = findViewById(R.id.etInsert);
        editTextRemove = findViewById(R.id.etRemove);
    }

    @Override
    public void onClick(View button) {


        switch (button.getId()){

            case R.id.btnInsert:

                try
                {
                    int insertPos = Integer.parseInt(editTextInsert.getText().toString());
                    editTextInsert.setText("");
                    insert(insertPos);
                }
                catch (Exception e)
                {
                    System.out.println("ERROR---> " + e);
                    Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnRemove:

                try {
                    int deletePos = Integer.parseInt(editTextRemove.getText().toString());
                    editTextRemove.setText("");
                    delete(deletePos);
                }
                catch (Exception e)
                {
                    System.out.println("ERROR---> " + e);
                    Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    private void delete(int deletePos) {
        deletePos--;
        if(deletePos >= 0 && deletePos < mExampleList.size())
        {
            mExampleList.remove(deletePos);
            mAdapter.notifyItemRemoved(deletePos);
        }
        else
        {
            Toast.makeText(this, "Position out bounds", Toast.LENGTH_SHORT).show();
        }
    }

    private void insert(int insertPos) {
        insertPos--;
        if(insertPos >= 0 && insertPos <= mExampleList.size())
        {
            mExampleList.add(insertPos,new ExampleItem(R.drawable.ic_audio,"Item inserted at position " + (insertPos + 1), "Line 2"));
            mAdapter.notifyItemInserted(insertPos);
        }
        else
        {
            Toast.makeText(this, "Position out bounds", Toast.LENGTH_SHORT).show();
        }
    }

    public void changeItem(int position, String text){
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recVi);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteCLick(int position) {
                delete(position+1);
            }
        });
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Line1", "Line2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_audio, "Line3", "Line4"));
        mExampleList.add(new ExampleItem(R.drawable.ic_sun, "Line5", "Line6"));
    }

}