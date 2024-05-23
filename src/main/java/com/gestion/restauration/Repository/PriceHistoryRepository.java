package com.gestion.restauration.Repository;

import com.gestion.restauration.Entity.PriceHistory;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface PriceHistoryRepository {
    List<PriceHistory> getAllPrices() throws SQLException;
    int getPriceById(int idPrice) throws SQLException;
    PriceHistory createPrice(PriceHistory createPriceHistory) throws SQLException;
    PriceHistory updatePrice(PriceHistory updatePriceHistory) throws SQLException;
}
