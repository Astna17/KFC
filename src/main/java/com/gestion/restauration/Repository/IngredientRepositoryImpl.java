package com.gestion.restauration.Repository;

import com.gestion.restauration.Configuration.DatabaseConnection;
import com.gestion.restauration.Entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository{
    private final Connection connection = DatabaseConnection.getConnection();
    private Ingredient mapResultSetToIngredient(ResultSet resultSet) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setIdIngredient(resultSet.getInt(Ingredient.ID_INGREDIENT));
        ingredient.setIngredientName(resultSet.getString(Ingredient.INGREDIENT_NAME));
        ingredient.setStock(resultSet.getDouble(Ingredient.STOCK));

        return ingredient;
    }
    @Override
    public List<Ingredient> getAllIngredients() throws SQLException {
        List<Ingredient> ingredientList = new ArrayList<>();
        String sql = "SELECT * FROM ingredient";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            Ingredient ingredient = mapResultSetToIngredient(resultSet);
            ingredientList.add(ingredient);
        }
        return ingredientList;
    }

    @Override
    public Ingredient getIngredientById(int idIngredient) throws SQLException {
        String sql = "SELECT * FROM ingredient WHERE id_ingredient = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idIngredient);
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
             mapResultSetToIngredient(resultSet);
        }
        return new Ingredient();
    }

    @Override
    public Ingredient createIngredient(Ingredient createIngredient) throws SQLException {
        String sql = "INSERT INTO ingredient (id_ingredient = ?, ingredient_name = ?, stock = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, createIngredient.getIdIngredient());
        preparedStatement.setString(2, createIngredient.getIngredientName());
        preparedStatement.setDouble(3, createIngredient.getStock());
        return createIngredient;
    }

    @Override
    public Ingredient updateIngredient(Ingredient updateIngredient) throws SQLException {
        String sql = "UPDATE ingredient SET ingredient_name = ?, stock = ?, WHERE id_ingredient = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, updateIngredient.getIngredientName());
        preparedStatement.setDouble(2, updateIngredient.getStock());
        preparedStatement.setInt(3, updateIngredient.getIdIngredient());
        int ingredientUpdated = preparedStatement.executeUpdate();
        if (ingredientUpdated > 0) {
            return updateIngredient;
        }
        return mapResultSetToIngredient(preparedStatement.getResultSet());
    }

}
