package edu.ifam.aranoua.sistema_gestao.dto;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;
import edu.ifam.aranoua.sistema_gestao.model.Autor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArtigoOutPutDTO {
    private Long id;
    private String titulo;
    private int anopublicacao;
    private String revistaCientificaOutPutDTO;
    private List<String> autores;

    public ArtigoOutPutDTO(Artigo artigo){
        this.id = artigo.getId();
        this.titulo = artigo.getTitulo();
        this.anopublicacao = artigo.getAnopublicacao();
        this.revistaCientificaOutPutDTO = artigo.getRevistaCientifica().getNome();
        List<String> autores = new ArrayList<>();

        for(Autor autor : artigo.getAutores()){
            autores.add(autor.getNome());
        }
        this.autores = autores;
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

    public String getRevistaCientificaOutPutDTO() {
        return revistaCientificaOutPutDTO;
    }

    public void setRevistaCientificaOutPutDTO(String revistaCientificaOutPutDTO) {
        this.revistaCientificaOutPutDTO = revistaCientificaOutPutDTO;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }
}
