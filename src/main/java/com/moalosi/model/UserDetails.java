package com.moalosi.model;

import java.time.LocalDate;
import java.util.Objects;

public final class UserDetails {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private LocalDate dateOfBirth;
    private int districtCode;
    private int authorityId;
    private String username;
    private String password;
    private boolean enabled;

    public UserDetails(int id, String name, String surname, String gender, LocalDate dateOfBirth, int districtCode, int authorityId, String username, String password, boolean enabled) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.districtCode = districtCode;
        this.authorityId = authorityId;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public boolean enabled() {
        return enabled;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserDetails) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.surname, that.surname) &&
                Objects.equals(this.gender, that.gender) &&
                Objects.equals(this.dateOfBirth, that.dateOfBirth) &&
                this.districtCode == that.districtCode &&
                this.authorityId == that.authorityId &&
                Objects.equals(this.username, that.username) &&
                Objects.equals(this.password, that.password) &&
                this.enabled == that.enabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, gender, dateOfBirth, districtCode, authorityId, username, password, enabled);
    }

    @Override
    public String toString() {
        return "UserDetails[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "surname=" + surname + ", " +
                "gender=" + gender + ", " +
                "dateOfBirth=" + dateOfBirth + ", " +
                "districtCode=" + districtCode + ", " +
                "authorityId=" + authorityId + ", " +
                "username=" + username + ", " +
                "password=" + password + ", " +
                "enabled=" + enabled + ']';
    }
}
