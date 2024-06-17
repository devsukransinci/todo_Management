package com.devsukran.todo.service.impl;

import com.devsukran.todo.dto.TodoDto;
import com.devsukran.todo.entity.Todo;
import com.devsukran.todo.repository.TodoRepository;
import com.devsukran.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //Convert TodoDto into Todo Jpa entity

        Todo todo =modelMapper.map(todoDto , Todo.class);


        //Todo Jpa entity
        Todo savedTodo =todoRepository.save(todo);


        TodoDto savedTodoDto =modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }
}
