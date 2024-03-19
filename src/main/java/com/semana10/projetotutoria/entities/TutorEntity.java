package com.semana10.projetotutoria.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tutor")
public class TutorEntity {
    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especialidade;


}
