package com.gestion.restauration.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Menu {
    private int idMenu;
    private String menuName;
    private double unitPrice;

    public static final String ID_MENU = "id_menu";
    public static final String MENU_NAME = "menu_name";
    public static final String UNIT_PRICE = "unit_price";
}
