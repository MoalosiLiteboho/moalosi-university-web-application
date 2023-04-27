package com.moalosi.model;

import java.util.Objects;

public final class UserIdAndAuthorityDto {
    private int id;
    private String authority;

    public UserIdAndAuthorityDto(int id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public int id() {
        return id;
    }

    public String authority() {
        return authority;
    }

    public int getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserIdAndAuthorityDto) obj;
        return this.id == that.id &&
                Objects.equals(this.authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authority);
    }

    @Override
    public String toString() {
        return "UserIdAndAuthorityDto[" +
                "id=" + id + ", " +
                "authority=" + authority + ']';
    }
}
