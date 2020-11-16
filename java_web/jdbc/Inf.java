package com.cheng.jdbc;

import java.math.BigDecimal;

/**
 * @author nuonuo
 * @create 2020-11-16 13:47
 */
public class Inf {
    private int id;//id
    private int sn;//学号
    private String name;//姓名
    private String classesName;//学生名称
    private String course;//课程
    private BigDecimal score;//分数

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Inf() {
    }

    public Inf(int id, int sn, String name, String classesName, String course, BigDecimal score) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.classesName = classesName;
        this.course = course;
        this.score = score;
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

    @Override
    public String toString() {
        return "Inf{" +
                "id=" + id +
                ", sn=" + sn +
                ", name='" + name + '\'' +
                ", classesName='" + classesName + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
