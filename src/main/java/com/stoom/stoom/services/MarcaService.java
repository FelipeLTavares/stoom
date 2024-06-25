package com.stoom.stoom.services;

import com.stoom.stoom.dtos.marca.MarcaDto;
import com.stoom.stoom.entities.Marca;
import org.springframework.stereotype.Service;

@Service
public interface MarcaService {

    String findAll ();

    Marca createOne(MarcaDto dto);

}
