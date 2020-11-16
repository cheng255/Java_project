package com.cheng.jdbc;

/**
 * @author nuonuo
 * @create 2020-11-16 13:47
 */
public class Student {
    private int id;//id
    private int sn;//学号
    private String name;//姓名
    private String qqMail;
    private int classesId;

    public Student(int id, int sn, String name, String qqMail, int classesId) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.qqMail = qqMail;
        this.classesId = classesId;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQqMail() {
        return qqMail;
    }

    public void setQqMail(String qqMail) {
        this.qqMail = qqMail;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }
}
