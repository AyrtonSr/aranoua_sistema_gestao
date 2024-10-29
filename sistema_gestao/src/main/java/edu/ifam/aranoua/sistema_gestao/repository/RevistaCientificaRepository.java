package edu.ifam.aranoua.sistema_gestao.repository;

import edu.ifam.aranoua.sistema_gestao.model.RevistaCientifica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RevistaCientificaRepository extends JpaRepository<RevistaCientifica,Long> {
    @Query("select r from revistaCientifica r where r.nome = :nome ")
    RevistaCientifica findByNome(@Param("nome")String nome);
}
