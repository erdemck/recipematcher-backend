package com.recipematcher.core.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipematcher.core.Model.Recipe;
import com.recipematcher.core.Service.RecipeIngredientMatchService;
import com.recipematcher.core.dto.RecipeMatchResponseDTO;

@RestController
@RequestMapping("recipeingredientmatch")
public class RecipeIngredientMatchController {
    private final RecipeIngredientMatchService recipeIngredientMatchService;

    public RecipeIngredientMatchController(RecipeIngredientMatchService recipeIngredientMatchService){
        this.recipeIngredientMatchService = recipeIngredientMatchService;
    }

    @GetMapping
    public List<Recipe> getMatchedRecipes(@RequestBody RecipeMatchResponseDTO recipeMatchResponseDTO){
        return recipeIngredientMatchService.getMatchedRecipes(recipeMatchResponseDTO);
    }
}
