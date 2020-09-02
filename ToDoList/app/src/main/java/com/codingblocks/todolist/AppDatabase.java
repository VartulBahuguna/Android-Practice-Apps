package com.codingblocks.todolist;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TodoModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    abstract TodoDao todoDao();
}
