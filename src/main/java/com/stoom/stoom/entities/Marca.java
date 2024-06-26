package com.stoom.stoom.entities;

import com.stoom.stoom.dtos.marca.MarcaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marcas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", unique = true, nullable = false)
    private String nome;
    private Boolean ativo;

    public Marca (MarcaDto dto) {
        this.nome = dto.getNome();
    }
}