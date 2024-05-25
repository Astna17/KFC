package com.gestion.restauration.Controller;

import com.gestion.restauration.Entity.Menu;
import com.gestion.restauration.Service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public List<Menu> getAllMenus() throws SQLException{
        return menuService.getAllMenus();
    }
    @GetMapping("/menu/{idMenu}")
    public int getMenuById(@PathVariable int idMenu) throws SQLException {
        return menuService.getMenuById(idMenu);
    }
    @PostMapping("/menu")
    public Menu createMenu(Menu createMenu) throws SQLException {
        return menuService.createMenu(createMenu);
    }
    @PutMapping("/menu/{idMenu}")
    public Menu updateMenu(@PathVariable int idMenu, @RequestBody Menu updateMenu) throws SQLException {
        return menuService.updateMenu(idMenu, updateMenu);
    }
    @DeleteMapping("/menu/{idMenu}")
    public Menu deleteMenu(@PathVariable int idMenu, @RequestBody Menu deleteMenu) throws SQLException {
        return menuService.deleteMenu(idMenu, deleteMenu);
    }
}
