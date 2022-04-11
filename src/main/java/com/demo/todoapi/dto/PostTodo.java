package com.demo.todoapi.dto;

import java.util.Objects;

public record PostTodo(String title, String description ) {

    public  PostTodo {
        Objects.requireNonNull( title);
        Objects.requireNonNull( description );
    }
}
