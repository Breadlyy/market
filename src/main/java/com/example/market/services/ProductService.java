package com.example.market.services;

import com.example.market.entities.Product;
import com.example.market.repo.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    ProductRepository productRepository;

    public List<Product> findAll()
    {
        return productRepository.findAll();
    }
    public Product findById(Integer id)
    {
        Optional product = productRepository.findById(id);
        if(product.isPresent()) return (Product) product.get();
        else throw new RuntimeException("Didn't found product with id: " + id);
    }
    public List<Product> findAllByName(String name)
    {
       return name != null ? productRepository.findAllByName(name) : findAll();
    }
    public void save(Product product)
    {
        log.info("Saving new product: {}", product);
        productRepository.save(product);
    }

    public void deleteById(Integer id)
    {
        productRepository.deleteById(id);
    }
    public void deleteByName(String name)
    {
        productRepository.deleteByName(name);
    }

}
