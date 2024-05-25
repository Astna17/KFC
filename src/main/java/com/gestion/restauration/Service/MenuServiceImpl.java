package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.Menu;
import com.gestion.restauration.Repository.CompositionMenuRepository;
import com.gestion.restauration.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;
    private final CompositionMenuRepository compositionMenuRepository;

    public MenuServiceImpl(MenuRepository menuRepository, CompositionMenuRepository compositionMenuRepository) {
        this.menuRepository = menuRepository;
        this.compositionMenuRepository = compositionMenuRepository;
    }

    @Override
    public List<Menu> getAllMenus() throws SQLException {
        List<Menu> menuList = menuRepository.getAllMenus();
        for (Menu menu : menuList) {
            int compositionMenuList = compositionMenuRepository.getCompositionMenuById(menu.getIdMenu());
            menu.setIdMenu(compositionMenuList);
        }
        return menuList;
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
    @Override
    public Menu deleteMenu(int idMenu, Menu menu) throws SQLException {
      return  menuRepository.deleteMenu(menu);
    }
}
