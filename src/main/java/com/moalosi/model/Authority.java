package com.moalosi.model;

import java.util.Objects;

public final class Authority {
    private int id;
    private String authority;

    public Authority(int id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public int id() {
        return id;
    }

    public String authority() {
        return authority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Authority) obj;
        return this.id == that.id &&
                Objects.equals(this.authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authority);
    }

    @Override
    public String toString() {
        return "Authority[" +
                "id=" + id + ", " +
                "authority=" + authority + ']';
    }

}
