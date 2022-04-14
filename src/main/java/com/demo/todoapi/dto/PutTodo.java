package com.demo.todoapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record PutTodo(
        @NotBlank( message = "Title must not be null nor empty/blank value")
        String title,
        @NotBlank( message = "Description must not be null nor empty/blank value")
        String description,
        @NotNull( message = "Status must not be null")
        Boolean completed ) {

}
