package com.recipematcher.core.Controller;

import com.recipematcher.core.dto.CreateRecipeDTO;
import com.recipematcher.core.dto.UpdateRecipeDTO;
import org.springframework.web.bind.annotation.*;

import com.recipematcher.core.Model.Recipe;
import com.recipematcher.core.Service.RecipeService;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeContoller {

    private final RecipeService recipeService;

    public RecipeContoller(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping("/public")
    public List<Recipe> getAllRecipe(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/public/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @PutMapping("/auth/update/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody UpdateRecipeDTO updateRecipeDTO) {
        return recipeService.updateRecipe(id,updateRecipeDTO);
    }

    @DeleteMapping("/auth/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @PostMapping("/auth/create")
    public Recipe createRecipe(@RequestBody CreateRecipeDTO createRecipe){
        return recipeService.createRecipe(createRecipe);
    }
    
}
