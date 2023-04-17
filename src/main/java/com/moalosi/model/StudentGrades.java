package com.moalosi.model;

public record StudentGrades(
        int id,
        int courseId,
        int assignmentId,
        int studentId,
        boolean submitted,
        int marks,
        String Grade
) {
}
