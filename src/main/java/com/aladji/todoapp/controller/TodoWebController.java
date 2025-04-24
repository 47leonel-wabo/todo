package com.aladji.todoapp.controller;

import com.aladji.todoapp.model.Todo;
import com.aladji.todoapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoWebController {

    private final TodoService todoService;

    public TodoWebController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping // http://localhost:8989/
    public String getHomePage(final Model model) {
        List<Todo> allTodos = this.todoService.getAllTodos();
        model.addAttribute("todos", allTodos);
        model.addAttribute("appTitle", "My Todos");
        return "home";
    }

    @GetMapping(path = {"/new"})
    public String getCreationPage(final Model model) {
        model.addAttribute("todo", new Todo());
        return "create";
    }

    @PostMapping(path = {"/create"})
    public String createNew(final @ModelAttribute Todo todo) {
        this.todoService.createToto(todo.getTitle(), todo.getStatus());
        return "redirect:/";
    }

    @GetMapping(path = {"/edit/todo"})
    public String getEditPage(final @RequestParam(name = "id") Long id, final Model model) {
        Optional<Todo> optionalTodo = this.todoService.getAllTodos().stream().filter(todo -> todo.getId().equals(id)).findFirst();
        optionalTodo.ifPresent(todo -> model.addAttribute("todo", todo));
        return "edit";
    }

    @GetMapping(path = {"/delete/todo"})
    public String delete(final @RequestParam(name = "id") Long id) {
        this.todoService.deleteTodoById(id);
        return "redirect:/";
    }
}
