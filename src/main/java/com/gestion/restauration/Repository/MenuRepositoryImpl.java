package com.gestion.restauration.Repository;

import com.gestion.restauration.Configuration.DatabaseConnection;
import com.gestion.restauration.Entity.Menu;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository{
    private final Connection connection = DatabaseConnection.getConnection();

    private Menu mapResultSetToMenu(ResultSet resultSet) throws SQLException {
        Menu menu = new Menu();
        menu.setIdMenu(resultSet.getInt(Menu.ID_MENU));
        menu.setMenuName(resultSet.getString(Menu.MENU_NAME));
        menu.setUnitPrice(resultSet.getDouble(Menu.UNIT_PRICE));
        return menu;
    }
    @Override
    public List<Menu> getAllMenus() throws SQLException {
        List<Menu> menuList = new ArrayList<>();
        String sql = "SELECT * FROM menu";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Menu menu = mapResultSetToMenu(resultSet);
            menuList.add(menu);
        }
        return menuList;
    }

    @Override
    public int getMenuById(int idMenu) throws SQLException {
        int menuById = new Menu().getIdMenu();
        String sql = "SELECT * FROM menu WHERE id_menu = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return mapResultSetToMenu(resultSet).getIdMenu();
        }
        return menuById;
    }

    @Override
    public Menu createMenu(Menu createMenu) throws SQLException {
        String sql = "INSERT INTO menu_name = ?, unit_price = ? WHERE id_menu = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        mapResultSetToMenu(preparedStatement.getResultSet());
        return createMenu;
    }

    @Override
    public Menu updateMenu(Menu updateMenu) throws SQLException {
        String sql = "UPDATE menu SET menu_name = ?, unit_price = ? WHERE id_menu = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        mapResultSetToMenu((ResultSet) updateMenu((Menu) preparedStatement));
        return updateMenu;
    }
}
