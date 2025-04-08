package com.aladji.todoapp.model;

import java.time.LocalDateTime;

public class Todo {
    private Long id;
    private String title;
    private LocalDateTime date;

    public Todo() {
    }

    public Todo(Long id, String title, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.date = date;
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
