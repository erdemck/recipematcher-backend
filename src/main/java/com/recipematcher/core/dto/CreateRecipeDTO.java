package com.recipematcher.core.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class CreateRecipeDTO {
    private String recipeName;
    private String recipeDesc;
    private String recipeImage;
    private List<Long> ingredientIds;
}
