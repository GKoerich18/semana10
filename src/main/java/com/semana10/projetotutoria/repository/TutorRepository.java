package com.semana10.projetotutoria.repository;

import com.semana10.projetotutoria.entities.TutorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE TutorEntity b SET b.nome = COALESCE(:nome, b.nome), b.especialidade = COALESCE(:especialidade, b.especialidade)  WHERE b.id = :id")
    void updateTutor(Long id, String nome, String especialidade);

}
