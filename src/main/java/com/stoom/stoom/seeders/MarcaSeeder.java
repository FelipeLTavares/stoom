package com.stoom.stoom.seeders;

import com.stoom.stoom.entities.Marca;
import com.stoom.stoom.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MarcaSeeder implements CommandLineRunner {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (marcaRepository.count() == 0) {
            Marca marca1 = Marca.builder().nome("Marca A").ativo(true).build();
            Marca marca2 = Marca.builder().nome("Marca B").ativo(true).build();

            marcaRepository.save(marca1);
            marcaRepository.save(marca2);
        }

    }
}