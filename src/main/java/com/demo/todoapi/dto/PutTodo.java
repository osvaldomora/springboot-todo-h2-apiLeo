package com.demo.todoapi.dto;

import java.util.Objects;

public record PutTodo(String title, String description, Boolean completed ) {

    public PutTodo {
        Objects.requireNonNull( title );
        Objects.requireNonNull( description );
        Objects.requireNonNull( completed );
    }

}
