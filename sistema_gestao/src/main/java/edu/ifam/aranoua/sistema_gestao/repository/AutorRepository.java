package edu.ifam.aranoua.sistema_gestao.repository;

import edu.ifam.aranoua.sistema_gestao.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
    @Query("select a from autor a where a.nome = :nome ")
    Autor findByNome(@Param("nome") String nome);
}
