package com.moalosi.model;

public record StudentFeedback(
        int id,
        int courseId,
        String rating,
        String feedback
) {
}
