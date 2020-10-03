package com.codingblocks.todolist;

import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.google.android.material.textfield.TextInputLayout;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener{

    EditText dateEdt, timeEdt;
    TextInputLayout timeInpLay, titleInpLay, taskInpLay;
    Spinner spinnerCategory;
    Button saveBtn;
    Long finalDate = 0L, finalTime = 0L;

    AppDatabase db;

    private static final String  DB_NAME = "todo.db";

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener dateSetListener;
    TimePickerDialog.OnTimeSetListener timeSetListener;

    List<String> labels = new ArrayList<>(
            Arrays.asList("Personal",
                    "Business", "Insurance",
                    "Shopping", "Banking"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        initialize();

        setOnCLickListener();
        
        setUpSpinner();

    }

    private void initialize(){
        dateEdt = findViewById(R.id.dateEdt);
        timeInpLay = findViewById(R.id.timeInpLay);
        timeEdt = findViewById(R.id.timeEdt);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        saveBtn = findViewById(R.id.saveBtn);
        titleInpLay = findViewById(R.id.titleInpLay);
        taskInpLay = findViewById(R.id.taskInpLay);
        db = AppDatabase.getDatabase(this);
    }

    private void setOnCLickListener(){

        dateEdt.setOnClickListener(this);
        timeEdt.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.dateEdt :
                setDateListener();
                break;

            case R.id.timeEdt :
                setTimeListener();
                break;

            case R.id.saveBtn:
                saveTodo();
                break;

        }
    }

    private void saveTodo() {

        String category = spinnerCategory.getSelectedItem().toString();
        String title = Objects.requireNonNull(titleInpLay.getEditText()).toString();
        String description = Objects.requireNonNull(taskInpLay.getEditText()).toString();


        try
        {

                db.todoDao().insertTask(
                        new TodoModel(
                                title,
                                description,
                                category,
                                finalDate,
                                finalTime
                        )
                );


        }
        catch (Exception e)
        {
            System.out.println("Error Inserting Items-------> " + e);
            Log.d("ErrorInsertingItems--> ", e.toString());
        }
    }

    private void setUpSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                labels);

        Collections.sort(labels);

        spinnerCategory.setAdapter(adapter);

    }

    private void setTimeListener() {
        myCalendar = Calendar.getInstance();

        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hr, int min) {
                myCalendar.set(Calendar.HOUR_OF_DAY, hr);
                myCalendar.set(Calendar.MINUTE, min);

                updateTime();
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                timeSetListener,
                myCalendar.get(Calendar.HOUR_OF_DAY),
                myCalendar.get(Calendar.MINUTE),
                false
        );

        timePickerDialog.show();
    }

    private void updateTime() {
        String myformat = "h:mm a";

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat(myformat);
        finalTime = myCalendar.getTime().getTime();
        timeEdt.setText(sdf.format(myCalendar.getTime()));

    }

    private void setDateListener() {
        myCalendar = Calendar.getInstance();

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year,
                                  int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                updateDate();
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                dateSetListener,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.getDatePicker().
                setMinDate(System.currentTimeMillis());

        datePickerDialog.show();

    }

    private void updateDate() {
        //Mon, 5 Jan 2020
        String myformat = "EEE, d MMM yyyy";
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat(myformat);
        finalDate =  myCalendar.getTime().getTime();
        dateEdt.setText(sdf.format((myCalendar.getTime())));

        timeInpLay.setVisibility(View.VISIBLE);
    }
}