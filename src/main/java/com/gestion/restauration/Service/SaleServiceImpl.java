package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.*;
import com.gestion.restauration.Repository.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final MenuRepository menuRepository;
    private final CompositionMenuRepository compositionMenuRepository;
    private final IngredientRepository ingredientRepository;
    private final StockMovementRepository stockMovementRepository;

    public SaleServiceImpl(SaleRepository saleRepository,
                           MenuRepository menuRepository,
                           CompositionMenuRepository compositionMenuRepository,
                           IngredientRepository ingredientRepository,
                           StockMovementRepository stockMovementRepository) {
        this.saleRepository = saleRepository;
        this.menuRepository = menuRepository;
        this.compositionMenuRepository = compositionMenuRepository;
        this.ingredientRepository = ingredientRepository;
        this.stockMovementRepository = stockMovementRepository;
    }

    @Override
    public List<Sale> getAllSales() throws SQLException {
        return saleRepository.getAllSales();
    }

    @Override
    public Sale getSaleById(int idSale) throws SQLException {
        return saleRepository.getSaleById(idSale);
    }

    @Override
    public Sale createSale(Sale saleCreated) throws Exception {
        int menus = menuRepository.getMenuById(saleCreated.getIdMenu());
        if (menus == 0) {
            throw new Exception("Menu not found");
        }

        List<CompositionMenu> compositions = compositionMenuRepository.getCompositionMenuById(saleCreated.getIdMenu());

        for (CompositionMenu composition : compositions) {
            Ingredient ingredient = ingredientRepository.getIngredientById(composition.getIdIngredient());
            if (ingredient == null || ingredient.getQuantity() < composition.getQuantityRequired() * saleCreated.getQuantity()) {
                return (Sale) compositions;
            }
        }

        for (CompositionMenu composition : compositions) {
            Ingredient ingredient = ingredientRepository.getIngredientById(composition.getIdIngredient());
            ingredient.setQuantity(ingredient.getQuantity() - composition.getQuantityRequired() * saleCreated.getQuantity());

        }

        Ingredient ingredient = new Ingredient();
        CompositionMenu compositionMenu = new CompositionMenu();

        StockMovement stockMovement = new StockMovement();
        stockMovement.setIdIngredient(ingredient.getIdIngredient());
        stockMovement.setRestQuantity(-compositionMenu.getQuantityRequired() * saleCreated.getQuantity());
        stockMovement.setMovementDate(new Timestamp(new Date(30-5-24).getTime()));
        stockMovement.setMovementType("out");
        stockMovementRepository.createStockMovement(stockMovement);

        Menu menu = new Menu();
        saleCreated.setSaleDate(new Timestamp(new Date(30-5-24).getTime()));
        saleCreated.setTotalAmount(menu.getUnitPrice() * saleCreated.getQuantity());
        saleRepository.createSale(saleCreated);

        return saleCreated;
    }
}
