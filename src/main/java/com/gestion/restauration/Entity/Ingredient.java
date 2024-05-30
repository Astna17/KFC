package com.gestion.restauration.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Ingredient {
    private int idIngredient;
    private String ingredientName;
    private Double quantity;
    private double stock;

    public static final String ID_INGREDIENT = "id_ingredient";
    public static final String INGREDIENT_NAME = "ingredient_name";
    public static final String QUANTITY = "quantity";
    public static final String STOCK = "stock";
}
