package com.gestion.restauration.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    private int idRestaurant;
    private String location;
    private List<Menu> menuList;

    public static final String ID_RESTAURANT = "id_restaurant";
    public static final String LOCATION = "location";
    public static final String MENU_LIST = "menu_list";
}
