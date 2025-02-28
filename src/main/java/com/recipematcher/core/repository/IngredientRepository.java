package com.recipematcher.core.repository;

import com.recipematcher.core.Model.Ingredient;
import com.recipematcher.core.Model.IngredientType;

import java.util.List;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    //Basic CRUD operations are provided by JpaRepository

    List<Ingredient> findByName(String name);
    List<Ingredient> findByType(IngredientType type);

    Ingredient getIngredientById(Long id);
}