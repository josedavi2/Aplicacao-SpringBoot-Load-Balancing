package com.example.sistemarestaurante.config;

import com.example.sistemarestaurante.model.*;
import com.example.sistemarestaurante.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner start(RestaurantRepository restRepo, CategoryRepository catRepo, MenuItemRepository itemRepo) {
        return args -> {

            Restaurant rest = new Restaurant(null, "Restaurante Universitário", "Gastro Unipê", "Rua do Campus", "3333-4444", null);
            restRepo.save(rest);


            Category cat1 = new Category(null, "Pratos Principais", rest, null);
            Category cat2 = new Category(null, "Bebidas", rest, null);
            catRepo.save(cat1);
            catRepo.save(cat2);


            List<MenuItem> items = new ArrayList<>();
            for (int i = 1; i <= 500; i++) {
                items.add(new MenuItem(null, "Item " + i, "Descrição do prato " + i, 10.0 + i, true, (i % 2 == 0) ? cat1 : cat2));
            }
            itemRepo.saveAll(items);

            System.out.println(">>> Banco de dados populado com 500 itens para os testes de sobrecarga!");
        };
    }
}