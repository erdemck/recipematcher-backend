package com.recipematcher.core.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "recipe")
@Getter @Setter @NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "recipe_desc")
    private String recipeDesc;

    @Column(name = "recipe_image")
    private String recipeImage;

    @ManyToMany
    @JoinTable(
        name = "recipe_ingredient",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> recipeIngredients;

    public Recipe(String recipeName, String recipeDesc, String recipeImage, List<Ingredient> recipeIngredients) {
        this.recipeName = recipeName;
        this.recipeDesc = recipeDesc;
        this.recipeImage = recipeImage;
        this.recipeIngredients = recipeIngredients;
    }

}
