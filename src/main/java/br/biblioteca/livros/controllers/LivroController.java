package br.biblioteca.livros.controllers;

import br.biblioteca.livros.entidades.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroController {

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("/livros/list");
    }

    @GetMapping("/novo")
    public ModelAndView newBook() {
        return new ModelAndView("/livros/livro");
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(Livro livro) {
        return new ModelAndView("redirect:/livros/list");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView update() {
        return new ModelAndView("redirect:/livros/list");
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView delete() {
        return new ModelAndView("redirect:/livros/list");
    }

}
