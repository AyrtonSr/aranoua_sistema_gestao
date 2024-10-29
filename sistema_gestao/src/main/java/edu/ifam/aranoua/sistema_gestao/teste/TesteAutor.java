package edu.ifam.aranoua.sistema_gestao.teste;

import edu.ifam.aranoua.sistema_gestao.model.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TesteAutor {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Autor autor = new Autor();
            autor.setNome("Ayrton Silva");
            autor.setInstituicao("Igreja");

            em.persist(autor);
            transaction.commit();
            System.out.println("DEU CERTO");
        } catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
