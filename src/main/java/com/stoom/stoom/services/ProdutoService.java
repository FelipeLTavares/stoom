package com.stoom.stoom.services;

import com.stoom.stoom.dtos.produto.ProdutoDto;
import com.stoom.stoom.entities.Produto;
import com.stoom.stoom.exceptions.customExceptions.InvalidMarcaException;
import org.springframework.stereotype.Service;

@Service
public interface ProdutoService {

    String findAll();

    Produto createOne(ProdutoDto dto) throws InvalidMarcaException;

}
