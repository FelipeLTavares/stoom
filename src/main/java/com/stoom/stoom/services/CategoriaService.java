package com.stoom.stoom.services;

import com.stoom.stoom.dtos.categoria.CategoriaDto;
import com.stoom.stoom.entities.Categoria;

public interface CategoriaService {

    String findAll ();

    Categoria createOne (CategoriaDto dto);

}
