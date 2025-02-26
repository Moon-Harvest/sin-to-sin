package com.harvest.sin_to_sin.model;

public enum Role {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
