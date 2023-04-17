package com.moalosi.model;

import java.time.LocalDate;

public record Assignment(
        int id,
        int courseId,
        String name,
        LocalDate creationDate,
        LocalDate deadLine,
        String assigmentPath
) {
}
