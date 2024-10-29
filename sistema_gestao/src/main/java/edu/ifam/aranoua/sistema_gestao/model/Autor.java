package edu.ifam.aranoua.sistema_gestao.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "autor")
public class Autor {
    @Id
    @Column(name = "autorcodigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "autornome", nullable = false, length = 100)
    private String nome;
    @Column(name = "autorinstituicao", nullable = false)
    private String instituicao;

    @ManyToMany(mappedBy = "autores")
    private List<Artigo> artigos = new ArrayList<>();

    public Autor() {}

    public Autor(Long id, String nome, String instituicao) {
        this.id = id;
        this.nome = nome;
        this.instituicao = instituicao;
    }

    public Autor(String nome, String instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;
    }

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

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public void addArtigo(Artigo artigo){
        if (!this.artigos.contains(artigo)){
            this.artigos.add(artigo);
            artigo.getAutores().add(this);
        }
    }
}
