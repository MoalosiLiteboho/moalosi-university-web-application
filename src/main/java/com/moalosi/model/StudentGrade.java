package com.moalosi.model;

import java.util.Objects;

public final class StudentGrade {
    private int id;
    private int mark;
    private String grade;

    public StudentGrade(int id, int mark, String grade) {
        this.id = id;
        this.mark = mark;
        this.grade = grade;
    }

    public int id() {
        return id;
    }

    public int mark() {
        return mark;
    }

    public String grade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (StudentGrade) obj;
        return this.id == that.id &&
                this.mark == that.mark &&
                Objects.equals(this.grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, grade);
    }

    @Override
    public String toString() {
        return "StudentGrade[" +
                "id=" + id + ", " +
                "mark=" + mark + ", " +
                "grade=" + grade + ']';
    }

}
