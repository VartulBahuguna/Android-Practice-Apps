package com.codingblocks.todolist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {TodoModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    abstract TodoDao todoDao();

    private static AppDatabase appDB = null;

    public static AppDatabase getDatabase(final Context context)
    {

            if(appDB == null) {
                synchronized (AppDatabase.class) {
                    appDB = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            "todo.db").allowMainThreadQueries().build();
                }
            }
            return appDB;

    }
}
