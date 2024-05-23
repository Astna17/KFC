package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.Price;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface PriceService {
    List<Price> getAllPrices() throws SQLException;
    int getPriceById(int isPrice) throws SQLException;
    Price createPrice(Price createPrice) throws SQLException;
    Price updatePrice(int idPrice, Price updatePrice) throws SQLException;
}
