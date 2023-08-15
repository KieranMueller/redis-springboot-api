package com.kieran.redis.service.impl;

import com.kieran.redis.entity.Cat;
import com.kieran.redis.repository.CatRepository;
import com.kieran.redis.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat getById(Long id) {
        System.out.println("In getById()");
        return catRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
