package com.gestion.restauration.Controller;

import com.gestion.restauration.Entity.Price;
import com.gestion.restauration.Service.PriceService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    @GetMapping("/price")
    public List<Price> getAllPrices() throws SQLException{
        return priceService.getAllPrices();
    }

    @GetMapping("/price/{idPrice}")
    public int getPriceById(@PathVariable int idPrice) throws SQLException{
        return priceService.getPriceById(idPrice);
    }
    @PostMapping("/price")
    public Price createPrice(@RequestBody Price createPrice) throws SQLException{
        return priceService.createPrice(createPrice);
    }
    @PutMapping("/price/{idPrice}")
    public Price updatePrice(@PathVariable int idPrice, @RequestBody Price updatePrice) throws SQLException{
        return priceService.updatePrice(idPrice, updatePrice);
    }
}
