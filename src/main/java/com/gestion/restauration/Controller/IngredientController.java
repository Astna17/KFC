package com.gestion.restauration.Controller;

import com.gestion.restauration.Entity.Ingredient;
import com.gestion.restauration.Service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredient")
    public List<Ingredient> getAllIngredients() throws SQLException {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/ingredient/{idIngredient}")
    public Ingredient getIngredientById(@PathVariable int idIngredient) throws  SQLException{
        return ingredientService.getIngredientById(idIngredient);
    }

    @PostMapping("/ingredient")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) throws  SQLException {
        return ingredientService.createIngredient(ingredient);
    }

    @PutMapping("/ingredient/{idIngredient}")
    public Ingredient updateIngredient(@PathVariable int idIngredient, @RequestBody Ingredient ingredient) throws SQLException{
        return ingredientService.updateIngredient(idIngredient, ingredient);
    }
}
