package com.codingblocks.listviewperf;

import java.util.ArrayList;
import java.util.Random;

public class Courses {
    String name;
    String teacherName;
    int lectures;

    public Courses(String name, String teacherName, int lectures) {
        this.name = name;
        this.teacherName = teacherName;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getLectures() {
        return lectures;
    }

    public static final String[] teachers = {
        "Harshit", "Arnav", "Prateek", "Aayush", "Deepak", "Garima"
    };

    public static final String[] coursesNames = {
            "Launchpad", "Crux", "Android", "NodeJS", "AngularJS"
    };

    public static ArrayList<Courses> generateNRandomCourses(int n)
    {
        ArrayList<Courses> courses = new ArrayList<>();

        Random r = new Random();

        for (int i = 0; i < n; i++)
        {
            Courses course = new Courses(
                    teachers[r.nextInt(6)],
                    coursesNames[r.nextInt(5)],
                    10 + r.nextInt(10)
            );
            courses.add(course);
        }

        return  courses;
    }
}
