package com.stoom.stoom.controllers;

import com.stoom.stoom.dtos.produto.ProdutoDto;
import com.stoom.stoom.entities.Produto;
import com.stoom.stoom.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String findAll () {
        return produtoService.findAll();
    }

    @PostMapping
    public Produto createOne (@Valid @RequestBody ProdutoDto dto) {
        return produtoService.createOne(dto);
    }

}
