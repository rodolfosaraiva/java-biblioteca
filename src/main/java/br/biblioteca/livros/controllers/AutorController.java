package br.biblioteca.livros.controllers;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutoresService autoresService;

    @GetMapping("/list")
    public ModelAndView list() {
        Iterable<Autor> autores = autoresService.listaAutores();

        return new ModelAndView( "autores/list" , "listaAutores" , autores );
    }

    @GetMapping("/novo")
    public ModelAndView newAuthor(@ModelAttribute Autor autor) {
        return new ModelAndView( "autores/form");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView update(@PathVariable Long id, @ModelAttribute Autor autor) {
        ModelAndView modelAndView = new ModelAndView("autores/form");
        Autor autorFind = autoresService.getFirstAutor(id);
        modelAndView.addObject("autor", autorFind);
        return modelAndView;
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(@Valid Autor autor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("autores/form");
        }

        autoresService.gravaAutor(autor);
        return new ModelAndView("redirect:/autores/list");
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        autoresService.apagarAutor(id);
        return new ModelAndView("redirect:/autores/list");
    }


}
