package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.CompositionMenu;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface CompositionMenuService {
    List<CompositionMenu> getAllCompositions() throws SQLException;
    List<CompositionMenu> getCompositionMenuById(int idComposition) throws SQLException;
    CompositionMenu createCompositionMenu(CompositionMenu createComposition) throws SQLException;
    CompositionMenu updateCompositionMenu(int idComposition, CompositionMenu updateComposition) throws SQLException;
}
