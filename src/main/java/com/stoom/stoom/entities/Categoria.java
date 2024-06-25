package com.stoom.stoom.entities;

import com.stoom.stoom.dtos.categoria.CategoriaDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Categoria (CategoriaDto dto) {
        this.nome = dto.getNome();
    }
}