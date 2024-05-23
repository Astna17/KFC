package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.Menu;
import com.gestion.restauration.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAllMenus() throws SQLException {
        return menuRepository.getAllMenus();
    }

    @Override
    public int getMenuById(int idMenu) throws SQLException {
        return menuRepository.getMenuById(idMenu);
    }

    @Override
    public Menu createMenu(Menu createMenu) throws SQLException {
        return menuRepository.createMenu(createMenu);
    }

    @Override
    public Menu updateMenu(int idMenu, Menu updateMenu) throws SQLException {
        return menuRepository.updateMenu(updateMenu);
    }
}
