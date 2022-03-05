package com.example.springsecuritydemo.model;

import lombok.Getter;

@Getter
public enum Permission {

    PERSON_READ("persons:read"),
    PERSON_WRITE("persons:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

}
