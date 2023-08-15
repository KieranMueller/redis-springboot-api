package com.kieran.redis.controller;

import com.kieran.redis.entity.Cat;
import com.kieran.redis.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@EnableCaching
@RequestMapping("cats")
public class CatController {

    private final CatService catService;

    @GetMapping
    public List<Cat> getAll() {
        return catService.getAll();
    }

    @GetMapping("{id}")
    @Cacheable(key = "#id", value = "Cat")
    public Cat getById(@PathVariable Long id) {
        return catService.getById(id);
    }
}
