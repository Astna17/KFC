package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.Price;
import com.gestion.restauration.Repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{
    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> getAllPrices() throws SQLException {
        return priceRepository.getAllPrices();
    }

    @Override
    public int getPriceById(int idPrice) throws SQLException {
        return priceRepository.getPriceById(idPrice);
    }

    @Override
    public Price createPrice(Price createPrice) throws SQLException {
        return priceRepository.createPrice(createPrice);
    }

    @Override
    public Price updatePrice(Price updatePrice) throws SQLException {
        return priceRepository.updatePrice(updatePrice);
    }
}
