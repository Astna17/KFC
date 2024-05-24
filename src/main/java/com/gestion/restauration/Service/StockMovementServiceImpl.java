package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.StockMovement;
import com.gestion.restauration.Repository.StockMovementRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
}
