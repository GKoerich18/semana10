package com.semana10.projetotutoria.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Material")
public class MaterialEntity {
    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

}
