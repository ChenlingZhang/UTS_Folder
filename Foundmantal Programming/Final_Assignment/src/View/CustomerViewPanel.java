/*
 * Created by JFormDesigner on Tue May 10 20:53:00 CST 2022
 */

package View;

import Dao.CustomerDao;
import Model.Customer;
import Utils.JDBC_Connection;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class CustomerViewPanel extends JFrame {
    public CustomerViewPanel() {
        initComponents();
    }

    private void ViewCustomer(ActionEvent e) {
        // TODO add your code here
        fillTable();
    }


    private void UpdateCusomer(ActionEvent e) {
        // TODO add your code here
        String ID = this.ID.getText();
        String name = this.Name.getText();
        String gender = this.Gender.getText();
        String email = this.Email.getText();
        String phone = this.Phone.getText();
        String address = this.Address.getText();
        String clubcard = this.ClubCard.getText();
        String group = this.Group.getText();
        String arrive = this.Arrive.getText();
        Customer customer = new Customer(Integer.parseInt(ID),name,email,gender,address,phone,clubcard,Integer.parseInt(group),arrive);
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            int result = new CustomerDao().updateCustomerList(connection,customer);
            if (result > 0){
                JOptionPane.showMessageDialog(null, "updateSuccess");
            }
            else{
                JOptionPane.showMessageDialog(null,"Fail");
            }
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            try{
                new JDBC_Connection().closeConnection(connection);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    private void CustomerTableMouseClicked(MouseEvent e) {
        // TODO add your code here
        DefaultTableModel dtm = (DefaultTableModel)CustomerTable.getModel();
        this.ID.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),0).toString());
        this.Name.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),1).toString());
        this.Gender.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),2).toString());
        this.Email.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),3).toString());
        this.Phone.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),4).toString());
        this.Address.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),5).toString());
        this.ClubCard.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),6).toString());
        this.Group.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),7).toString());
        this.Arrive.setText(dtm.getValueAt(CustomerTable.getSelectedRow(),8).toString());
    }

    private void CustomerViewPanelMouseClick(MouseEvent e) {
        // TODO add your code here
    }

    private void DeleteCustomer(ActionEvent e) {
        // TODO add your code here
        String id = this.ID.getText();
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            int result = new CustomerDao().deleteCustomer(connection, Integer.parseInt(id));
            if (result > 0){
                JOptionPane.showMessageDialog(null,"delete success");
            }
            else{
                JOptionPane.showMessageDialog(null,"fail");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            try{
                new JDBC_Connection().closeConnection(connection);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chenling Zhang
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.ControllerPannel");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        CustomerTable = new JTable();
        label1 = new JLabel();
        ID = new JTextField();
        label2 = new JLabel();
        Name = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        Gender = new JTextField();
        Email = new JTextField();
        label5 = new JLabel();
        Phone = new JTextField();
        label6 = new JLabel();
        Address = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        ClubCard = new JTextField();
        Group = new JTextField();
        label9 = new JLabel();
        Arrive = new JTextField();
        buttonBar = new JPanel();
        Show = new JButton();
        Delete = new JButton();
        Update = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_3"));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            CustomerViewPanelMouseClick(e);
                        }
                    });

                    //---- CustomerTable ----
                    CustomerTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "ID", "Name", "Gender", "Email", "Phone", "Address", "ClubCard", "Group", "Arriving Time"
                        }
                    ));
                    CustomerTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    CustomerTable.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            CustomerTableMouseClicked(e);
                        }
                    });
                    scrollPane1.setViewportView(CustomerTable);
                }

                //---- label1 ----
                label1.setText(bundle.getString("label1.text_2"));

                //---- label2 ----
                label2.setText(bundle.getString("label2.text"));

                //---- label3 ----
                label3.setText(bundle.getString("label3.text"));

                //---- label4 ----
                label4.setText(bundle.getString("label4.text"));

                //---- label5 ----
                label5.setText(bundle.getString("label5.text"));

                //---- label6 ----
                label6.setText(bundle.getString("label6.text_2"));

                //---- label7 ----
                label7.setText(bundle.getString("label7.text"));

                //---- label8 ----
                label8.setText(bundle.getString("label8.text_2"));

                //---- label9 ----
                label9.setText(bundle.getString("label9.text_2"));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(Name, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(ID, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label5))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(18, 18, 18)
                                    .addComponent(Email, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label6)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(Phone, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(Address, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label7)
                                .addComponent(label8))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(ClubCard, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                .addComponent(Group, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(label9)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Arrive, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label1)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(ID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3)
                                    .addComponent(Gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5)
                                    .addComponent(Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label7)
                                    .addComponent(ClubCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label9)
                                    .addComponent(Arrive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4)
                                .addComponent(Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6)
                                .addComponent(Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8)
                                .addComponent(Group, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 24, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- Show ----
                Show.setText(bundle.getString("Show.text"));
                Show.addActionListener(e -> ViewCustomer(e));

                //---- Delete ----
                Delete.setText(bundle.getString("Delete.text_2"));
                Delete.addActionListener(e -> DeleteCustomer(e));

                //---- Update ----
                Update.setText(bundle.getString("Update.text_2"));
                Update.addActionListener(e -> UpdateCusomer(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, buttonBarLayout.createSequentialGroup()
                            .addContainerGap(599, Short.MAX_VALUE)
                            .addComponent(Show, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Update)
                            .addGap(18, 18, 18)
                            .addComponent(Delete)
                            .addGap(17, 17, 17))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, buttonBarLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Delete)
                                .addComponent(Update)
                                .addComponent(Show)))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chenling Zhang
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable CustomerTable;
    private JLabel label1;
    private JTextField ID;
    private JLabel label2;
    private JTextField Name;
    private JLabel label3;
    private JLabel label4;
    private JTextField Gender;
    private JTextField Email;
    private JLabel label5;
    private JTextField Phone;
    private JLabel label6;
    private JTextField Address;
    private JLabel label7;
    private JLabel label8;
    private JTextField ClubCard;
    private JTextField Group;
    private JLabel label9;
    private JTextField Arrive;
    private JPanel buttonBar;
    private JButton Show;
    private JButton Delete;
    private JButton Update;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void fillTable(){
        DefaultTableModel dtm = (DefaultTableModel) CustomerTable.getModel();
        dtm.setRowCount(0);
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            ResultSet resultSet = new CustomerDao().customerList(connection);
            while(resultSet.next()){
                Vector v = new Vector();
                v.add(resultSet.getInt("ID"));
                v.add(resultSet.getString("Name"));
                v.add(resultSet.getString("Gender"));
                v.add(resultSet.getString("Email"));
                v.add(resultSet.getString("PhoneNumber"));
                v.add(resultSet.getString("Address"));
                v.add(resultSet.getString("ClubCard"));
                v.add(resultSet.getString("GroupPeople"));
                v.add(resultSet.getString("ArrivingTime"));
                dtm.addRow(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                new JDBC_Connection().closeConnection(connection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
