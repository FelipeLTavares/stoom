package com.stoom.stoom.services.implementations;

import com.stoom.stoom.dtos.categoria.CategoriaDto;
import com.stoom.stoom.entities.Categoria;
import com.stoom.stoom.entities.Marca;
import com.stoom.stoom.exceptions.customExceptions.CategoriaNotFoundException;
import com.stoom.stoom.exceptions.customExceptions.MarcaNotFoundException;
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

    @Override
    public void inativarCategoria (Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(CategoriaNotFoundException::new);
        if(categoria.getAtivo()) {
            categoria.setAtivo(false);
            categoriaRepository.save(categoria);
        }
    }

    @Override
    public void ativarCategoria (Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(CategoriaNotFoundException::new);
        if(!categoria.getAtivo()) {
            categoria.setAtivo(true);
            categoriaRepository.save(categoria);
        }
    }
}
