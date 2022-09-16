package Controller;

import Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZaiYang Cui
 */
public class EmployeeDao {
    public Employee employeeLogin(Connection connection, String email, String password) throws SQLException {
        Employee employee = null;
        String query = "select * from Employee where email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,email);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString("ID"));
            String name = resultSet.getString("Name");
            String gender = resultSet.getString("Gender");
            String position = resultSet.getString("Position");
            String address = resultSet.getString("Address");
            String phone = resultSet.getString("phone");
            employee = new Employee(id,name,email,password,gender,position,address,phone);
        }
        return employee;
    }
}
