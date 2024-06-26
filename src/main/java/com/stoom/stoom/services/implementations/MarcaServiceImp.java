package com.stoom.stoom.services.implementations;

import com.stoom.stoom.dtos.marca.MarcaDto;
import com.stoom.stoom.entities.Marca;
import com.stoom.stoom.exceptions.customExceptions.MarcaNotFoundException;
import com.stoom.stoom.repositories.MarcaRepository;
import com.stoom.stoom.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImp implements MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public String findAll () {
        return marcaRepository.findAll().toString();
    }

    @Override
    public Marca createOne (MarcaDto dto) {
        Marca marca = new Marca(dto);

        return marcaRepository.save(marca);
    }

    @Override
    public void inativarMarca (Long id) {
        Marca marca = marcaRepository.findById(id).orElseThrow(MarcaNotFoundException::new);
        if(marca.getAtivo()) {
            marca.setAtivo(false);
            marcaRepository.save(marca);
        }
    }

    @Override
    public void ativarMarca (Long id) {
        Marca marca = marcaRepository.findById(id).orElseThrow(MarcaNotFoundException::new);
        if(!marca.getAtivo()) {
            marca.setAtivo(true);
            marcaRepository.save(marca);
        }
    }

}
