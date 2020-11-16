package com.cheng.jdbc;

/**
 * @author nuonuo
 * @create 2020-11-16 13:54
 */
public class Course {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course() {
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
