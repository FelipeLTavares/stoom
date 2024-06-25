package com.stoom.stoom.controllers;

import com.stoom.stoom.dtos.produto.ProdutoDto;
import com.stoom.stoom.dtos.produto.ProdutoFilterDto;
import com.stoom.stoom.entities.Produto;
import com.stoom.stoom.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Page<Produto> findAllAtivos (@ModelAttribute ProdutoFilterDto filter, Pageable pageable) {
        return produtoService.findAllAtivos(filter, pageable);
    }

    @GetMapping("/ativos-e-inativos")
    public Page<Produto> findAllAtivosInativos (@ModelAttribute ProdutoFilterDto filter, Pageable pageable) {
        return produtoService.findAllAtivosInativos(filter, pageable);
    }

    @GetMapping("/marcas/{marca}")
    public ResponseEntity<Page<Produto>> findByMarca (@PathVariable Long marcaId, @ModelAttribute ProdutoFilterDto filter, Pageable pageable) {
        filter.setMarcaId(marcaId);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findByMarca(filter, pageable));
    }

    @GetMapping("/categorias/{categoria}")
    public ResponseEntity<Page<Produto>> findByCategoria (@PathVariable Long categoriaId, @ModelAttribute ProdutoFilterDto filter, Pageable pageable) {
        filter.setCategoriaId(categoriaId);

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findByCategoria(filter, pageable));
    }

    @PostMapping
    public Produto createOne (@Valid @RequestBody ProdutoDto dto) {
        return produtoService.createOne(dto);
    }

    @PatchMapping("/produto/{id}/inativar")
    public ResponseEntity<Produto> inativarProduto(@PathVariable Long id) {
        Produto produto = produtoService.updateAtivoToFalse(id);
        return ResponseEntity.ok(produto);
    }

    @PatchMapping("/produto/{id}/ativar")
    public ResponseEntity<Produto> ativarProduto(@PathVariable Long id) {
        Produto produto = produtoService.updateAtivoToTrue(id);
        return ResponseEntity.ok(produto);
    }
}
