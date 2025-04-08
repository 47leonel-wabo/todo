package com.aladji.todoapp.controller;

import com.aladji.todoapp.model.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoApiController {
// localhost:8080/todos
    @GetMapping(path = {"/todos"})
    public Todo todo() {
        return new Todo(1L, "Learn Spring Boot");
    }



}
