package com.gestion.restauration.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Sale {
    private int idSale;
    private int idMenu;
    private int idRestaurant;
    private Timestamp saleDate;
    private double quantity;
    private double totalAmount;

    public static final String ID_SALE = "id_sale";
    public static final String ID_MENU = "id_menu";
    public static final String ID_RESTAURANT = "id_restaurant";
    public static final String SALE_DATE = "sale_date";
    public static final String QUANTITY = "quantity";
    public static final String TOTAL_AMOUNT = "total_amount";
}
