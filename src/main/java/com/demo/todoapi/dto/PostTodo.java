package com.demo.todoapi.dto;

import javax.validation.constraints.NotBlank;

public record PostTodo(
        @NotBlank( message = "Title must not be null nor empty/blank value")
        String title,
        @NotBlank( message = "Description must not be null nor empty/blank value")
        String description ) {
}
