package com.moalosi.model;

import java.time.LocalDate;

public record AssigmentSubmissions(
        int id,
        int studentId,
        int courseId,
        int assignmentId,
        String submittedFilePath,
        LocalDate submissionDate
) {
}
