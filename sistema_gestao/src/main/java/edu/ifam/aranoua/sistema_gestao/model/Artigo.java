package edu.ifam.aranoua.sistema_gestao.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "autor_artigo",
            joinColumns = @JoinColumn(name = "artigocodigo"),
            inverseJoinColumns = @JoinColumn(name = "autorcodigo")
    )
    private List<Autor> autores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "revistacodigo")
    private RevistaCientifica revistaCientifica;

    public Artigo() {
    }

    public Artigo(Long id, String titulo, int anopublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.anopublicacao = anopublicacao;
    }

    public Artigo(Long id, String titulo, int anopublicacao, List<Autor> autores, RevistaCientifica revistaCientifica) {
        this.id = id;
        this.titulo = titulo;
        this.anopublicacao = anopublicacao;
        this.autores = autores;
        this.revistaCientifica = revistaCientifica;
    }

    public Artigo(String titulo, int anopublicacao, List<Autor> autores, RevistaCientifica revistaCientifica) {
        this.titulo = titulo;
        this.anopublicacao = anopublicacao;
        this.autores = autores;
        this.revistaCientifica = revistaCientifica;
    }

    public Artigo(String titulo, int anopublicacao, RevistaCientifica revistaCientifica) {
        this.titulo = titulo;
        this.anopublicacao = anopublicacao;
        this.revistaCientifica = revistaCientifica;
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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public RevistaCientifica getRevistaCientifica() {
        return revistaCientifica;
    }

    public void setRevistaCientifica(RevistaCientifica revistaCientifica) {
        this.revistaCientifica = revistaCientifica;
    }

    public void addAutores(Autor autor){
        if(!this.autores.contains(autor)){
            this.autores.add(autor);
            autor.getArtigos().add(this);
        }
    }
}
