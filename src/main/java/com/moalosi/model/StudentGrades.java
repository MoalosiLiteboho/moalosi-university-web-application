package com.moalosi.model;

import java.util.Objects;

public final class StudentGrades {
    private int id;
    private int courseId;
    private int assignmentId;
    private int studentId;
    private boolean submitted;
    private int marks;
    private String Grade;

    public StudentGrades(int id, int courseId, int assignmentId, int studentId, boolean submitted, int marks, String Grade) {
        this.id = id;
        this.courseId = courseId;
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.submitted = submitted;
        this.marks = marks;
        this.Grade = Grade;
    }

    public int id() {
        return id;
    }

    public int courseId() {
        return courseId;
    }

    public int assignmentId() {
        return assignmentId;
    }

    public int studentId() {
        return studentId;
    }

    public boolean submitted() {
        return submitted;
    }

    public int marks() {
        return marks;
    }

    public String Grade() {
        return Grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (StudentGrades) obj;
        return this.id == that.id &&
                this.courseId == that.courseId &&
                this.assignmentId == that.assignmentId &&
                this.studentId == that.studentId &&
                this.submitted == that.submitted &&
                this.marks == that.marks &&
                Objects.equals(this.Grade, that.Grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, assignmentId, studentId, submitted, marks, Grade);
    }

    @Override
    public String toString() {
        return "StudentGrades[" +
                "id=" + id + ", " +
                "courseId=" + courseId + ", " +
                "assignmentId=" + assignmentId + ", " +
                "studentId=" + studentId + ", " +
                "submitted=" + submitted + ", " +
                "marks=" + marks + ", " +
                "Grade=" + Grade + ']';
    }

}
