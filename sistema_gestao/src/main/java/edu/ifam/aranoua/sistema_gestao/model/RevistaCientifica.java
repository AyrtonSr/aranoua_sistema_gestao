package edu.ifam.aranoua.sistema_gestao.model;

import jakarta.persistence.*;

@Entity(name = "revistaCientifica")
public class RevistaCientifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "revistacodigo")
    private Long id;
    @Column(name = "revistanome",nullable = false)
    private String nome;
    @Column(name = "revistaissn",nullable = false,unique = true,length = 8)
    private String issn;

    public RevistaCientifica() {
    }

    public RevistaCientifica(Long id, String nome, String issn) {
        this.id = id;
        this.nome = nome;
        this.issn = issn;
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
}
