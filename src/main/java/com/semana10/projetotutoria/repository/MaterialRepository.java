package com.semana10.projetotutoria.repository;


import com.semana10.projetotutoria.entities.AlunoEntity;
import com.semana10.projetotutoria.entities.MaterialEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE MaterialEntity b SET b.descricao = COALESCE(:descricao, b.descricao)  WHERE b.id = :id")
    void updateMaterial(Long id, String descricao);
}
