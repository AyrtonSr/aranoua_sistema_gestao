package edu.ifam.aranoua.sistema_gestao.model;

import jakarta.persistence.*;

@Entity(name = "artigo")
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artigocodigo")
    private Long id;
    @Column(name = "artigotitulo", nullable = false)
    private String titulo;
    @Column(name = "artigoanopublicacao",nullable = false)
    private int anopublicacao;

    public Artigo() {
    }

    public Artigo(Long id, String titulo, int anopublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.anopublicacao = anopublicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnopublicacao() {
        return anopublicacao;
    }

    public void setAnopublicacao(int anopublicacao) {
        this.anopublicacao = anopublicacao;
    }
}
