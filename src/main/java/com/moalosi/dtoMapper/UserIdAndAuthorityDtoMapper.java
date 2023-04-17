package com.moalosi.dtoMapper;

import com.moalosi.model.UserIdAndAuthorityDto;
import com.moalosi.service.AuthorityService;
import com.moalosi.model.UserDetails;

import java.util.function.Function;

public class UserIdAndAuthorityDtoMapper implements Function<UserDetails, UserIdAndAuthorityDto> {

    public UserIdAndAuthorityDto apply(UserDetails user) {
        return new UserIdAndAuthorityDto(
                user.id(),
                new AuthorityService()
                        .getAuthorityByAuthorityId(user.authorityId())
        );
    }
}
