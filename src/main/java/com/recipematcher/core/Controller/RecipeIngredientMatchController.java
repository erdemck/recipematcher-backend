package com.recipematcher.core.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipematcher.core.Model.Recipe;
import com.recipematcher.core.Service.RecipeIngredientMatchService;
import com.recipematcher.core.Model.Ingredient;

@RestController
@RequestMapping("recipeingredientmatch")
public class RecipeIngredientMatchController {
    private final RecipeIngredientMatchService recipeIngredientMatchService;

    public RecipeIngredientMatchController(RecipeIngredientMatchService recipeIngredientMatchService){
        this.recipeIngredientMatchService = recipeIngredientMatchService;
    }

    @GetMapping
    public List<Recipe> getMatchedRecipes(@RequestBody List<Ingredient> ingredients){
        return recipeIngredientMatchService.getMatchedRecipes(ingredients);
    }
}
