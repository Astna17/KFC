package com.gestion.restauration.Controller;

import com.gestion.restauration.Entity.CompositionMenu;
import com.gestion.restauration.Service.CompositionMenuService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompositionMenuController {
    private final CompositionMenuService compositionMenuService;

    public CompositionMenuController(CompositionMenuService compositionMenuService) {
        this.compositionMenuService = compositionMenuService;
    }
    @GetMapping("/compositionMenu")
    public List<CompositionMenu> getAllCompositions() throws SQLException{
        return compositionMenuService.getAllCompositions();
    }
    @GetMapping("/compositionMenu/{idComposition}")
    public List<CompositionMenu> getCompositionById(@PathVariable int idComposition) throws SQLException {
        return compositionMenuService.getCompositionMenuById(idComposition);
    }
    @PostMapping("/compositionMenu")
    public CompositionMenu createCompositionMenu(@RequestBody CompositionMenu createComposition) throws SQLException{
        return compositionMenuService.createCompositionMenu(createComposition);
    }
    @PutMapping("/compositionMenu/{idComposition}")
    public CompositionMenu updateCompositionMenu(@PathVariable int idComposition, @RequestBody CompositionMenu updateComposition) throws SQLException{
        return compositionMenuService.updateCompositionMenu(idComposition, updateComposition);
    }
}
