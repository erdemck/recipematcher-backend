package com.recipematcher.core.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipematcher.core.Model.Recipe;
import com.recipematcher.core.Service.RecipeService;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 

@RestController
@RequestMapping("/recipes")
public class RecipeContoller {

    private final RecipeService recipeService;

    public RecipeContoller(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipe(){
        return recipeService.getAllRecipes();
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe){
        return recipeService.createRecipe(recipe);
    }
    
}
