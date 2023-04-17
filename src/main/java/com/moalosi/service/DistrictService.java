package com.moalosi.service;

import com.moalosi.dao.DaoImplementation;
import com.moalosi.model.District;

import java.util.List;

public class DistrictService {
    private final DaoImplementation dao;

    public DistrictService() {
        dao = new DaoImplementation();
    }


    public List<District> getDistrictsList() {
        return dao.findAllDistrict();
    }

    public String getDistrictByCode(int districtCode) {
        return getDistrictsList()
                .stream()
                .filter(district -> district.code() == districtCode)
                .map(District::name)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("District with code -> " + districtCode + " not found."));
    }
}
