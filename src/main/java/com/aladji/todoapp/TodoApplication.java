package com.aladji.todoapp;

import com.aladji.todoapp.model.Todo;
import com.aladji.todoapp.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(final TodoRepository repository){
        final var todo1 = new Todo("Learn Java 21");
        final var todo2 = new Todo("Hands on Spring Boot 3");
        final var todo3 = new Todo("Spring Data JPA");
        final var todo4 = new Todo("Enterprise App Development");

        return args -> {repository.saveAll(List.of(todo1, todo2, todo3, todo4));};
    }
}
