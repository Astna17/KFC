package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.Ingredient;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface IngredientService {
    List<Ingredient> getAllIngredients() throws SQLException;
    Ingredient getIngredientById(int idIngredient) throws SQLException;
    Ingredient createIngredient(Ingredient createIngredient) throws SQLException;
    Ingredient updateIngredient(int idIngredient, Ingredient updateIngredient) throws SQLException;
}
