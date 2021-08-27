package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Iterable<Category> findAllByNameContaining(String name);

    @Query(value = "select * from Category order by name", nativeQuery = true)
    Iterable<Category> findAllOrderByName();
}
