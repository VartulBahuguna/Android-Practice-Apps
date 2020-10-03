package com.codingblocks.todolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    public long insertTask(TodoModel todoModel);

    @Query("Select * from TodoModel where isFinished != -1")
    public LiveData<List<TodoModel>> getTask();

    @Query("Update TodoModel Set isFinished = 1 where id = :uid")
    void finishTask(long uid);

    @Query("Delete from TodoModel where id = :uid")
    void deleteTask(long uid);

}
