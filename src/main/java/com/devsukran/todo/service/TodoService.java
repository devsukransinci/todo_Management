package com.devsukran.todo.service;

import com.devsukran.todo.dto.TodoDto;
import com.devsukran.todo.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long id);
    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto,Long id);

    void deleteTodo(Long id);

    TodoDto completedTodo(Long id);
    TodoDto inCompletedTodo(Long id);
}
