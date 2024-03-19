package com.semana10.projetotutoria.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Aluno")
public class AlunoEntity {
    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

}
