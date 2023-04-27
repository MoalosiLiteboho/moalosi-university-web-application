package com.moalosi.model;

import java.time.LocalDate;
import java.util.Objects;

public final class Assignment {
    private int id;
    private int courseId;
    private String name;
    private LocalDate creationDate;
    private LocalDate deadLine;
    private String assigmentPath;

    public Assignment(int id, int courseId, String name, LocalDate creationDate, LocalDate deadLine, String assigmentPath) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.creationDate = creationDate;
        this.deadLine = deadLine;
        this.assigmentPath = assigmentPath;
    }

    public int id() {
        return id;
    }

    public int courseId() {
        return courseId;
    }

    public String name() {
        return name;
    }

    public LocalDate creationDate() {
        return creationDate;
    }

    public LocalDate deadLine() {
        return deadLine;
    }

    public String assigmentPath() {
        return assigmentPath;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public String getAssigmentPath() {
        return assigmentPath;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Assignment) obj;
        return this.id == that.id &&
                this.courseId == that.courseId &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.creationDate, that.creationDate) &&
                Objects.equals(this.deadLine, that.deadLine) &&
                Objects.equals(this.assigmentPath, that.assigmentPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, name, creationDate, deadLine, assigmentPath);
    }

    @Override
    public String toString() {
        return "Assignment[" +
                "id=" + id + ", " +
                "courseId=" + courseId + ", " +
                "name=" + name + ", " +
                "creationDate=" + creationDate + ", " +
                "deadLine=" + deadLine + ", " +
                "assigmentPath=" + assigmentPath + ']';
    }

}
