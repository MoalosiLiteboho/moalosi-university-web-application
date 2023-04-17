package com.moalosi.model;

import java.time.LocalDate;

public record AssignmentSubmission(
        int id,
        int studentId,
        int courseId,
        int assignmentId,
        String path,
        LocalDate submissionDate
) {
}
