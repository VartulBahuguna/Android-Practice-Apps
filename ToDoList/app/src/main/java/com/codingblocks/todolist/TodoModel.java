package com.codingblocks.todolist;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TodoModel {

    String title;
    String description;
    String category;
    long date;
    long time;
    int isFinished = -1;
    @PrimaryKey(autoGenerate = true)
    Long id ;

    public TodoModel(String title, String description, String category, long date, long time) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.date = date;
        this.time = time;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getFinished() {
        return isFinished;
    }

    public void setFinished(int finished) {
        this.isFinished = finished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
