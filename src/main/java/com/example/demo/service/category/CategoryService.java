package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void save(Category object) {
        categoryRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Iterable<Category> findAllByNameContaining(String name) {
        return categoryRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Category> findAllOrderByName() {
        return categoryRepository.findAllOrderByName();
    }

    @Override
    public Iterable<Category> findTop2New() {
        return categoryRepository.findTop2New();
    }
}
