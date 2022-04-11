package com.demo.todoapi.dto;


import java.util.Objects;

public record UserRequest(String userName, String password) {

    public UserRequest {
        Objects.requireNonNull( userName );
        Objects.requireNonNull( password );
    }


}
