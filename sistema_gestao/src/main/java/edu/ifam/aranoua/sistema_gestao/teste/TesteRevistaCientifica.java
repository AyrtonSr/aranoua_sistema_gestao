package edu.ifam.aranoua.sistema_gestao.teste;

import edu.ifam.aranoua.sistema_gestao.model.RevistaCientifica;
import jakarta.persistence.*;

public class TesteRevistaCientifica {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            RevistaCientifica revistaCientifica = new RevistaCientifica();
            revistaCientifica.setNome("Revista1");
            revistaCientifica.setIssn("12345678");

            em.persist(revistaCientifica);
            transaction.commit();
            System.out.println("DEU CERTO PAIZAO");
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
