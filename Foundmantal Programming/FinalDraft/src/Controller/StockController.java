package Controller;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author chenlingzhang
 */
public class StockController {

    public ResultSet viewAllProducts(Connection connection) throws SQLException {
        String query = "select * from Product";
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public ResultSet viewPerishableProducts(Connection connection) throws SQLException {
        String query = "select * from Product where type = 0";
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public ResultSet viewUnperishableProducts(Connection connection) throws SQLException {
        String query = "select * from Product where type = 1";
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public int addProduct(Connection connection, Product product) throws SQLException {
        String query = "INSERT INTO Product (ID, Name, Type, minStock, maxStock, currentStock, stage) VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, String.valueOf(product.getID()));
        statement.setString(2, product.getProductName());
        statement.setString(3, String.valueOf(product.getProductType()));
        statement.setString(4, String.valueOf(product.getMinStock()));
        statement.setString(5, String.valueOf(product.getMaxStock()));
        statement.setString(6, String.valueOf(product.getCurrentStock()));
        statement.setString(7, product.getStage());
        return statement.executeUpdate();
    }

    public int updateProduct(Connection connection, Product product) throws SQLException {
        String query = "UPDATE Product SET Name=?, Type = ?, minStock=?, maxStock=?, currentStock=?, stage=? WHERE (ID = ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(7, String.valueOf(product.getID()));
        statement.setString(1, product.getProductName());
        statement.setInt(2, product.getProductType());
        statement.setString(3, String.valueOf(product.getMinStock()));
        statement.setString(4, String.valueOf(product.getMaxStock()));
        statement.setString(5, String.valueOf(product.getCurrentStock()));
        statement.setString(6, product.getStage());
        return statement.executeUpdate();
    }

    public int deleteProduct(Connection connection, String id) throws SQLException {
        String query = "DELETE FROM Product WHERE (ID = ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,id);
        return statement.executeUpdate();
    }
}
