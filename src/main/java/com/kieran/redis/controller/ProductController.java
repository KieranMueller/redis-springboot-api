package com.kieran.redis.controller;

import com.kieran.redis.entity.Product;
import com.kieran.redis.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductDao productDao;

    @GetMapping
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @GetMapping("{id}")
    public Product findById(@PathVariable Long id) {
        return productDao.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productDao.save(product);
    }

    @DeleteMapping("{id}")
    public Product deleteById(@PathVariable Long id) {
        return productDao.deleteById(id);
    }
}
