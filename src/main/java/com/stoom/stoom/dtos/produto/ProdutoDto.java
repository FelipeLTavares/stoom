package com.stoom.stoom.dtos.produto;

import com.stoom.stoom.entities.Categoria;
import com.stoom.stoom.entities.Marca;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    @NotEmpty
    private String titulo;
    @NotEmpty
    private String descricao;
    @NotNull
    private Categoria categoria;
    @NotNull
    private Marca marca;
    @NotNull
    @Positive
    private BigDecimal preco;
    private Boolean ativo;
}
