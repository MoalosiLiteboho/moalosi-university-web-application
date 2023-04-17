package com.moalosi.dtoMapper;

import com.moalosi.model.InstructorNamesAndId;
import com.moalosi.model.User;

import java.util.function.Function;

public class InstructorNamesAndIdMapper implements Function<User, InstructorNamesAndId> {
    public InstructorNamesAndId apply(User user) {
        return new InstructorNamesAndId(
                user.id(),
                user.name(),
                user.surname());
    }
}
