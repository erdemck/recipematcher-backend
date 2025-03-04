package com.recipematcher.core.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.recipematcher.core.Model.Recipe;
import com.recipematcher.core.Service.RecipeIngredientMatchService;
import com.recipematcher.core.dto.RecipeMatchResponseDTO;

@RestController
@RequestMapping("/api/recipeingredientmatch")
public class RecipeIngredientMatchController {
    private final RecipeIngredientMatchService recipeIngredientMatchService;

    public RecipeIngredientMatchController(RecipeIngredientMatchService recipeIngredientMatchService){
        this.recipeIngredientMatchService = recipeIngredientMatchService;
    }

    @PostMapping("/public")
    public List<Recipe> getMatchedRecipes(@RequestBody RecipeMatchResponseDTO recipeMatchResponseDTO){
        return recipeIngredientMatchService.getMatchedRecipes(recipeMatchResponseDTO);
    }
}
