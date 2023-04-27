package com.moalosi.model;

import java.util.Objects;

public final class Feedback {
    private int id;
    private int courseId;
    private String rating;
    private String feedback;

    public Feedback(int id, int courseId, String rating, String feedback) {
        this.id = id;
        this.courseId = courseId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public int id() {
        return id;
    }

    public int courseId() {
        return courseId;
    }

    public String rating() {
        return rating;
    }

    public String feedback() {
        return feedback;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Feedback) obj;
        return this.id == that.id &&
                this.courseId == that.courseId &&
                Objects.equals(this.rating, that.rating) &&
                Objects.equals(this.feedback, that.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, rating, feedback);
    }

    @Override
    public String toString() {
        return "Feedback[" +
                "id=" + id + ", " +
                "courseId=" + courseId + ", " +
                "rating=" + rating + ", " +
                "feedback=" + feedback + ']';
    }

}
