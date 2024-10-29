package edu.ifam.aranoua.sistema_gestao.dto;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;

import java.util.List;
import java.util.stream.Collectors;

public class ArtigoOutPutDTO {
    private Long id;
    private String titulo;
    private int anopublicacao;
    private RevistaCientificaOutPutDTO revistaCientificaOutPutDTO;
    private List<AutorOutPutDTO> autores;

    public ArtigoOutPutDTO(Artigo artigo){
        this.id = artigo.getId();
        this.titulo = artigo.getTitulo();
        this.anopublicacao = artigo.getAnopublicacao();
        this.revistaCientificaOutPutDTO = new RevistaCientificaOutPutDTO(artigo.getRevistaCientifica());
        this.autores = artigo.getAutores().stream().map(AutorOutPutDTO::new).collect(Collectors.toList());
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

    public RevistaCientificaOutPutDTO getRevistaCientificaOutPutDTO() {
        return revistaCientificaOutPutDTO;
    }

    public void setRevistaCientificaOutPutDTO(RevistaCientificaOutPutDTO revistaCientificaOutPutDTO) {
        this.revistaCientificaOutPutDTO = revistaCientificaOutPutDTO;
    }

    public List<AutorOutPutDTO> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorOutPutDTO> autores) {
        this.autores = autores;
    }
}
