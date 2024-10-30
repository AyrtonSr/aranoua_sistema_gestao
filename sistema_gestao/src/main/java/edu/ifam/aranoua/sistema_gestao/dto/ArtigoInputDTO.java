package edu.ifam.aranoua.sistema_gestao.dto;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;
import edu.ifam.aranoua.sistema_gestao.model.Autor;
import edu.ifam.aranoua.sistema_gestao.model.RevistaCientifica;
import edu.ifam.aranoua.sistema_gestao.repository.AutorRepository;
import edu.ifam.aranoua.sistema_gestao.repository.RevistaCientificaRepository;

import java.util.ArrayList;
import java.util.List;

public class ArtigoInputDTO {
    private String titulo;
    private int anopublicacao;
    private List<String> autores = new ArrayList<>();
    private String revistaCientifica;

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

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public String getRevistaCientifica() {
        return revistaCientifica;
    }

    public void setRevistaCientifica(String revistaCientifica) {
        this.revistaCientifica = revistaCientifica;
    }

    public Artigo build(RevistaCientificaRepository revistaCientificaRepository, AutorRepository autorRepository) {
        Artigo artigo = new Artigo();
        artigo.setTitulo(this.titulo);
        artigo.setAnopublicacao(this.anopublicacao);
        RevistaCientifica revistaCientifica = revistaCientificaRepository.findByNome(this.revistaCientifica);
        artigo.setRevistaCientifica(revistaCientifica);
        List<Autor> autores = new ArrayList<>();
        for (String autor : this.autores) {
            autores.add(autorRepository.findByNome(autor));
        }
        artigo.setAutores(autores);

        return artigo;
    }
}
