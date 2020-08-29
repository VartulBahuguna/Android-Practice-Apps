package com.codingblocks.roomlib;

import android.widget.ListView;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insert(User user);

    @Insert
    public void insertAll(List<User> lst);

//    @Delete
//    public void delete();

    @Query("Select * from User")
    public List<User> getALlUsers();

    @Query("Select * from User where age >= :age")
    public List<User> getUserWithAge(int age);
}
