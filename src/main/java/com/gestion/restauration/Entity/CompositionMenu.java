package com.gestion.restauration.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompositionMenu {
    private int IdComposition;
    private int idMenu;
    private int idIngredient;
    private int idUnity;
    private double quantityRequired;
    private List<Ingredient> ingredientList;

    public static final String ID_COMPOSITION = "id_composition";
    public static final String ID_MENU = "id_menu";
    public static final String ID_INGREDIENT = "id_ingredient";
    public static final String ID_UNITY = "id_unity";
    public static final String QUANTITY_REQUIRED = "quantity_required";
}
