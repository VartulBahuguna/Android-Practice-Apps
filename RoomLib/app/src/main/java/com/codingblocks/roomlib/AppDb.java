package com.codingblocks.roomlib;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDb extends RoomDatabase {
    abstract UserDao userDao();


    //For Singleton
    private static volatile AppDb appDbInstance;

    static AppDb getAppDbInstance(final Context context){
        if(appDbInstance == null){
            synchronized (AppDb.class) {
                appDbInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDb.class,
                        "user.db").allowMainThreadQueries().build();
            }
        }
        return appDbInstance;
    }
}
