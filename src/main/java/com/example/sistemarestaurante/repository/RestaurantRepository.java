package com.example.sistemarestaurante.repository;

import com.example.sistemarestaurante.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT DISTINCT r FROM Restaurant r " +
            "LEFT JOIN FETCH r.categories c " +
            "LEFT JOIN FETCH c.items")
    List<Restaurant> findAllOptimized();
}