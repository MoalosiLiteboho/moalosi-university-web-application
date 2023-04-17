package com.moalosi.model;

import java.time.LocalDate;

public record EnrollmentCourse(int id, int studentId, int courseId, LocalDate enrollmentDate) {
}
