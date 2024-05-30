package com.gestion.restauration.Repository;

import com.gestion.restauration.Configuration.DatabaseConnection;
import com.gestion.restauration.Entity.Sale;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository{
    private final Connection connection = DatabaseConnection.getConnection();
    private Sale mapResultSetToSale(ResultSet resultSet) throws SQLException {
        Sale sale = new Sale();
        sale.setIdSale(resultSet.getInt(Sale.ID_SALE));
        sale.setIdMenu(resultSet.getInt(Sale.ID_MENU));
        sale.setIdRestaurant(resultSet.getInt(Sale.ID_RESTAURANT));
        sale.setSaleDate(resultSet.getTimestamp(Sale.SALE_DATE));
        sale.setQuantity(resultSet.getInt(Sale.QUANTITY));
        sale.setTotalAmount(resultSet.getDouble(Sale.TOTAL_AMOUNT));
        return sale;
    }
    @Override
    public List<Sale> getAllSales() throws SQLException {
        List<Sale> saleList = new ArrayList<>();
        String sql = "SELECT * FROM sale";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Sale sale = mapResultSetToSale(resultSet);
                saleList.add(sale);
            }
        }
        return saleList;
    }

    @Override
    public Sale getSaleById(int idSale) throws SQLException {
        String sql = "SELECT * FROM sale WHERE id_sale = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idSale);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToSale(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Sale createSale(Sale createSale) throws SQLException {
        String sql = "INSERT INTO sale (id_menu, id_restaurant, sale_date, quantity, total_amount) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, createSale.getIdMenu());
            preparedStatement.setInt(2, createSale.getIdRestaurant());
            preparedStatement.setTimestamp(3, createSale.getSaleDate());
            preparedStatement.setDouble(4, createSale.getQuantity());
            preparedStatement.setDouble(5, createSale.getTotalAmount());
            preparedStatement.executeUpdate();
        }
        return createSale;
    }
}
