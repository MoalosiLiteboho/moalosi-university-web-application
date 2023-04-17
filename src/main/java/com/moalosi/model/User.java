package com.moalosi.model;

import java.time.LocalDate;

public record User(
        int id,
        String name,
        String surname,
        String gender,
        LocalDate dateOfBirth,
        int districtCode,
        int authorityId
) {
}
