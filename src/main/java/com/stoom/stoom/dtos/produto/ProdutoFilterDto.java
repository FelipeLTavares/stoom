package com.stoom.stoom.dtos.produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoFilterDto {
    private Long id;
    private String titulo;
    private String descricao;
    private BigDecimal precoMin;
    private BigDecimal precoMax;
    private Long marcaId;
    private Long categoriaId;
    private Boolean ativo;
}
