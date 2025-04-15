package com.aladji.todoapp.service;

import com.aladji.todoapp.model.Todo;
import com.aladji.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    // CRUD -> Create, Read, Update, Delete

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    // READ
    public List<Todo> getAllTodos() {
        return this.repository.findAll();
    }

    // CREATE
    public Todo createToto(String title) {
        // Verifier un autre avec meme non
        Todo newTodo = new Todo(title);
        return this.repository.save(newTodo);
    }

    // UPDATE
    public Todo updateTodo(Long id, Todo todo) {
        if (this.repository.existsById(id)) {
            Todo existingTodo = this.repository.findById(id).get();
            existingTodo.setTitle(todo.getTitle()); // Mise à jour
            return this.repository.save(existingTodo);
        }
        return null;
    }

    // READ
    public Todo getTodo(Long idTodo) {
        Optional<Todo> optionalTodo = this.repository.findById(idTodo);
        if (optionalTodo.isPresent()) {
            return optionalTodo.get();
        }
        return null;
    }

    // DELETE
    public Long deleteTodoById(Long id) {
        boolean existsById = this.repository.existsById(id);
        if (existsById) {
            this.repository.deleteById(id);
            return id;
        }
        return null;
    }
}
