package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.PriceHistory;
import com.gestion.restauration.Repository.PriceHistoryRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PriceHistoryServiceImpl implements PriceHistoryService {
    private final PriceHistoryRepository priceHistoryRepository;

    public PriceHistoryServiceImpl(PriceHistoryRepository priceHistoryRepository) {
        this.priceHistoryRepository = priceHistoryRepository;
    }

    @Override
    public List<PriceHistory> getAllPrices() throws SQLException {
        return priceHistoryRepository.getAllPrices();
    }

    @Override
    public int getPriceById(int idPrice) throws SQLException {
        return priceHistoryRepository.getPriceById(idPrice);
    }

    @Override
    public PriceHistory createPrice(PriceHistory createPriceHistory) throws SQLException {
        return priceHistoryRepository.createPrice(createPriceHistory);
    }

    @Override
    public PriceHistory updatePrice(int idPrice, PriceHistory updatePriceHistory) throws SQLException {
        return priceHistoryRepository.updatePrice(updatePriceHistory);
    }
}
