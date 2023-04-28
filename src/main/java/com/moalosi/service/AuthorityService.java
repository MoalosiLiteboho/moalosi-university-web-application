package com.moalosi.service;

import com.moalosi.model.Authority;
import com.moalosi.dao.DaoImplementation;

import java.util.List;

public class AuthorityService {
    private final DaoImplementation dao;
    public AuthorityService() {
        dao = new DaoImplementation();
    }

    public List<Authority> getAuthorityList() {
        return dao.findAllAuthorities();
    }

    public String getAuthorityByAuthorityId(int authorityId) {
        return getAuthorityList()
                .stream()
                .filter(authority -> authority.id() == authorityId)
                .findFirst()
                .map(Authority::authority)
                .orElseThrow(() -> new RuntimeException("Authority with this " + authorityId + " id not found."));
    }
}
