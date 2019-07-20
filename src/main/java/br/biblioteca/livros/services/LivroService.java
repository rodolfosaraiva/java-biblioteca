package br.biblioteca.livros.services;

import br.biblioteca.livros.entidades.Livro;
import br.biblioteca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository repository;

    public List<Livro> listaLivros(){
        return repository.findAll();
    }

    public void gravaLivro(Livro livro){
        repository.save(livro);
    }

    public void apagarLivro(Long id){
        Livro livro = repository.findById(id).get();
        repository.delete(livro);
    }

    public Livro getFirstLivro(Long id){
        Livro livro = repository.findById(id).get();
        return livro;
    }
}
