package com.moalosi.model;

import java.time.LocalDate;
import java.util.Objects;

public final class EnrollmentCourse {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;

    public EnrollmentCourse(int id, int studentId, int courseId, LocalDate enrollmentDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public int id() {
        return id;
    }

    public int studentId() {
        return studentId;
    }

    public int courseId() {
        return courseId;
    }

    public LocalDate enrollmentDate() {
        return enrollmentDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EnrollmentCourse) obj;
        return this.id == that.id &&
                this.studentId == that.studentId &&
                this.courseId == that.courseId &&
                Objects.equals(this.enrollmentDate, that.enrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, courseId, enrollmentDate);
    }

    @Override
    public String toString() {
        return "EnrollmentCourse[" +
                "id=" + id + ", " +
                "studentId=" + studentId + ", " +
                "courseId=" + courseId + ", " +
                "enrollmentDate=" + enrollmentDate + ']';
    }

}
