package edu.ifam.aranoua.sistema_gestao.dto;

import edu.ifam.aranoua.sistema_gestao.model.RevistaCientifica;

public class RevistaCientificaInputDTO {
    private String nome;
    private String issn;

    public RevistaCientificaInputDTO() {
    }

    public RevistaCientificaInputDTO(String nome, String issn) {
        this.nome = nome;
        this.issn = issn;
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

    public RevistaCientifica build(){
        RevistaCientifica revistaCientifica = new RevistaCientifica();
        revistaCientifica.setNome(this.nome);
        revistaCientifica.setIssn(this.issn);
        return revistaCientifica;
    }

}
