package com.recipematcher.core.Controller;

import com.recipematcher.core.dto.CreateRecipeDTO;
import com.recipematcher.core.dto.UpdateRecipeDTO;
import org.springframework.web.bind.annotation.*;

import com.recipematcher.core.Model.Recipe;
import com.recipematcher.core.Service.RecipeService;
import java.util.List;

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

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @PutMapping("/update/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody UpdateRecipeDTO updateRecipeDTO) {
        return recipeService.updateRecipe(id,updateRecipeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody CreateRecipeDTO createRecipe){
        return recipeService.createRecipe(createRecipe);
    }
    
}
