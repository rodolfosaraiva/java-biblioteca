package br.biblioteca.livros.repository;

import br.biblioteca.livros.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository  extends JpaRepository<Livro, Long> {


}