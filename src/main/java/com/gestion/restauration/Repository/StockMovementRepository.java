package com.gestion.restauration.Repository;

import com.gestion.restauration.Entity.StockMovement;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StockMovementRepository {
    List<StockMovement> getAllMovements() throws SQLException;
    int getStockMovementById(int idStockMovement) throws SQLException;
    StockMovement createStockMovement(StockMovement createMovement) throws SQLException;
    StockMovement updateStockMovement(StockMovement updateMovement) throws SQLException;
    StockMovement updateIngredientStock(int idIngredient, double restQuantity, Timestamp movementDate) throws SQLException;
}
