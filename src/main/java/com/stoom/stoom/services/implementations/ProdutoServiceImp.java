package com.stoom.stoom.services.implementations;

import com.stoom.stoom.dtos.produto.ProdutoDto;
import com.stoom.stoom.entities.Categoria;
import com.stoom.stoom.entities.Marca;
import com.stoom.stoom.entities.Produto;
import com.stoom.stoom.exceptions.customExceptions.InvalidCategoriaException;
import com.stoom.stoom.exceptions.customExceptions.InvalidMarcaException;
import com.stoom.stoom.repositories.CategoriaRepository;
import com.stoom.stoom.repositories.MarcaRepository;
import com.stoom.stoom.repositories.ProdutoRepository;
import com.stoom.stoom.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImp implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public String findAll () {
        return "";
    }

    @Override
    public Produto createOne (ProdutoDto dto) {
        Produto produto = new Produto(dto);

        Marca marca = findMarca(dto.getMarca().getId()).orElseThrow(InvalidMarcaException::new);

        Categoria categoria = findCategoria(dto.getCategoria().getId()).orElseThrow(InvalidCategoriaException::new);

        produto.setCategoria(categoria);
        produto.setMarca(marca);

        return produtoRepository.save(produto);
    }

    private Optional<Marca> findMarca (Long id) {
        return marcaRepository.findById(id);
    }

    private Optional<Categoria> findCategoria (Long id) {
        return categoriaRepository.findById(id);
    }

}
