package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.StockMovement;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface StockMovementService {
    List<StockMovement> getAllMovements() throws SQLException;
    int getStockMovementById(int idStockMovement) throws SQLException;
    StockMovement createStockMovement(StockMovement createMovement) throws SQLException;
    StockMovement updateStockMovement(int idStockMovement, StockMovement updateMovement) throws SQLException;
}
