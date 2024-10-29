package edu.ifam.aranoua.sistema_gestao.dto;

import edu.ifam.aranoua.sistema_gestao.model.Autor;

import java.util.List;
import java.util.stream.Collectors;

public class AutorOutPutDTO {
    private Long id;
    private String nome;
    private String instituicao;
    private List<ArtigoOutPutDTO> artigos;

    public AutorOutPutDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.instituicao = autor.getInstituicao();
        this.artigos = autor.getArtigos().stream().map(ArtigoOutPutDTO::new).collect(Collectors.toList());
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

    public List<ArtigoOutPutDTO> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<ArtigoOutPutDTO> artigos) {
        this.artigos = artigos;
    }
}
