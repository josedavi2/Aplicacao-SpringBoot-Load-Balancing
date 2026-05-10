package com.example.sistemarestaurante.controller;

import com.example.sistemarestaurante.model.Restaurant;
import com.example.sistemarestaurante.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @GetMapping("/slow")
    public List<Restaurant> getSlow() {
        System.out.println(">>> [LOG] Cenário Lento: Buscando no MySQL (N+1)...");
        return repository.findAll();
    }

    @GetMapping("/fast")
    @Cacheable(value = "restaurants")
    public List<Restaurant> getFast() {
        System.out.println(">>> [LOG] Cenário Rápido: Usando Join Fetch e Redis...");

        return repository.findAllOptimized();
    }
}