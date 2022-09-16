package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StockDao {
    public ResultSet unperishProductList(Connection connection) throws Exception{
        String sql = "select * from Product where Type = 1;";
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public ResultSet pershiableProductList(Connection connection) throws Exception{
        String sql = "select * from Product where Type=0;";
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public ResultSet stockList(Connection connection) throws Exception{
        String sql = "select * from Product;";
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }
}
