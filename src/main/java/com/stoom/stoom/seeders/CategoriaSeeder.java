package com.stoom.stoom.seeders;

import com.stoom.stoom.entities.Categoria;
import com.stoom.stoom.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoriaSeeder implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoriaRepository.count() == 0) {
            Categoria categoria1 = Categoria.builder().nome("Categoria X").build();
            Categoria categoria2 = Categoria.builder().nome("Categoria Y").build();

            categoriaRepository.save(categoria1);
            categoriaRepository.save(categoria2);

            System.out.println("Dados de Categoria foram carregados no banco de dados.");
        }
    }
}
