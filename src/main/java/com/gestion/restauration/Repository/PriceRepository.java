package com.gestion.restauration.Repository;

import com.gestion.restauration.Entity.Price;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface PriceRepository {
    List<Price> getAllPrices() throws SQLException;
    int getPriceById(int idPrice) throws SQLException;
    Price createPrice(Price createPrice) throws SQLException;
    Price updatePrice(Price updatePrice) throws SQLException;
}
