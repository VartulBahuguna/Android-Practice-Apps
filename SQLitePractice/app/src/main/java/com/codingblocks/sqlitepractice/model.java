package com.codingblocks.sqlitepractice;

import java.util.Objects;

public class model {

    String task;
    Boolean done;

    public model(String task, Boolean done)
    {
        this.task = task;
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public Boolean getDone() {
        return done;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return this.task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        model model = (model) o;
        return Objects.equals(task, model.task) &&
                Objects.equals(done, model.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, done);
    }
}
