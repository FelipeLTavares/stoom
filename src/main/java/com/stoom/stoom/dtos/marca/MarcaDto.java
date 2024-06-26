package com.stoom.stoom.dtos.marca;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDto {
    @NotEmpty
    private String nome;
    private Boolean ativo;
}
