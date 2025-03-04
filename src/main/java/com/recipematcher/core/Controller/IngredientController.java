package com.recipematcher.core.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.recipematcher.core.Model.Ingredient;
import com.recipematcher.core.Service.IngredientService;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/public")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/public/{id}")
    public Ingredient getIngredientsById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @PutMapping("/auth/update/{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("/auth/delete/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
    }

    @PostMapping("/auth/create")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }
}
