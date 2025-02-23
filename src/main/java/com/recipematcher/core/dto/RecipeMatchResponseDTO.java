package com.recipematcher.core.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class RecipeMatchResponseDTO {
    private List<Long> ingredientIds;

    public RecipeMatchResponseDTO(List<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }
    
}
