package com.gestion.restauration.Repository;

import com.gestion.restauration.Configuration.DatabaseConnection;
import com.gestion.restauration.Entity.Price;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository{
    private final Connection connection = DatabaseConnection.getConnection();
    private Price mapResultSetToPrice(ResultSet resultSet) throws SQLException {
        Price price = new Price();
        price.setIdPrice(resultSet.getInt(Price.ID_PRICE));
        price.setIdIngredient(resultSet.getInt(Price.ID_INGREDIENT));
        price.setActualUnitPrice(resultSet.getDouble(Price.ACTUAL_UNIT_PRICE));
        price.setModificationDate(resultSet.getDate(Price.MODIFICATION_DATE).toLocalDate());
        return price;
    }
    @Override
    public List<Price> getAllPrices() throws SQLException {
        List<Price> priceList = new ArrayList<>();
        String sql = "SELECT * FROM price";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Price price = mapResultSetToPrice(resultSet);
            priceList.add(price);
        }
        return priceList;
    }

    @Override
    public int getPriceById(int idPrice) throws SQLException {
        int priceId = new Price().getIdPrice();
        String sql = "SELECT * FROM price WHERE id_price = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return mapResultSetToPrice(resultSet).getIdPrice();
        }
        return priceId;
    }

    @Override
    public Price createPrice(Price createPrice) throws SQLException {
        String sql = "INSERT INTO price (id_price = ?, id_ingredient = ?, actual_unit_price = ?, modification_date = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, createPrice.getIdPrice());
        preparedStatement.setInt(2, createPrice.getIdIngredient());
        preparedStatement.setDouble(3, createPrice.getActualUnitPrice());
        preparedStatement.setDate(4, Date.valueOf(createPrice.getModificationDate()));
        return createPrice;
    }

    @Override
    public Price updatePrice(Price updatePrice) throws SQLException {
        String sql = "UPDATE price SET id_ingredient = ?, actual_unit_price = ?, modification_date = ? WHERE id_price = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, updatePrice.getIdIngredient());
        preparedStatement.setDouble(2, updatePrice.getActualUnitPrice());
        preparedStatement.setDate(3, Date.valueOf(updatePrice.getModificationDate()));
        preparedStatement.setInt(4, updatePrice.getIdPrice());
        int priceUpdated = preparedStatement.executeUpdate();
        if (priceUpdated > 0) {
            return updatePrice;
        }
        return null;
                //mapResultSetToPrice((ResultSet) updatePrice((Price)preparedStatement));
    }
}
