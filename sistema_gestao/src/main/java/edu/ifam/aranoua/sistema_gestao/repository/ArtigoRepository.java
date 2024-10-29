package edu.ifam.aranoua.sistema_gestao.repository;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo,Long> {
    @Query("select a from artigo a where a.titulo = :titulo ")
    Artigo findByTitulo(@Param("titulo") String titulo);
}
