package com.demo.todoapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Objects;


public record UserRequest (
        @NotBlank( message = "Username must not be null nor empty/blank value")
        String userName,

        @NotBlank( message = "Password must not be null nor empty/blank value")
        String password
){

}
