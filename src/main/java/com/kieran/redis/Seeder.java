package com.kieran.redis;

import com.kieran.redis.entity.Cat;
import com.kieran.redis.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final CatRepository catRepository;

    @Override
    public void run(String... args) throws Exception {
        var cat = new Cat(null, "Belfry", 12.3);
        var cat1 = new Cat(null, "Gaara", 10.2);
        var cat2 = new Cat(null, "Luna", 9.8);
        catRepository.saveAll(List.of(cat, cat1, cat2));
    }
}
