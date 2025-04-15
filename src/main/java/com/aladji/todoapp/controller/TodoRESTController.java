package com.aladji.todoapp.controller;

import com.aladji.todoapp.model.Todo;
import com.aladji.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoRESTController {

    private final TodoService todoService;

    public TodoRESTController(TodoService todoService) {
        this.todoService = todoService;
    }

    // GET http://localhost:8989/todos
    @GetMapping(path = {"/todos"})
    public List<Todo> getAllTodos() {
        return this.todoService.getAllTodos();
    }

    // GET http://localhost:8989/todos/1
    @GetMapping(path = {"/todos/{todoId}"})
    public Todo getTodoById(@PathVariable Long todoId) {
        return this.todoService.getTodo(todoId);
    }

    // DELETE http://localhost:8989/todos/1
    @DeleteMapping(path = {"/todos/{todoID}"})
    public Long deleteTodo(@PathVariable Long todoID) {
        return this.todoService.deleteTodoById(todoID);
    }

    // POST http://localhost:8989/todos  {JSON}
    @PostMapping(path = {"/todos"})
    public Todo addNewTodo(@RequestBody Todo todo) {
        return this.todoService.createToto(todo.getTitle());
    }

    // PATCH http://localhost:8989/todos/1  {JSON}
    @PatchMapping(path = {"/todos/{idTodo}"})
    public Todo updateTodo(@PathVariable(name = "idTodo") Long id, @RequestBody Todo todo) {
        return this.todoService.updateTodo(id, todo);
    }
}
