package Dao;


import Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

    /**
     * Login Check
     * @param connection
     * @param email
     * @param password
     * @return
     * @throws Exception
     */
    public Employee login(Connection connection, String email, String password) throws Exception{
        Employee employee = null;
        String sql = "select * from Employee where Email=? and Password=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            String mail = resultSet.getString("Email");
            String pwd = resultSet.getString("Password");
            String gender = resultSet.getString("gender");
            String position = resultSet.getString("position");
            String address = resultSet.getString("Address");
            employee = new Employee(ID,name,mail,gender,address,position,pwd);
        }
        return employee;
    }

    public int addEmployee(Employee employee, Connection connection) throws Exception{
        String sql = "INSERT INTO Employee(ID,Name,Email,Password,Gender,Position,Address) VALUES (?, ?, ?, ?, ?, ?,?); ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,String.valueOf(employee.getID()));
        statement.setString(2,employee.getName());
        statement.setString(3,employee.getEmail());
        statement.setString(4,employee.getGender());
        statement.setString(5,employee.getPassword());
        statement.setString(6,employee.getPosition());
        statement.setString(7, employee.getAddress());
        return statement.executeUpdate();
    }

    public int updateEmployee(Connection connection,Employee employee) throws Exception {
        String sql = "UPDATE Employee SET Name=?, Email=?, Password=?, Gender=?, Position=?, Address=? where ID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,employee.getName());
        statement.setString(2,employee.getEmail());
        statement.setString(3,employee.getPassword());
        statement.setString(4,employee.getGender());
        statement.setString(5,employee.getPosition());
        statement.setString(6,employee.getAddress());
        statement.setString(7,String.valueOf(employee.getID()));
        return statement.executeUpdate();
    }

    public int deleteEmployee(Connection connection,int id)throws Exception{
        String sql ="DELETE FROM Employee WHERE ID=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,String.valueOf(id));
        return statement.executeUpdate();
    }

    public ResultSet employeeList(Connection connection) throws Exception{
        String sql = "select * from Employee";
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }
}
