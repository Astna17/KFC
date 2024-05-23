package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.PriceHistory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface PriceHistoryService {
    List<PriceHistory> getAllPrices() throws SQLException;
    int getPriceById(int isPrice) throws SQLException;
    PriceHistory createPrice(PriceHistory createPriceHistory) throws SQLException;
    PriceHistory updatePrice(int idPrice, PriceHistory updatePriceHistory) throws SQLException;
}
