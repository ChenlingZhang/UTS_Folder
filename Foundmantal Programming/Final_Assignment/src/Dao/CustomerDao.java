package Dao;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao {
    public ResultSet customerList(Connection connection) throws Exception{
        String sql = "select * from Customer";
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public int addCustomerList(Connection connection, Customer customer) throws Exception{
        String sql = "INSERT INTO Customer (ID, Name, Gender, Email, PhoneNumber, Address, ClubCard, GroupPeople, ArrivingTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(customer.getID()));
        statement.setString(2, customer.getName());
        statement.setString(3, customer.getGender());
        statement.setString(4, customer.getEmail());
        statement.setString(5, customer.getPhoneNumber());
        statement.setString(6, customer.getAddress());
        statement.setString(7, customer.getClubCard());
        statement.setString(8, String.valueOf(customer.getGroup()));
        statement.setString(9, customer.getArriveTime());
        return statement.executeUpdate();
    }

    public int deleteCustomer(Connection connection, int id) throws Exception{
        String sql ="DELETE FROM Customer WHERE ID=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id));
        return statement.executeUpdate();
    }

    public int updateCustomerList(Connection connection, Customer customer) throws Exception{
        String sql = "UPDATE Customer SET Name=?, Gender=?, Email=?, PhoneNumber=?, Address=?, ClubCard=?, GroupPeople=? , ArrivingTime=? WHERE ID=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,customer.getName());
        statement.setString(2,customer.getGender());
        statement.setString(3,customer.getEmail());
        statement.setString(4,customer.getPhoneNumber());
        statement.setString(5,customer.getAddress());
        statement.setString(6,customer.getClubCard());
        statement.setString(7,String.valueOf(customer.getGroup()));
        statement.setString(8,customer.getArriveTime());
        statement.setInt(9,customer.getID());
        System.out.println(sql);
        return statement.executeUpdate();
    }
}
