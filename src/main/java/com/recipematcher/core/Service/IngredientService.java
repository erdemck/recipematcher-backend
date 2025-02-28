package com.recipematcher.core.Service;

import org.springframework.stereotype.Service;
import com.recipematcher.core.Model.Ingredient;
import com.recipematcher.core.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
    
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        Ingredient existIngredient = ingredientRepository.getIngredientById(id);
        existIngredient.setName(ingredient.getName());
        existIngredient.setType(ingredient.getType());

        return ingredientRepository.save(existIngredient);
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    public List<Ingredient> findAllById(List<Long> ids) {
        return ingredientRepository.findAllById(ids);
    }


}
