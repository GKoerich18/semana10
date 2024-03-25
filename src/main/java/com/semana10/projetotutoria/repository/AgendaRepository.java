package com.semana10.projetotutoria.repository;

import com.semana10.projetotutoria.entities.AgendaEntity;
import com.semana10.projetotutoria.entities.AlunoEntity;
import com.semana10.projetotutoria.entities.TutorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {


    @Transactional
    @Modifying
    @Query("UPDATE TutorEntity b SET b.nome = COALESCE(:nome, b.nome), b.tutor = COALESCE(:tutor, b.tutor), b.aluno = COALESCE(:aluno, b.aluno), b.data = COALESCE(:data, b.data), b.status = COALESCE(:status, b.status), b.tema = COALESCE(:tema, b.tema), b.descricaoBreve = COALESCE(:descricaoBreve, b.descricaoBreve) WHERE b.id = :id")
    void updateAgenda(Long id, String nome, TutorEntity tutor, AlunoEntity aluno, Date data, Enum status, String tema, String descricaoBreve);

}
