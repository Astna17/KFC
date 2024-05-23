package com.gestion.restauration.Controller;

import com.gestion.restauration.Entity.PriceHistory;
import com.gestion.restauration.Service.PriceHistoryService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceHistoryController {
    private final PriceHistoryService priceHistoryService;

    public PriceHistoryController(PriceHistoryService priceHistoryService) {
        this.priceHistoryService = priceHistoryService;
    }
    @GetMapping("/price")
    public List<PriceHistory> getAllPrices() throws SQLException{
        return priceHistoryService.getAllPrices();
    }

    @GetMapping("/price/{idPrice}")
    public int getPriceById(@PathVariable int idPrice) throws SQLException{
        return priceHistoryService.getPriceById(idPrice);
    }
    @PostMapping("/price")
    public PriceHistory createPrice(@RequestBody PriceHistory createPriceHistory) throws SQLException{
        return priceHistoryService.createPrice(createPriceHistory);
    }
    @PutMapping("/price/{idPrice}")
    public PriceHistory updatePrice(@PathVariable int idPrice, @RequestBody PriceHistory updatePriceHistory) throws SQLException{
        return priceHistoryService.updatePrice(idPrice, updatePriceHistory);
    }
}
