package com.gestion.restauration.Repository;

import com.gestion.restauration.Configuration.DatabaseConnection;
import com.gestion.restauration.Entity.CompositionMenu;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompositionMenuRepositoryImpl implements CompositionMenuRepository{
    private final Connection connection = DatabaseConnection.getConnection();
    private CompositionMenu mapResultSetToCompositionMenu(ResultSet resultSet) throws SQLException {
        CompositionMenu compositionMenu = new CompositionMenu();
        compositionMenu.setIdComposition(resultSet.getInt(CompositionMenu.ID_COMPOSITION));
        compositionMenu.setIdMenu(resultSet.getInt(CompositionMenu.ID_MENU));
        compositionMenu.setIdIngredient(resultSet.getInt(CompositionMenu.ID_INGREDIENT));
        compositionMenu.setIdUnity(resultSet.getInt(CompositionMenu.ID_UNITY));
        compositionMenu.setQuantityRequired(resultSet.getDouble(CompositionMenu.QUANTITY_REQUIRED));
        return compositionMenu;
    }
    @Override
    public List<CompositionMenu> getAllCompositions() throws SQLException {
        List<CompositionMenu> compositionMenuList = new ArrayList<>();
        String sql = "SELECT * FROM composition_menu";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            CompositionMenu compositionMenu = mapResultSetToCompositionMenu(resultSet);
            compositionMenuList.add(compositionMenu);
        }
        return compositionMenuList;
    }

    @Override
    public List<CompositionMenu> getCompositionMenuById(int idComposition) throws SQLException {
        List<CompositionMenu> compositionsMenuId = new ArrayList<>();
        String sql = "SELECT * FROM composition_menu WHERE id_composition = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idComposition);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            compositionsMenuId.add(mapResultSetToCompositionMenu(resultSet));
        }
        return compositionsMenuId;
    }

    @Override
    public CompositionMenu createCompositionMenu(CompositionMenu createComposition) throws SQLException {
        String sql = "INSERT INTO composition_menu id_composition = ?, id_menu = ?, id_ingredient = ?," +
                " id_unity = ?, quantity_required = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, createComposition.getIdComposition());
        preparedStatement.setInt(2, createComposition.getIdMenu());
        preparedStatement.setInt(3, createComposition.getIdIngredient());
        preparedStatement.setInt(4, createComposition.getIdUnity());
        preparedStatement.setDouble(5, createComposition.getQuantityRequired());
        return createComposition;
    }

    @Override
    public CompositionMenu updateCompositionMenu(CompositionMenu updateComposition) throws SQLException {
        String sql = "UPDATE composition_menu SET id_Menu = ?, id_ingredient = ?, " +
                "id_unity = ?, quantity_required = ?" + " WHERE id_composition = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, updateComposition.getIdMenu());
        preparedStatement.setInt(2, updateComposition.getIdIngredient());
        preparedStatement.setInt(3, updateComposition.getIdUnity());
        preparedStatement.setDouble(4, updateComposition.getQuantityRequired());
        preparedStatement.setInt(5, updateComposition.getIdComposition());
        int priceUpdated = preparedStatement.executeUpdate();
        if (priceUpdated > 0) {
            return updateComposition;
        }
        return null;
    }
}
