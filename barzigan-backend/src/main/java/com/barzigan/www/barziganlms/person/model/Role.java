package com.barzigan.www.barziganlms.person.model;

import lombok.Getter;

@Getter
public enum Role {
    STUDENT("student"),
    TEACHER("teacher"),
    ADMIN("admin");

    private final String role;

    Role(String role) {
        this.role = role;
    }

}
