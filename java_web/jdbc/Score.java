package com.cheng.jdbc;

/**
 * @author nuonuo
 * @create 2020-11-16 13:51
 */
public class Score {
    private int id;
    private double score;
    private int studentId;
    private int courseId;

    public Score() {
    }

    public Score(int id, double score, int studentId, int courseId) {
        this.id = id;
        this.score = score;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
