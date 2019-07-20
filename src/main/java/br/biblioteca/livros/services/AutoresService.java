package br.biblioteca.livros.services;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoresService {

    @Autowired
    AutorRepository repository;

    public List<Autor> listaAutores(){
        return repository.findAll();
    }

    public void gravaAutor(Autor autor){
        repository.save(autor);
    }

    public void apagarAutor(Long id){
        Autor autor = repository.findById(id).get();
        repository.delete(autor);
    }

    public Autor getFirstAutor(Long id){
        Autor autor = repository.findById(id).get();
        return autor;
    }
}
