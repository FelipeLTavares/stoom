package com.stoom.stoom.services.implementations;

import com.stoom.stoom.dtos.categoria.CategoriaDto;
import com.stoom.stoom.entities.Categoria;
import com.stoom.stoom.repositories.CategoriaRepository;
import com.stoom.stoom.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImp implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public String findAll () {
        return categoriaRepository.findAll().toString();
    }

    @Override
    public Categoria createOne (CategoriaDto dto) {
        Categoria categoria = new Categoria(dto);
        return categoriaRepository.save(categoria);
    }
}
