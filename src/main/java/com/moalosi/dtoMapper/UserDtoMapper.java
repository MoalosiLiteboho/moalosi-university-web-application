package com.moalosi.dtoMapper;

import com.moalosi.model.User;
import com.moalosi.model.UserDetails;

import java.util.function.Function;

public class UserDtoMapper implements Function<UserDetails, User> {
    public User apply(UserDetails user) {
        return new User(
                user.id(),
                user.name(),
                user.surname(),
                user.gender(),
                user.dateOfBirth(),
                user.districtCode(),
                user.authorityId()
        );
    }
}
