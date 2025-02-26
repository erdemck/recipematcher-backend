package com.recipematcher.core.repository;

import com.recipematcher.core.Model.Ingredient;
import com.recipematcher.core.Model.Recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    //Basic CRUD operations are provided by JpaRepository

    // Custom Queryies:
    public List<Recipe> findByRecipeName(String recipeName);
    public List<Recipe> findByRecipeIngredientsContaining(Ingredient ingredient);

    @Query("""
    SELECT r FROM Recipe r 
    WHERE NOT EXISTS (
        SELECT i FROM r.recipeIngredients i 
        WHERE i.id NOT IN :ingredientIds 
    )""")
    List<Recipe> findRecipesByAllIngredientsPresent(List<Long> ingredientIds);

} 