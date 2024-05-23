package com.gestion.restauration.Service;

import com.gestion.restauration.Entity.CompositionMenu;
import com.gestion.restauration.Repository.CompositionMenuRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CompositionMenuServiceImpl implements CompositionMenuService{
    private final CompositionMenuRepository compositionMenuRepository;

    public CompositionMenuServiceImpl(CompositionMenuRepository compositionMenuRepository) {
        this.compositionMenuRepository = compositionMenuRepository;
    }

    @Override
    public List<CompositionMenu> getAllCompositions() throws SQLException {
        return compositionMenuRepository.getAllCompositions();
    }

    @Override
    public int getCompositionMenuById(int idComposition) throws SQLException {
        return compositionMenuRepository.getCompositionMenuById(idComposition);
    }

    @Override
    public CompositionMenu createCompositionMenu(CompositionMenu createComposition) throws SQLException {
        return compositionMenuRepository.createCompositionMenu(createComposition);
    }

    @Override
    public CompositionMenu updateCompositionMenu(int idComposition, CompositionMenu updateComposition) throws SQLException {
        return compositionMenuRepository.updateCompositionMenu(updateComposition);
    }
}
