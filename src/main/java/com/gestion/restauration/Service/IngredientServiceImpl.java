package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.Ingredient;
import com.gestion.restauration.Repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService{
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients() throws SQLException {
        return ingredientRepository.getAllIngredients();
    }

    @Override
    public Ingredient getIngredientById(int idIngredient) throws SQLException {
        return ingredientRepository.getIngredientById(idIngredient);
    }

    @Override
    public Ingredient createIngredient(Ingredient createIngredient) throws SQLException {
        return ingredientRepository.createIngredient(createIngredient);
    }

    @Override
    public Ingredient updateIngredient(int idIngredient, Ingredient updateIngredient) throws SQLException {
        return ingredientRepository.updateIngredient(updateIngredient);
    }
}
