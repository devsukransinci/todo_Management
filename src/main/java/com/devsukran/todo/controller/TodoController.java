package com.devsukran.todo.controller;

import com.devsukran.todo.dto.TodoDto;
import com.devsukran.todo.entity.Todo;
import com.devsukran.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //build Get Todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto>getTodo(@PathVariable("id") Long todoId){
       TodoDto  todoDto = todoService.getTodo(todoId);
       return new ResponseEntity<>(todoDto ,HttpStatus.OK);
    }

    //Build Get All Todos REST API
    @GetMapping
    public  ResponseEntity<List <TodoDto>>getAllTodos(){
        List<TodoDto>todos =todoService.getAllTodos();
       // return new ResponseEntity<>(todos,HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    //Build update Todo REST API
   @PutMapping("{id}")
  public ResponseEntity<TodoDto>updateTodo(@RequestBody TodoDto todoDto,@PathVariable("id") Long todoId){
        TodoDto updateTodo =todoService.updateTodo(todoDto ,todoId);
        return ResponseEntity.ok(updateTodo);

   }
  //Build Delete Todo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteTodo(@PathVariable("id") Long todoId){
    todoService.deleteTodo(todoId);
    return  ResponseEntity.ok("Todo deleted successfully!.");
    }

    //Build Completed Todo REST API
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto>completedTodo(@PathVariable Long todoId){
        TodoDto updatedTodo = todoService.completedTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }
    //Build In Completed Todo REST API
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto>inCompletedTodo(@PathVariable  Long todoId){
        TodoDto updatedTodo=todoService.inCompletedTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }


}
