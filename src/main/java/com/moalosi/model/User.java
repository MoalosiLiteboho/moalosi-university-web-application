package com.moalosi.model;

import java.time.LocalDate;
import java.util.Objects;

public final class User {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private LocalDate dateOfBirth;
    private int districtCode;
    private int authorityId;

    public User(int id, String name, String surname, String gender, LocalDate dateOfBirth, int districtCode, int authorityId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.districtCode = districtCode;
        this.authorityId = authorityId;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String gender() {
        return gender;
    }

    public LocalDate dateOfBirth() {
        return dateOfBirth;
    }

    public int districtCode() {
        return districtCode;
    }

    public int authorityId() {
        return authorityId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (User) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.surname, that.surname) &&
                Objects.equals(this.gender, that.gender) &&
                Objects.equals(this.dateOfBirth, that.dateOfBirth) &&
                this.districtCode == that.districtCode &&
                this.authorityId == that.authorityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, gender, dateOfBirth, districtCode, authorityId);
    }

    @Override
    public String toString() {
        return "User[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "surname=" + surname + ", " +
                "gender=" + gender + ", " +
                "dateOfBirth=" + dateOfBirth + ", " +
                "districtCode=" + districtCode + ", " +
                "authorityId=" + authorityId + ']';
    }

}
