package com.semana10.projetotutoria.repository;

import com.semana10.projetotutoria.entities.AlunoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long>{

    @Transactional
    @Modifying
    @Query("UPDATE AlunoEntity b SET b.nome = COALESCE(:nome, b.nome)  WHERE b.id = :id")
    void updateAluno(Long id, String nome);
}

