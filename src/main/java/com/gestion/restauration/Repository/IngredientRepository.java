package com.gestion.restauration.Repository;

import com.gestion.restauration.Entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface IngredientRepository {
    List<Ingredient> getAllIngredients() throws SQLException;
    Ingredient getIngredientById(int idIngredient) throws SQLException;
    Ingredient createIngredient(Ingredient createIngredient) throws SQLException;
    Ingredient updateIngredient(Ingredient updateIngredient) throws SQLException;
}
