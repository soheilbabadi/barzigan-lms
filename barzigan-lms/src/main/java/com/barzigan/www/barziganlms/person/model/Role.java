package com.barzigan.www.barziganlms.person.model;

public enum Role   {
    STUDENT("student"),
    TEACHER("teacher"),
    ADMIN("admin");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
