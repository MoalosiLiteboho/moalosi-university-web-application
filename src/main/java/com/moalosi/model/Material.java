package com.moalosi.model;

import java.util.Objects;

public final class Material {
    private int id;
    private int courseId;
    private String name;
    private String filePath;

    public Material(int id, int courseId, String name, String filePath) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.filePath = filePath;
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

    public String filePath() {
        return filePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Material) obj;
        return this.id == that.id &&
                this.courseId == that.courseId &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.filePath, that.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, name, filePath);
    }

    @Override
    public String toString() {
        return "Material[" +
                "id=" + id + ", " +
                "courseId=" + courseId + ", " +
                "name=" + name + ", " +
                "filePath=" + filePath + ']';
    }

}
