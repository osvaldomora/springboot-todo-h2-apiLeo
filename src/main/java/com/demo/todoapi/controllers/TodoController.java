package com.demo.todoapi.controllers;

import com.demo.todoapi.dto.PostTodo;
import com.demo.todoapi.dto.PutTodo;
import com.demo.todoapi.entities.Todo;
import com.demo.todoapi.services.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/todos")
@Slf4j
@AllArgsConstructor
public class TodoController{

    private final TodoService todoService;

    @GetMapping("")
    public ResponseEntity<List<Todo>> fetchAllTodos(){
        return ResponseEntity.ok().body( todoService.getAllTodos() );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Todo>> fetchUserTodos( @PathVariable final long userId ){
        return ResponseEntity.ok().body( todoService.getUserTodos( userId ) );
    }

    @GetMapping("/{userId}/status/{status}")
    public ResponseEntity<List<Todo>> fetchTodosByStatus(
            @PathVariable final long userId,
            @PathVariable final boolean status ){
        return  ResponseEntity.ok().body( todoService.getUserTodosByStatus(userId, status) );
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Todo> postTodo(
            @PathVariable final long userId,
            @RequestBody @Valid final PostTodo todo ){

        log.debug( "new todo in controller is {}", todo);        

        return ResponseEntity
            .status( HttpStatus.CREATED )
            .body( todoService.saveTodo(userId,todo) );
    }

    @GetMapping("/{userId}/{todoId}")
    public ResponseEntity<Todo> getTodoById(
            @PathVariable final long userId,
            @PathVariable final long todoId ) {

        return todoService.getUserTodoById( userId, todoId)
                .map( todo -> ResponseEntity.ok().body(todo) )
                .orElse(  ResponseEntity.notFound().build() );
    }


    @DeleteMapping("/{userId}/{todoId}")
    public ResponseEntity<Void> deleteTodo(
        @PathVariable final long userId,
        @PathVariable final long todoId ) {

        if( todoService.deleteTodo(userId,todoId)){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }

    @PutMapping("/{userId}/{todoId}")
    public ResponseEntity<Todo> putTodo(
            @PathVariable final long userId,
            @PathVariable final long todoId,
            @RequestBody @Valid final PutTodo putTodo ){

        return  todoService.updateTodo(userId, todoId, putTodo)
                .map( updatedTodo -> ResponseEntity.ok().body(updatedTodo) )
                .orElse( ResponseEntity.notFound().build() );
    }






}

