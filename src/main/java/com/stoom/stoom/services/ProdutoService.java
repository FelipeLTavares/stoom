package com.stoom.stoom.services;

import com.stoom.stoom.dtos.produto.ProdutoDto;
import com.stoom.stoom.dtos.produto.ProdutoFilterDto;
import com.stoom.stoom.entities.Produto;
import com.stoom.stoom.exceptions.customExceptions.InvalidMarcaException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {

    Page<Produto> findAllAtivos(ProdutoFilterDto filter, Pageable pageable);

    Page<Produto> findAllAtivosInativos(ProdutoFilterDto filter, Pageable pageable);

    Page<Produto> findByMarca(ProdutoFilterDto filter, Pageable pageable);

    Page<Produto> findByCategoria (ProdutoFilterDto filter, Pageable pageable);

    Produto createOne(ProdutoDto dto);

    Produto updateAtivoToFalse (Long id);

    Produto updateAtivoToTrue (Long id);

}
