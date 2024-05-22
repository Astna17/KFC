package com.gestion.restauration.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ingredient {
    private int idIngredient;
    private String ingredientName;
    private double stock;
}
