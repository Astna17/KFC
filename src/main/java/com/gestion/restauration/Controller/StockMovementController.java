package com.gestion.restauration.Controller;

import com.gestion.restauration.Entity.StockMovement;
import com.gestion.restauration.Service.StockMovementService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StockMovementController {
    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }
    @GetMapping("/stockMovement")
    public List<StockMovement> getAllMovements() throws SQLException {
        return stockMovementService.getAllMovements();
    }
    @GetMapping("/stockMovement/{idStockMovement}")
    public int getStockMovementById(@PathVariable int idStockMovement) throws SQLException{
        return stockMovementService.getStockMovementById(idStockMovement);
    }
    @PostMapping("/stockMovement")
    public StockMovement createStockMovement(@RequestBody StockMovement createMovement) throws SQLException{
        return stockMovementService.createStockMovement(createMovement);
    }
    @PutMapping("/stockMovement/{idStockMovement}")
    public StockMovement updateStockMovement(
            @PathVariable int idStockMovement,
            @RequestBody StockMovement updateMovement) throws SQLException{
        return stockMovementService.updateStockMovement(idStockMovement, updateMovement);
    }
    @PutMapping("/stockMovement")
    public StockMovement addStockMovementForNewIngredient(
            @RequestParam int idIngredient,
            @RequestParam double restQuantity,
            @RequestParam Timestamp movementDate) throws SQLException {
        return stockMovementService.updateIngredientStock(idIngredient, restQuantity, movementDate);
    }
    @GetMapping("/stockMovement")
    public List<StockMovement> getStockMovements(@RequestParam("movementDate") Timestamp movementDate) throws SQLException {
        return stockMovementService.getMovementsByDateRange(movementDate);
    }
    @GetMapping("/stockMovement")
    public Map<Integer, Double> getRemainingStock(@RequestParam("movementDate") Timestamp movementDate) throws SQLException {
        return stockMovementService.getRemainingStockByDateRange(movementDate);
    }
}
