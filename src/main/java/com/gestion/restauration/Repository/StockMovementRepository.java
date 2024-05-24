package com.gestion.restauration.Repository;

import com.gestion.restauration.Entity.StockMovement;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StockMovementRepository {
    List<StockMovement> getAllMovements() throws SQLException;
    int getStockMovementById(int idStockMovement) throws SQLException;
    StockMovement createStockMovement(StockMovement createMovement) throws SQLException;
    StockMovement updateStockMovement(StockMovement updateMovement) throws SQLException;
}
