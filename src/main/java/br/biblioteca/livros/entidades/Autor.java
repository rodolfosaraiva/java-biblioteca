package br.biblioteca.livros.entidades;

import br.biblioteca.livros.entidades.Livro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String nome;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros () {
        return livros;
    }

    public void setLivros (final List<Livro> livros) {
        this.livros = livros;
    }
}