package com.recipematcher.core.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.recipematcher.core.Model.Ingredient;
import com.recipematcher.core.Service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientsById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @PutMapping("/update/{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }
}
