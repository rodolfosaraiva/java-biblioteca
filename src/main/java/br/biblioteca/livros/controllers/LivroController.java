package br.biblioteca.livros.controllers;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.entidades.Livro;
import br.biblioteca.livros.services.AutoresService;
import br.biblioteca.livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping ("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutoresService autorService;

    @GetMapping("/list")
    public ModelAndView list() {
        Iterable<Livro> livros = livroService.listaLivros();

        return new ModelAndView( "/livros/list" , "listaLivros" , livros );
    }

    @GetMapping("/novo")
    public ModelAndView newBook(@ModelAttribute Livro livro) {
        ModelAndView modelAndView = new ModelAndView("livros/form");
        Iterable<Autor> autores = autorService.listaAutores();
        modelAndView.addObject("autores", autores);
        return modelAndView;
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(@Valid Livro livro, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Iterable<Autor> autores = autorService.listaAutores();
            return new ModelAndView("livros/form", "autores", autores);
        }

        livroService.gravaLivro(livro);
        return new ModelAndView("redirect:/livros/list");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView update(@PathVariable Long id, @ModelAttribute Livro livro) {
        ModelAndView modelAndView = new ModelAndView("livros/form");
        Iterable<Autor> autores = autorService.listaAutores();
        Livro livroFind = livroService.getFirstLivro(id);
        modelAndView.addObject("autores", autores);
        modelAndView.addObject("livro", livroFind);
        return modelAndView;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        livroService.apagarLivro(id);
        return new ModelAndView("redirect:/livros/list");
    }

}
