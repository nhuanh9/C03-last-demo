package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> optional = categoryService.findById(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> edit(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> optional = categoryService.findById(id);
        if (optional.isPresent()) {
            Category newCategory = optional.get();
            if (!category.getName().trim().equals("")) { //trim là hàm cắt khoảng trắng đầu đít
                newCategory.setName(category.getName());
            }
            categoryService.save(newCategory);
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {
        Optional<Category> optional = categoryService.findById(id);
        if (optional.isPresent()) {
            categoryService.delete(id);
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Category>> findAllByNameContaining(@PathParam("name") String name) {
        Iterable<Category> categories = categoryService.findAllByNameContaining(name);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/order-by-name")
    public ResponseEntity<Iterable<Category>> findAllOrderByName() {
        return new ResponseEntity<>(categoryService.findAllOrderByName(), HttpStatus.OK);
    }

    @GetMapping("/top-2")
    public ResponseEntity<Iterable<Category>> findTop2() {
        return new ResponseEntity<>(categoryService.findTop2New(), HttpStatus.OK);
    }
}


