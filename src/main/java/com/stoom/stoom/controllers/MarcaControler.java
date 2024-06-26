package com.stoom.stoom.controllers;

import com.stoom.stoom.dtos.marca.MarcaDto;
import com.stoom.stoom.entities.Marca;
import com.stoom.stoom.services.MarcaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marcas")
@Tag(name = "Marcas")
public class MarcaControler {
    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public String findAll () {
        return marcaService.findAll();
    }

    @PostMapping
    public Marca createOne (@RequestBody @Valid MarcaDto dto) {
        return marcaService.createOne(dto);
    }

    @PatchMapping("/inativar/{id}")
    public ResponseEntity<?> inativarMarca (@PathVariable Long id) {
        marcaService.inativarMarca(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/ativar/{id}")
    public ResponseEntity<?> ativarMarca (@PathVariable Long id) {
        marcaService.ativarMarca(id);
        return ResponseEntity.noContent().build();
    }
}
