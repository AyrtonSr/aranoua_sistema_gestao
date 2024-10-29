package edu.ifam.aranoua.sistema_gestao.teste;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;
import edu.ifam.aranoua.sistema_gestao.model.Autor;
import edu.ifam.aranoua.sistema_gestao.model.RevistaCientifica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class TesteAutor_Artigo_Revista {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();

            Autor autor2 = new Autor();
            autor2.setNome("Davi");
            autor2.setInstituicao("Sla");

            Autor autor3 = new Autor();
            autor3.setNome("Glenda");
            autor3.setInstituicao("Sla3");

            em.persist(autor2);
            em.persist(autor3);

            RevistaCientifica revistaCientifica = new RevistaCientifica();
            revistaCientifica.setNome("A revista grande");
            revistaCientifica.setIssn("88888888");

            em.persist(revistaCientifica);

            Artigo artigo = new Artigo();
            artigo.setTitulo("O melhor artigo");
            artigo.setAnopublicacao(2023);
            artigo.setRevistaCientifica(revistaCientifica);

            List<Autor> autores = new ArrayList<>();
            autores.add(autor2);
            autores.add(autor3);
            artigo.setAutores(autores);

            em.persist(artigo);
            transaction.commit();
            System.out.println("DEU CERTO JAHHAAH");
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}
