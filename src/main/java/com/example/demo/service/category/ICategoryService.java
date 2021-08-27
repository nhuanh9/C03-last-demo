package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.service.GeneralService;

public interface ICategoryService extends GeneralService<Category> {
    Iterable<Category> findAllByNameContaining(String name);
    Iterable<Category> findAllOrderByName();
}
