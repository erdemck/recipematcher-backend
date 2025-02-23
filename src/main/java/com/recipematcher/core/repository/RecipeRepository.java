package com.recipematcher.core.repository;

import com.recipematcher.core.Model.Ingredient;
import com.recipematcher.core.Model.Recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // Temel CRUD operasyonları JpaRepository tarafından sağlanır
    
    // Özel sorgular eklenebilir:
    public List<Recipe> findByRecipeName(String recipeName);
    public List<Recipe> findByRecipeIngredientsContaining(Ingredient ingredient);

} 