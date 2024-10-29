package edu.ifam.aranoua.sistema_gestao.teste;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;
import jakarta.persistence.*;

public class TesteArtigo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Artigo artigo = new Artigo();
            artigo.setTitulo("Artigo1");
            artigo.setAnopublicacao(1920);

            em.persist(artigo);
            transaction.commit();

            System.out.println("DEU CERTOO");
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
