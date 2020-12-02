package com.kuznetsovka.managercounters.domain;

public abstract class Person {
    private int id;
    private String name;
    private String password;
    private Role role;
    private String getName() {
        return name;
    }
}
