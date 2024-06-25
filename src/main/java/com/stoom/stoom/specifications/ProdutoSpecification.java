package com.stoom.stoom.specifications;

import com.stoom.stoom.dtos.produto.ProdutoFilterDto;
import com.stoom.stoom.entities.Produto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProdutoSpecification implements Specification<Produto> {
    private String titulo;
    private String descricao;
    private BigDecimal precoMin;
    private BigDecimal precoMax;
    private Long marcaId;
    private Long categoriaId;
    private Boolean ativo;

    public ProdutoSpecification(ProdutoFilterDto dto) {
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.precoMin = dto.getPrecoMin();
        this.precoMax = dto.getPrecoMax();
        this.marcaId = dto.getMarcaId();
        this.categoriaId = dto.getCategoriaId();
        this.ativo = dto.getAtivo();
    }

    @Override
    public Predicate toPredicate(Root<Produto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if (titulo != null && !titulo.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("titulo"), "%" + titulo + "%"));
        }

        if (descricao != null && !descricao.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("descricao"), "%" + descricao + "%"));
        }

        if (precoMin != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("preco"), precoMin));
        }

        if (precoMax != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("preco"), precoMax));
        }

        if (marcaId != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("marca").get("id"), marcaId));
        }

        if (categoriaId != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("categoria").get("id"), categoriaId));
        }

        if (ativo != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.isTrue(root.get("ativo")));
        }

        return predicate;
    }
}