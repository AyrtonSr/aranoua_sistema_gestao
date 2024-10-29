package edu.ifam.aranoua.sistema_gestao.model;

import jakarta.persistence.*;

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

    public Autor() {}

    public Autor(Long id, String nome, String instituicao) {
        this.id = id;
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
}
