package com.gestion.restauration.Controller;

import com.gestion.restauration.Entity.Sale;
import com.gestion.restauration.Service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/sale")
    public List<Sale> getAllSales() throws SQLException {
        return saleService.getAllSales();
    }

    @GetMapping("/sale/,{idSale}")
    public Sale getSaleById(@PathVariable int idSale) throws SQLException{
        return saleService.getSaleById(idSale);
    }

    @PostMapping("/sale")
    public Sale createSale(@RequestBody Sale saleCreated) throws Exception {
        return saleService.createSale(saleCreated);
    }
}
