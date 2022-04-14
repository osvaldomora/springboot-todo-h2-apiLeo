package com.demo.todoapi.dto;

import javax.validation.constraints.NotBlank;

public record UserRequest (
        @NotBlank( message = "Username must not be null nor empty/blank value")
        String userName,
        @NotBlank( message = "Password must not be null nor empty/blank value")
        String password
){

}
