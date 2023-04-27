package com.moalosi.model;

import java.time.LocalDate;
import java.util.Objects;

public final class Course {
    private int id;
    private int instructorId;
    private String name;
    private String description;
    private String type;
    private LocalDate createdDate;

    public Course(int id, int instructorId, String name, String description, String type, LocalDate createdDate) {
        this.id = id;
        this.instructorId = instructorId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.createdDate = createdDate;
    }

    public int id() {
        return id;
    }

    public int instructorId() {
        return instructorId;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String type() {
        return type;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Course) obj;
        return this.id == that.id &&
                this.instructorId == that.instructorId &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.type, that.type) &&
                Objects.equals(this.createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instructorId, name, description, type, createdDate);
    }

    @Override
    public String toString() {
        return "Course[" +
                "id=" + id + ", " +
                "instructorId=" + instructorId + ", " +
                "name=" + name + ", " +
                "description=" + description + ", " +
                "type=" + type + ", " +
                "createdDate=" + createdDate + ']';
    }

}
