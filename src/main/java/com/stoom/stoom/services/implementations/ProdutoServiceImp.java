package com.stoom.stoom.services.implementations;

import com.stoom.stoom.dtos.produto.ProdutoDto;
import com.stoom.stoom.dtos.produto.ProdutoFilterDto;
import com.stoom.stoom.entities.Categoria;
import com.stoom.stoom.entities.Marca;
import com.stoom.stoom.entities.Produto;
import com.stoom.stoom.exceptions.customExceptions.CategoriaNotFoundException;
import com.stoom.stoom.exceptions.customExceptions.MarcaNotFoundException;
import com.stoom.stoom.exceptions.customExceptions.ProdutoNotFoundException;
import com.stoom.stoom.repositories.CategoriaRepository;
import com.stoom.stoom.repositories.MarcaRepository;
import com.stoom.stoom.repositories.ProdutoRepository;
import com.stoom.stoom.services.ProdutoService;
import com.stoom.stoom.specifications.ProdutoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Page<Produto> findAllAtivos (ProdutoFilterDto filter, Pageable pageable) {
        filter.setAtivo(true);
        Specification<Produto> spec = new ProdutoSpecification(filter);

        return produtoRepository.findAll(spec, pageable);
    }

    @Override
    public Page<Produto> findAllAtivosInativos (ProdutoFilterDto filter, Pageable pageable) {
        filter.setAtivo(null);
        Specification<Produto> spec = new ProdutoSpecification(filter);

        return produtoRepository.findAll(spec, pageable);
    }

    @Override
    public Page<Produto> findByMarca (ProdutoFilterDto filter, Pageable pageable) {
        Specification<Produto> spec = new ProdutoSpecification(filter);

        return produtoRepository.findAll(spec, pageable);
    }

    @Override
    public Page<Produto> findByCategoria (ProdutoFilterDto filter, Pageable pageable) {
        Specification<Produto> spec = new ProdutoSpecification(filter);

        return produtoRepository.findAll(spec, pageable);
    }

    @Override
    public Produto createOne (ProdutoDto dto) {
        Produto produto = new Produto(dto);

        Marca marca = findMarca(dto.getMarca().getId()).orElseThrow(MarcaNotFoundException::new);

        Categoria categoria = findCategoria(dto.getCategoria().getId()).orElseThrow(CategoriaNotFoundException::new);

        produto.setCategoria(categoria);
        produto.setMarca(marca);
        produto.setAtivo(true);

        return produtoRepository.save(produto);
    }

    @Override
    public Produto updateAtivoToFalse (Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);

        if(!produto.isAtivo()) { return produto;}

        produto.setAtivo(false);
        produtoRepository.save(produto);
        return produto;
    }

    @Override
    public Produto updateAtivoToTrue (Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);

        if(produto.isAtivo()) { return produto;}

        produto.setAtivo(true);
        produtoRepository.save(produto);
        return produto;
    }

    private Optional<Marca> findMarca (Long id) {
        return marcaRepository.findById(id);
    }

    private Optional<Categoria> findCategoria (Long id) {
        return categoriaRepository.findById(id);
    }



}
