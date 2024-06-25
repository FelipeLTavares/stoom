package com.stoom.stoom.controllers;

import com.stoom.stoom.dtos.marca.MarcaDto;
import com.stoom.stoom.entities.Marca;
import com.stoom.stoom.services.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marca")
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
}
