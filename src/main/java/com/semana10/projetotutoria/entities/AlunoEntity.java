package com.semana10.projetotutoria.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty
    private String nome;

}
