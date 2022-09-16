/*
 * Created by JFormDesigner on Tue May 10 20:17:09 CST 2022
 */

package View;

import Dao.CustomerDao;
import Dao.EmployeeDao;
import Model.Employee;
import Utils.JDBC_Connection;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class EmployeeViewPannel extends JFrame {
    public EmployeeViewPannel() {
        initComponents();
    }

    private void ShowEmployee(ActionEvent e) {
        // TODO add your code here
        fillTable();

    }

    private void EmployeeTableMouseClicked(MouseEvent e) {
        DefaultTableModel dtm = (DefaultTableModel)EmployeeTable.getModel();
        // TODO add your code here
        this.ID.setText(dtm.getValueAt(EmployeeTable.getSelectedRow(),0).toString());
        this.Name.setText(dtm.getValueAt(EmployeeTable.getSelectedRow(),1).toString());
        this.Email.setText(dtm.getValueAt(EmployeeTable.getSelectedRow(),2).toString());
        this.Password.setText(dtm.getValueAt(EmployeeTable.getSelectedRow(),3).toString());
        this.Gender.setText(dtm.getValueAt(EmployeeTable.getSelectedRow(),4).toString());
        this.Position.setText(dtm.getValueAt(EmployeeTable.getSelectedRow(),5).toString());
        this.Address.setText(dtm.getValueAt(EmployeeTable.getSelectedRow(),6).toString());
    }

    private void UpdateEmployee(ActionEvent e) {
        // TODO add your code here
        int ID = Integer.parseInt(this.ID.getText());
        String name = this.Name.getText();
        String email = this.Email.getText();
        String password = this.Password.getText();
        String gender = this.Gender.getText();
        String position = this.Position.getText();
        String address = this.Address.getText();
        Employee employee = new Employee(ID,name,email,gender,address,position,password);
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            int affect = new EmployeeDao().updateEmployee(connection,employee);
            if (affect>0){
                JOptionPane.showMessageDialog(null,"Update Success");
                this.ID.setText("");
                this.Name.setText("");
                this.Email.setText("");
                this.Password.setText("");
                this.Gender.setText("");
                this.Position.setText("");
                this.Address.setText("");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            try {
                new JDBC_Connection().closeConnection(connection);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    private void DeleteEmployee(ActionEvent e) {
        // TODO add your code here
        int id = Integer.parseInt(this.ID.getText());
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            int result = new EmployeeDao().deleteEmployee(connection,id);
            if (result>0){
                JOptionPane.showMessageDialog(null,"delete Success");
                this.ID.setText("");
                this.Name.setText("");
                this.Email.setText("");
                this.Password.setText("");
                this.Gender.setText("");
                this.Position.setText("");
                this.Address.setText("");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            try{
                new JDBC_Connection().closeConnection(connection);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    private void DeleteCustomer(ActionEvent e) {
        // TODO add your code here
    }

    private void Show(ActionEvent e) {
        // TODO add your code here
    }
    


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chenling Zhang
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.ControllerPannel");
        scrollPane1 = new JScrollPane();
        EmployeeTable = new JTable();
        Show = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        ID = new JTextField();
        label2 = new JLabel();
        Name = new JTextField();
        label3 = new JLabel();
        Email = new JTextField();
        label4 = new JLabel();
        label6 = new JLabel();
        Password = new JTextField();
        label7 = new JLabel();
        Gender = new JTextField();
        label8 = new JLabel();
        Position = new JTextField();
        label9 = new JLabel();
        Address = new JTextField();

        //======== this ========
        setTitle(bundle.getString("this.title_2"));
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- EmployeeTable ----
            EmployeeTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Name", "Email", "Password", "Gender", "Position", "Address"
                }
            ));
            EmployeeTable.setGridColor(new Color(204, 204, 204));
            EmployeeTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            EmployeeTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    EmployeeTableMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(EmployeeTable);
        }

        //---- Show ----
        Show.setText(bundle.getString("Show.text"));
        Show.addActionListener(e -> {
			ShowEmployee(e);
			Show(e);
		});

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_2"));
        button1.addActionListener(e -> UpdateEmployee(e));

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_2"));
        button2.addActionListener(e -> {
			DeleteEmployee(e);
			DeleteCustomer(e);
		});

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_3"));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_2"));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_2"));

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_2"));

        //---- label6 ----
        label6.setText(bundle.getString("label6.text_3"));

        //---- label7 ----
        label7.setText(bundle.getString("label7.text_2"));

        //---- label8 ----
        label8.setText(bundle.getString("label8.text_3"));

        //---- label9 ----
        label9.setText(bundle.getString("label9.text_3"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(ID, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(Name, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                    .addComponent(Password, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label8)
                                    .addGap(18, 18, 18)
                                    .addComponent(Position, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                    .addGap(207, 207, 207))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 529, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(45, 45, 45)
                                    .addComponent(Email, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label7)
                                    .addGap(18, 18, 18)
                                    .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(label9)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Address, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 515, Short.MAX_VALUE)
                            .addComponent(Show, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button1)))
                    .addGap(18, 18, 18)
                    .addComponent(button2)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3)
                                .addComponent(Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7)
                                .addComponent(Gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label9)
                                .addComponent(Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6)
                                .addComponent(Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8)
                                .addComponent(Position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label4)))
                    .addGap(48, 48, 48)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1)
                        .addComponent(Show))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chenling Zhang
    private JScrollPane scrollPane1;
    private JTable EmployeeTable;
    private JButton Show;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JTextField ID;
    private JLabel label2;
    private JTextField Name;
    private JLabel label3;
    private JTextField Email;
    private JLabel label4;
    private JLabel label6;
    private JTextField Password;
    private JLabel label7;
    private JTextField Gender;
    private JLabel label8;
    private JTextField Position;
    private JLabel label9;
    private JTextField Address;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void fillTable() {
        DefaultTableModel dtm = (DefaultTableModel) EmployeeTable.getModel();
        dtm.setRowCount(0);
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            ResultSet resultSet = new EmployeeDao().employeeList(connection);
            while(resultSet.next()){
                Vector v = new Vector();
                v.add(resultSet.getInt("ID"));
                v.add(resultSet.getString("Name"));
                v.add(resultSet.getString("Email"));
                v.add(resultSet.getString("Password"));
                v.add(resultSet.getString("Gender"));
                v.add(resultSet.getString("Position"));
                v.add(resultSet.getString("Address"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                new JDBC_Connection().closeConnection(connection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
