package com.recipematcher.core.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.recipematcher.core.Model.Recipe;
import com.recipematcher.core.dto.RecipeMatchResponseDTO;
import com.recipematcher.core.Model.Ingredient;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
@Service
public class RecipeIngredientMatchService {
    private final RecipeService recipeService;

    public RecipeIngredientMatchService(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    public List<Recipe> getMatchedRecipes(RecipeMatchResponseDTO recipeMatchResponseDTO){
        return recipeService.findRecipesByAllIngredients(recipeMatchResponseDTO.getIngredientIds());
    }

}
