package com.codingblocks.customview;

import java.util.ArrayList;

public class Teachers
{
    String name;
    String course;

    public Teachers(String name, String course)
    {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

   public static ArrayList<Teachers> getTeacher()
   {
       ArrayList<Teachers> lst = new ArrayList<>();

       lst.add(new Teachers("Aranav", "Android"));
       lst.add(new Teachers("Pratek", "C++"));
       lst.add(new Teachers("Rishabh", "Java"));
       lst.add(new Teachers("Garima", "Java"));
       lst.add(new Teachers("Harshit", "Android"));
       lst.add(new Teachers("Ayush", "NodeJS"));
       lst.add(new Teachers("Aranav", "NodeJS"));
       lst.add(new Teachers("Prateek", "Python"));

       return lst;
   }
}
