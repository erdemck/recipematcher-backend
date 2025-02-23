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
        List<Recipe> allRecipes = recipeService.getAllRecipes();
        List<Recipe> matchedRecipes = new ArrayList<>();

        for(Recipe recipe : allRecipes){
            if(isRecipeMatch(recipe, recipeMatchResponseDTO.getIngredientIds())){
                matchedRecipes.add(recipe);
            }
        }
        return matchedRecipes;
    }
    private boolean isRecipeMatch(Recipe recipe, List<Long> ingredientIds){
        Set<Long> userIngredientsSet = new HashSet<>(ingredientIds);
        return userIngredientsSet.containsAll(recipe.getRecipeIngredients().stream().map(Ingredient::getId).collect(Collectors.toList()));
    }

}
