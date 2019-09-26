package com.example.OOPROGL.FINALS.service;

import com.example.OOPROGL.FINALS.model.Fruit;
import com.example.OOPROGL.FINALS.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    @Autowired
    private FruitRepository repo;

    public List<Fruit> listAll() {
        return repo.findAll();
    }
    public void save(Fruit fruit) {
        repo.save(fruit);
    }

    public Fruit get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
