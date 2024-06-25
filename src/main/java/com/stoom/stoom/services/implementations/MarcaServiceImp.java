package com.stoom.stoom.services.implementations;

import com.stoom.stoom.dtos.marca.MarcaDto;
import com.stoom.stoom.entities.Marca;
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

}
