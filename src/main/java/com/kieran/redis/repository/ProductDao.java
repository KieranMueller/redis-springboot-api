package com.kieran.redis.repository;

import com.kieran.redis.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDao {

    private static final String HASH_KEY = "Product";
    private final RedisTemplate template;

    public Product save(Product product) {
        if (product.getId() == null || product.getName() == null || product.getQuantity() == null ||
                product.getPrice() == null) throw new RuntimeException();
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findById(Long id) {
        System.out.println("Called findById() in ProductDao");
        var product = template.opsForHash().get(HASH_KEY, id);
        if (product == null) throw new RuntimeException();
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public Product deleteById(Long id) {
        var product = (Product) template.opsForHash().get(HASH_KEY, id);
        if (product == null)
            throw new RuntimeException();
        template.opsForHash().delete(HASH_KEY, id);
        return product;
    }
}
