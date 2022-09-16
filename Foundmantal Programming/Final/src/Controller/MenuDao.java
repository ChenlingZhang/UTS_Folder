package Controller;

import Model.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Zeyu Cui
 */
public class MenuDao {
    public ResultSet viewMenu(Connection connection) throws SQLException {
        String query = "select * from Menu";
        PreparedStatement statement = connection.prepareStatement(query);
        return  statement.executeQuery();
    }

    public String isItemAvaliable(Connection connection, String name, String price) throws SQLException {
        String avaliable=null;
        String query = "select avaliable from Menu where name=? and price=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,name);
        statement.setString(2,price);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
           avaliable = resultSet.getString("avaliable");
        }
        return avaliable;
    }
}
