package com.recipematcher.core.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredient")
@Getter @Setter @NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ingredient_name")
    private String name;

    @Column(name = "ingredient_type")
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    public Ingredient(String name, IngredientType type) {
        this.name = name;
        this.type = type;
    }
}
