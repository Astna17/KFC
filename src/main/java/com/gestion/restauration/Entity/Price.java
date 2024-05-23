package com.gestion.restauration.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Price {
    private int idPrice;
    private int idIngredient;
    private double actualUnitPrice;
    private LocalDate modificationDate;

    public static final String ID_PRICE = "id_price";
    public static final String ID_INGREDIENT = "id_ingredient";
    public static final String ACTUAL_UNIT_PRICE = "actual_unit_price";
    public static final String MODIFICATION_DATE = "modification_date";
}