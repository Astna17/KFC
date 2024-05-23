package com.gestion.restauration.Repository;

import com.gestion.restauration.Configuration.DatabaseConnection;
import com.gestion.restauration.Entity.PriceHistory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceHistoryRepositoryImpl implements PriceHistoryRepository {
    private final Connection connection = DatabaseConnection.getConnection();
    private PriceHistory mapResultSetToPrice(ResultSet resultSet) throws SQLException {
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setIdPrice(resultSet.getInt(PriceHistory.ID_PRICE));
        priceHistory.setIdIngredient(resultSet.getInt(PriceHistory.ID_INGREDIENT));
        priceHistory.setActualUnitPrice(resultSet.getDouble(PriceHistory.ACTUAL_UNIT_PRICE));
        priceHistory.setStartDate(resultSet.getTimestamp(PriceHistory.START_DATE));
        priceHistory.setEndDate(resultSet.getTimestamp(PriceHistory.END_DATE));
        return priceHistory;
    }
    @Override
    public List<PriceHistory> getAllPrices() throws SQLException {
        List<PriceHistory> priceHistoryList = new ArrayList<>();
        String sql = "SELECT * FROM price_history";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            PriceHistory priceHistory = mapResultSetToPrice(resultSet);
            priceHistoryList.add(priceHistory);
        }
        return priceHistoryList;
    }

    @Override
    public int getPriceById(int idPrice) throws SQLException {
        int priceId = new PriceHistory().getIdPrice();
        String sql = "SELECT * FROM price_history WHERE id_price = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return mapResultSetToPrice(resultSet).getIdPrice();
        }
        return priceId;
    }

    @Override
    public PriceHistory createPrice(PriceHistory createPriceHistory) throws SQLException {
        String sql = "INSERT INTO price_history (id_price = ?, id_ingredient = ?," +
                " actual_unit_price = ?, start_date = ?, end_date = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, createPriceHistory.getIdPrice());
        preparedStatement.setInt(2, createPriceHistory.getIdIngredient());
        preparedStatement.setDouble(3, createPriceHistory.getActualUnitPrice());
        preparedStatement.setTimestamp(4, createPriceHistory.getStartDate());
        preparedStatement.setTimestamp(5, createPriceHistory.getEndDate());
        return createPriceHistory;
    }

    @Override
    public PriceHistory updatePrice(PriceHistory updatePriceHistory) throws SQLException {
        String sql = "UPDATE price_history SET id_ingredient = ?, actual_unit_price = ?, " +
                "start_date = ?, end_date = ?" + " WHERE id_price = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, updatePriceHistory.getIdIngredient());
        preparedStatement.setDouble(2, updatePriceHistory.getActualUnitPrice());
        preparedStatement.setTimestamp(3, updatePriceHistory.getStartDate());
        preparedStatement.setTimestamp(4, updatePriceHistory.getEndDate());
        preparedStatement.setInt(5, updatePriceHistory.getIdPrice());
        int priceUpdated = preparedStatement.executeUpdate();
        if (priceUpdated > 0) {
            return updatePriceHistory;
        }
        return null;
                //mapResultSetToPrice((ResultSet) updatePrice((Price)preparedStatement));
    }
}
