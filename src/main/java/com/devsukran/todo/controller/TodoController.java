package com.devsukran.todo.controller;

import com.devsukran.todo.dto.TodoDto;
import com.devsukran.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;
    //Build add Todo REST API

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
      TodoDto savedTodo=  todoService.addTodo(todoDto);
      return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);

    }
}
