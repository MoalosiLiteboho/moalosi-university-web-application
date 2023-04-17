package com.moalosi.model;

import java.time.LocalDate;

public record Course(int id, int instructorId, String name, String description, String type , LocalDate createdDate) {
}
