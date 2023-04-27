package com.moalosi.model;

import java.time.LocalDate;
import java.util.Objects;

public final class AssignmentSubmission {
    private int id;
    private int studentId;
    private int courseId;
    private int assignmentId;
    private String path;
    private LocalDate submissionDate;

    public AssignmentSubmission(int id, int studentId, int courseId, int assignmentId, String path, LocalDate submissionDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.assignmentId = assignmentId;
        this.path = path;
        this.submissionDate = submissionDate;
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

    public int assignmentId() {
        return assignmentId;
    }

    public String path() {
        return path;
    }

    public LocalDate submissionDate() {
        return submissionDate;
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

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AssignmentSubmission) obj;
        return this.id == that.id &&
                this.studentId == that.studentId &&
                this.courseId == that.courseId &&
                this.assignmentId == that.assignmentId &&
                Objects.equals(this.path, that.path) &&
                Objects.equals(this.submissionDate, that.submissionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, courseId, assignmentId, path, submissionDate);
    }

    @Override
    public String toString() {
        return "AssignmentSubmission[" +
                "id=" + id + ", " +
                "studentId=" + studentId + ", " +
                "courseId=" + courseId + ", " +
                "assignmentId=" + assignmentId + ", " +
                "path=" + path + ", " +
                "submissionDate=" + submissionDate + ']';
    }

}
