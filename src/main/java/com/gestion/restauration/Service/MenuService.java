package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.Menu;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface MenuService {
    List<Menu> getAllMenus() throws SQLException;
    int getMenuById(int idMenu) throws SQLException;
    Menu createMenu(Menu createMenu) throws SQLException;
    Menu updateMenu(int idMenu, Menu updateMenu) throws SQLException;
    Menu deleteMenu(int idMenu, Menu menu) throws SQLException;
}
