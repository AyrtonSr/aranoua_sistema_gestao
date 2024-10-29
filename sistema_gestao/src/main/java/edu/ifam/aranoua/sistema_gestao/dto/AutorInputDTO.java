package edu.ifam.aranoua.sistema_gestao.dto;

import edu.ifam.aranoua.sistema_gestao.model.Autor;

public class AutorInputDTO {
    private String nome;
    private String instituicao;

    public AutorInputDTO() {
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

    public Autor build(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setInstituicao(this.instituicao);
        return autor;

    }
}
