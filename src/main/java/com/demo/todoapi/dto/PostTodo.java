package com.demo.todoapi.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public record PostTodo(

        @NotBlank( message = "Title must not be null nor empty/blank value")
        String title,

        @NotBlank( message = "Description must not be null nor empty/blank value")
        String description ) {

    /*public  PostTodo {
        Objects.requireNonNull( title);
        Objects.requireNonNull( description );
    }*/

}
