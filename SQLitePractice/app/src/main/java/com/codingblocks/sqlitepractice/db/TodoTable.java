package com.codingblocks.sqlitepractice.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codingblocks.sqlitepractice.model;

import java.util.ArrayList;
import java.util.Arrays;

public class TodoTable
{
    static String TABLE_NAME = "todos";

    interface Columns{
        String id = "id";
        String task = "task";
        String done = "done";
    }

    static String CMD_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                    "\n(\n" + Columns.id + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    Columns.task + " TEXT,\n" +
                    Columns.done + " BOOLEAN\n" +
                    ");";

    public static void insertTodo(SQLiteDatabase db, model Todo)
    {
        ContentValues row = new ContentValues();
        row.put(Columns.task, Todo.getTask());
        row.put(Columns.done, Todo.getDone());

        db.insert(TABLE_NAME, null, row);
    }

    public static ArrayList<model> getAllTodos(SQLiteDatabase db)
    {
        ArrayList<model> todos = new ArrayList<>();

        @SuppressLint("Recycle") Cursor c = db.query(TABLE_NAME,
                new String[]{Columns.id, Columns.task, Columns.done},
                null,null,
                null,null,
                null);

        while (c.moveToNext())
        {
            model todo = new model(c.getString(1), c.getInt(2)==1);
            todos.add(todo);
        }

        return todos;
    }
}
