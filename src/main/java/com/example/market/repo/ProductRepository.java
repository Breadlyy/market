package com.example.market.repo;

import com.example.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
    List<Product> findAllByName(String name);
    void deleteByName(String name);
}
