package com.aladji.todoapp.controller;

import com.aladji.todoapp.model.Todo;
import com.aladji.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/todos"})
public class TodoApiController {

    private final TodoService todoService;

    public TodoApiController(TodoService todoService) {
        this.todoService = todoService;
    }

    // localhost:8080/todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return this.todoService.allTodos();
    }

    @GetMapping(path = {"/{todoId}"}) // "/todos/{todoId}" <--> http://localhost:8989/todos/1
    public Todo getTodoById(@PathVariable Long todoId) {
        return this.todoService.getTodo(todoId);
    }

    // /todos/{}
}
