package com.harvest.sin_to_sin.model.enums;

/**
 * Represents the role of a user in the system.
 */
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
