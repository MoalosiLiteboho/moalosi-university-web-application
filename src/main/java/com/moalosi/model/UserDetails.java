package com.moalosi.model;

import java.time.LocalDate;

public record UserDetails(
        int id,
        String name,
        String surname,
        String gender,
        LocalDate dateOfBirth,
        int districtCode,
        int authorityId,
        String username,
        String password,
        boolean enabled
)  {
}
