package com.aladji.todoapp.service;

import com.aladji.todoapp.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TodoService {
    private static final List<Todo> TODO_LIST = new ArrayList<>(
            List.of(
                    new Todo(1L, "Learn Spring Boot"),
                    new Todo(2L, "Learn REST"),
                    new Todo(3L, "Learn Angular")
            )
    );

    public List<Todo> allTodos() {
        return TODO_LIST;
    }

    public Todo createToto(String title) {
        String id = TODO_LIST.size() + 1 + ""; // 3 + 1 = "4" = 4

        Todo todo = new Todo(Long.parseLong(id), title);
        TODO_LIST.add(todo);

        return todo;
    }

    public Todo getTodo(Long idTodo) {
        for (Todo todo : TODO_LIST) {
            if (todo.getId().equals(idTodo)) { // todo.getId() == idTodo
                return todo;
            }
        }
        return null;
    }

}
