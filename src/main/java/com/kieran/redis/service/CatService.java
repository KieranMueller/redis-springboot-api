package com.kieran.redis.service;

import com.kieran.redis.entity.Cat;

import java.util.List;

public interface CatService {

    List<Cat> getAll();

    Cat getById(Long id);
}
