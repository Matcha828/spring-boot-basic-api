package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class User {
    @NotNull
    private String firstName;

    private String middleName;

    @NotNull
    private String lastName;

    public User(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
