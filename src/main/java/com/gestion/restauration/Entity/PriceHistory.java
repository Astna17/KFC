package com.gestion.restauration.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PriceHistory {
    private int idPrice;
    private int idIngredient;
    private double actualUnitPrice;
    private Timestamp startDate;
    private Timestamp endDate;

    public static final String ID_PRICE = "id_price";
    public static final String ID_INGREDIENT = "id_ingredient";
    public static final String ACTUAL_UNIT_PRICE = "actual_unit_price";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
}