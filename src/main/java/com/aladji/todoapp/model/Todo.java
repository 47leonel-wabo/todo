package com.aladji.todoapp.model;

import com.aladji.todoapp.status.TodoStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;
    private LocalDateTime date;

    public Todo() {
    }

    public Todo(Long id, String title, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Todo(String title) {
        this.title = title;
        this.date = LocalDateTime.now();
        this.status = TodoStatus.ENCOURS;
    }

    public Todo(String title, TodoStatus status) {
        this.title = title;
        this.status = status;
        this.date = LocalDateTime.now();
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public Todo(Long id, String title) {
        this.id = id;
        this.title = title;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
