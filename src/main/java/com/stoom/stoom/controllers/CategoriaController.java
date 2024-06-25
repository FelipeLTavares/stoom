package com.stoom.stoom.controllers;

import com.stoom.stoom.dtos.categoria.CategoriaDto;
import com.stoom.stoom.entities.Categoria;
import com.stoom.stoom.services.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@Tag(name = "Categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String findAll () {
        return categoriaService.findAll();
    }

    @PostMapping
    public Categoria createOne ( @Valid @RequestBody CategoriaDto dto) {
        return categoriaService.createOne(dto);
    }
}
