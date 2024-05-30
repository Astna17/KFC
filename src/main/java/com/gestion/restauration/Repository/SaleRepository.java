package com.gestion.restauration.Repository;

import com.gestion.restauration.Entity.Sale;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface SaleRepository {
    List<Sale> getAllSales() throws SQLException;
    Sale getSaleById(int idSale) throws SQLException;
    Sale createSale(Sale createSale) throws SQLException;
}
