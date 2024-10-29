package edu.ifam.aranoua.sistema_gestao.dto;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;
import edu.ifam.aranoua.sistema_gestao.model.Autor;
import edu.ifam.aranoua.sistema_gestao.model.RevistaCientifica;
import edu.ifam.aranoua.sistema_gestao.repository.RevistaCientificaRepository;

import java.util.List;

public class ArtigoInputDTO {
    private String titulo;
    private int anopublicacao;
    private Long revistaCientificaId;

    public ArtigoInputDTO() {
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

    public Long getRevistaCientificaId() {
        return revistaCientificaId;
    }

    public void setRevistaCientificaId(Long revistaCientificaId) {
        this.revistaCientificaId = revistaCientificaId;
    }

    public Artigo build(RevistaCientificaRepository revistaCientificaRepository, List<Autor> autores) {
        Artigo artigo = new Artigo();
        artigo.setTitulo(this.titulo);
        artigo.setAnopublicacao(this.anopublicacao);
        RevistaCientifica revistaCientifica = revistaCientificaRepository.findById(this.revistaCientificaId).orElse(null);
        artigo.setRevistaCientifica(revistaCientifica);
        artigo.setAutores(autores);

        return artigo;
    }
}
