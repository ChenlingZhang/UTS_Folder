package Controller;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Zeyu Cui
 */
public class CustomerDao {
    public Customer customerLogin(Connection connection, String email, String password) throws SQLException {
        Customer customer = null;
        String query = "select * from Customer where Email=? and Password=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString("ID"));
            String name = resultSet.getString("Name");
            String gender = resultSet.getString("Gender");
            String phoneNumber = resultSet.getString("PhoneNumber");
            String address = resultSet.getString("Address");
            String card = resultSet.getString("ClubCard");
            String group = resultSet.getString("GroupPeople");
            String arrivingTime = resultSet.getString("ArrivingTime");
            customer = new Customer(id,name,gender,phoneNumber,email,address,password,arrivingTime,group,card);
        }
        return customer;
    }
}
