package edu.ifam.aranoua.sistema_gestao.dto;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;
import edu.ifam.aranoua.sistema_gestao.model.RevistaCientifica;

import java.util.List;
import java.util.stream.Collectors;

public class RevistaCientificaOutPutDTO {
    private Long id;
    private String nome;
    private String issn;
    private List<ArtigoOutPutDTO> artigos;

    public RevistaCientificaOutPutDTO(RevistaCientifica revistaCientifica){
        this.id =  revistaCientifica.getId();
        this.nome = revistaCientifica.getNome();
        this.issn = revistaCientifica.getIssn();
        this.artigos = revistaCientifica.getArtigos().stream().map(ArtigoOutPutDTO::new).collect(Collectors.toList());
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

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public List<ArtigoOutPutDTO> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<ArtigoOutPutDTO> artigos) {
        this.artigos = artigos;
    }
}
