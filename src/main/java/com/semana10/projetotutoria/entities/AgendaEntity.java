package com.semana10.projetotutoria.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Agenda")

public class AgendaEntity {

    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TutorEntity tutor;

    @ManyToOne
    private AlunoEntity aluno;

    private Date data;
    @Enumerated(EnumType.STRING)
    private Status status;

    private String tema;

    private String descricaoBreve;


}
