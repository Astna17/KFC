package com.gestion.restauration.Repository;

import com.gestion.restauration.Entity.CompositionMenu;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface CompositionMenuRepository {
    List<CompositionMenu> getAllCompositions() throws SQLException;
    List<CompositionMenu> getCompositionMenuById(int idComposition) throws SQLException;
    CompositionMenu createCompositionMenu(CompositionMenu createComposition) throws SQLException;
    CompositionMenu updateCompositionMenu(CompositionMenu updateComposition) throws SQLException;
}
