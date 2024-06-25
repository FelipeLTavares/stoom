package com.stoom.stoom.entities;

import com.stoom.stoom.dtos.produto.ProdutoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Lob
    private String descricao;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto (ProdutoDto dto) {
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.preco = dto.getPreco();
    }

}
