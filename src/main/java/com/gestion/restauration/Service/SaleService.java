package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.Sale;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface SaleService {
    List<Sale> getAllSales() throws SQLException;
    Sale getSaleById(int idSale) throws SQLException;
    Sale createSale(Sale saleCreated) throws Exception;
}
