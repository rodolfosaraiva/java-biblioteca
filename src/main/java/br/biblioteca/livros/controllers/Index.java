package br.biblioteca.livros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @RequestMapping("/")
    public String home() {
        return "Olá Spring Boot";
    }

}
