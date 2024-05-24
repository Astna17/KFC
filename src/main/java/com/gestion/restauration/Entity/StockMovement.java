package com.gestion.restauration.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class StockMovement {
    private int idStockMovement;
    private int idIngredient;
    private Timestamp movementDate;
    private String movementType;
    private double restQuantity;
    private int idUnity;

    public static final String ID_STOCK_MOVEMENT = "id_stock_movement";
    public static final String ID_INGREDIENT = "id_ingredient";
    public static final String ID_UNITY = "id_unity";
    public static final String MOVEMENT_DATE = "movement_date";
    public static final String MOVEMENT_TYPE = "movement_type";
    public static final String REST_QUANTITY = "rest_quantity";
}
