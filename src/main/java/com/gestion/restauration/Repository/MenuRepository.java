package com.gestion.restauration.Repository;

import com.gestion.restauration.Entity.Menu;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface MenuRepository {
    List<Menu> getAllMenus() throws SQLException;
    int getMenuById(int idMenu) throws SQLException;
    Menu createMenu(Menu createMenu) throws  SQLException;
    Menu updateMenu(Menu updateMenu) throws SQLException;
}
