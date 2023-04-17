package com.moalosi.model;

public record Feedback(
        int id,
        int courseId,
        String rating,
        String feedback
) {
}
