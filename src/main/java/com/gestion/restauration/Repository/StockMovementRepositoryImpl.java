package com.gestion.restauration.Repository;

import com.gestion.restauration.Configuration.DatabaseConnection;
import com.gestion.restauration.Entity.Ingredient;
import com.gestion.restauration.Entity.StockMovement;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StockMovementRepositoryImpl implements StockMovementRepository{
    private final Connection connection = DatabaseConnection.getConnection();
    private final IngredientRepository ingredientRepository;

    public StockMovementRepositoryImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    private StockMovement mapResultSetToMovement(ResultSet resultSet) throws SQLException {
        StockMovement stockMovement = new StockMovement();
        stockMovement.setIdStockMovement(resultSet.getInt(StockMovement.ID_STOCK_MOVEMENT));
        stockMovement.setIdIngredient(resultSet.getInt(StockMovement.ID_INGREDIENT));
        stockMovement.setIdUnity(resultSet.getInt(StockMovement.ID_UNITY));
        stockMovement.setMovementDate(resultSet.getTimestamp(StockMovement.MOVEMENT_DATE));
        stockMovement.setMovementType(resultSet.getString(StockMovement.MOVEMENT_TYPE));
        stockMovement.setRestQuantity(resultSet.getDouble(StockMovement.REST_QUANTITY));
        return stockMovement;
    }
    @Override
    public List<StockMovement> getAllMovements() throws SQLException {
        List<StockMovement> movementList = new ArrayList<>();
        String sql = "SELECT * FROM stock_movement";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            StockMovement stockMovement = mapResultSetToMovement(resultSet);
            movementList.add(stockMovement);
        }
        return movementList;
    }

    @Override
    public int getStockMovementById(int idStockMovement) throws SQLException {
        int stockMovementId = new StockMovement().getIdStockMovement();
        String sql = "SELECT * FROM stock_movement WHERE id_stock_movement = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return mapResultSetToMovement(resultSet).getIdStockMovement();
        }
        return stockMovementId;
    }

    @Override
    public StockMovement createStockMovement(StockMovement createMovement) throws SQLException {
        String sql = "INSERT INTO stock_movement id_stock_movement = ?, id_ingredient = ?, id_unity = ?, " +
                "movement_date = ?, movement_type = ?, rest_quantity = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, createMovement.getIdStockMovement());
        preparedStatement.setInt(2, createMovement.getIdIngredient());
        preparedStatement.setInt(3, createMovement.getIdUnity());
        preparedStatement.setTimestamp(4, createMovement.getMovementDate());
        preparedStatement.setString(5, createMovement.getMovementType());
        preparedStatement.setDouble(6, createMovement.getRestQuantity());
        return createMovement;
    }

    @Override
    public StockMovement updateStockMovement(StockMovement updateMovement) throws SQLException {
        String sql = "UPDATE stock_movement SET id_ingredient = ?, id_unity = ?, movement_date = ?" +
                "movement_type = ?, rest_quantity = ?" + " WHERE id_stock_movement = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, updateMovement.getIdIngredient());
        preparedStatement.setInt(2, updateMovement.getIdUnity());
        preparedStatement.setTimestamp(3, updateMovement.getMovementDate());
        preparedStatement.setString(4, updateMovement.getMovementType());
        preparedStatement.setDouble(5, updateMovement.getRestQuantity());
        preparedStatement.setInt(6, updateMovement.getIdStockMovement());
        int stockUpdated = preparedStatement.executeUpdate();
        if (stockUpdated > 0) {
            return new StockMovement();
        }
        return updateMovement;
    }
    public StockMovement updateIngredientStock(int idIngredient, double restQuantity, Timestamp movementDate) throws SQLException {
        Ingredient ingredientUpdated = ingredientRepository.getIngredientById(idIngredient);
        if (ingredientUpdated != null) {
            ingredientUpdated.setStock(ingredientUpdated.getStock() + restQuantity);
            ingredientRepository.updateIngredient(ingredientUpdated);
        }
        StockMovement stockMovement = new StockMovement();

        stockMovement.setIdIngredient(idIngredient);
        stockMovement.setRestQuantity(restQuantity);
        stockMovement.setMovementDate(movementDate);
        stockMovement.setMovementType("enter");

        updateStockMovement(stockMovement);
        return stockMovement;
    }

    @Override
    public List<StockMovement> getMovementsByDateRange(Timestamp movementDate) throws SQLException {
        String sql = "SELECT * FROM stock_movement WHERE movement_date BETWEEN ? AND ?";
        List<StockMovement> movements = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setTimestamp(1, movementDate);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            StockMovement movement = new StockMovement();
            getMovementsByDateRange(movementDate);

           movements.add(movement);
                }
           return movements;
        }
}
