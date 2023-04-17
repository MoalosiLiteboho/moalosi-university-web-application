package com.moalosi.model;

import java.time.LocalDate;

public record Announcement(int id, int instructorId, int courseId, String tittle, String announcement, LocalDate createdDate) {
}
