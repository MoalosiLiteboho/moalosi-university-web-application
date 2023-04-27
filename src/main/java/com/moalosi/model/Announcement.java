package com.moalosi.model;

import java.time.LocalDate;
import java.util.Objects;

public final class Announcement {
    private int id;
    private int instructorId;
    private int courseId;
    private String tittle;
    private String announcement;
    private LocalDate createdDate;

    public Announcement(int id, int instructorId, int courseId, String tittle, String announcement, LocalDate createdDate) {
        this.id = id;
        this.instructorId = instructorId;
        this.courseId = courseId;
        this.tittle = tittle;
        this.announcement = announcement;
        this.createdDate = createdDate;
    }

    public int id() {
        return id;
    }

    public int instructorId() {
        return instructorId;
    }

    public int courseId() {
        return courseId;
    }

    public String tittle() {
        return tittle;
    }

    public String announcement() {
        return announcement;
    }

    public LocalDate createdDate() {
        return createdDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Announcement) obj;
        return this.id == that.id &&
                this.instructorId == that.instructorId &&
                this.courseId == that.courseId &&
                Objects.equals(this.tittle, that.tittle) &&
                Objects.equals(this.announcement, that.announcement) &&
                Objects.equals(this.createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instructorId, courseId, tittle, announcement, createdDate);
    }

    @Override
    public String toString() {
        return "Announcement[" +
                "id=" + id + ", " +
                "instructorId=" + instructorId + ", " +
                "courseId=" + courseId + ", " +
                "tittle=" + tittle + ", " +
                "announcement=" + announcement + ", " +
                "createdDate=" + createdDate + ']';
    }

}
