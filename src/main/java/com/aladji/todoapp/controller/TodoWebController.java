package com.aladji.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoWebController {
// localhost:8080
    @GetMapping
    public String indexPage() {
        return "index";
    }

}
