package com.recipematcher.core.Service;

import com.recipematcher.core.dto.CreateRecipeDTO;
import com.recipematcher.core.dto.UpdateRecipeDTO;
import org.springframework.stereotype.Service;
import com.recipematcher.core.Model.Recipe;
import com.recipematcher.core.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;

    public RecipeService(RecipeRepository recipeRepository, IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
    }
    
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    public List<Recipe> findRecipesByAllIngredients(List<Long> ingredientIds) {
        return recipeRepository.findRecipesByAllIngredientsPresent(ingredientIds);
    }

    public Recipe createRecipe(CreateRecipeDTO createRecipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setRecipeImage(createRecipeDTO.getRecipeImage());
        recipe.setRecipeName(createRecipeDTO.getRecipeName());
        recipe.setRecipeDesc(createRecipeDTO.getRecipeDesc());
        recipe.setRecipeIngredients(ingredientService.findAllById(createRecipeDTO.getIngredientIds()));

        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, UpdateRecipeDTO updateRecipeDTO) {
        Recipe recipe = recipeRepository.getRecipeById(id);
        recipe.setRecipeImage(updateRecipeDTO.getRecipeImage());
        recipe.setRecipeName(updateRecipeDTO.getRecipeName());
        recipe.setRecipeDesc(updateRecipeDTO.getRecipeDesc());
        recipe.setRecipeIngredients(ingredientService.findAllById(updateRecipeDTO.getIngredientIds()));

        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    
}
