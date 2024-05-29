package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.StockMovement;
import com.gestion.restauration.Repository.StockMovementRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class StockMovementServiceImpl implements StockMovementService{
    private final StockMovementRepository stockMovementRepository;

    public StockMovementServiceImpl(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    @Override
    public List<StockMovement> getAllMovements() throws SQLException {
        return stockMovementRepository.getAllMovements();
    }

    @Override
    public int getStockMovementById(int idStockMovement) throws SQLException {
        return stockMovementRepository.getStockMovementById(idStockMovement);
    }

    @Override
    public StockMovement createStockMovement(StockMovement createMovement) throws SQLException {
        return stockMovementRepository.createStockMovement(createMovement);
    }

    @Override
    public StockMovement updateStockMovement(int idStockMovement, StockMovement updateMovement) throws SQLException {
        return stockMovementRepository.updateStockMovement(updateMovement);
    }

    @Override
    public StockMovement updateIngredientStock(int idIngredient, double restQuantity, Timestamp movementDate) throws SQLException {
        return stockMovementRepository.updateIngredientStock(idIngredient, restQuantity, movementDate);
    }

    @Override
    public List<StockMovement> getMovementsByDateRange(Timestamp movementDate) throws SQLException {
      return stockMovementRepository.getMovementsByDateRange(movementDate);
    }
}
