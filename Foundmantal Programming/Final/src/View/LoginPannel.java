/*
 * Created by JFormDesigner on Mon May 16 10:20:47 CST 2022
 */

package View;

import Controller.CustomerDao;
import Controller.EmployeeDao;
import Model.Customer;
import Model.Employee;
import Utils.JDBC;
import Utils.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Chenling Zhang
 */
public class LoginPannel extends JFrame {
    public LoginPannel() {
        initComponents();
    }

    private void EmployeeLog(ActionEvent e) {
        // TODO add your code here
        EmployeeDao employeeDao = new EmployeeDao();
        String username = this.username.getText();
        String password = new String(this.password.getPassword());
        if (StringUtil.isEmpty(username)){
            JOptionPane.showMessageDialog(null,"User Name cannot be empty");
            return;
        }
        if (StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null,"Password Fild cannot be empty");
            return;
        }
        Connection connection = null;
        try {
            connection = new JDBC().connect();
            Employee employee = employeeDao.employeeLogin(connection,username,password);
            if (employee != null){
                new StockPane().setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "username or password is wrong");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try{
                new JDBC().closeConnection(connection);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    private void CustomerLog(ActionEvent e) {
        // TODO add your code here
        CustomerDao customerDao = new CustomerDao();
        String username = this.username.getText();
        String password = new String(this.password.getPassword());
        if (StringUtil.isEmpty(username)){
            JOptionPane.showMessageDialog(null,"User Name cannot be empty");
            return;
        }
        if (StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null,"Password Fild cannot be empty");
            return;
        }
        Connection connection = null;
        try {
            connection = new JDBC().connect();
            Customer customer = customerDao.customerLogin(connection,username,password);
            if (customer != null){
                dispose();
                new CustomerPanel().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "username or password is wrong");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try{
                new JDBC().closeConnection(connection);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }

    }

    private void GuestLogin(ActionEvent e) {
        // TODO add your code here
        dispose();
        new CustomerPanel().setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chenling Zhang
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.ControllerPannel");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        Name_Label = new JLabel();
        Password_Label = new JLabel();
        username = new JTextField();
        password = new JPasswordField();
        buttonBar = new JPanel();
        EmployeeLog = new JButton();
        CustomerLog = new JButton();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
            , 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
            dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText(bundle.getString("label1.text"));
                label1.setHorizontalTextPosition(SwingConstants.CENTER);

                //---- Name_Label ----
                Name_Label.setText(bundle.getString("Name_Label.text"));

                //---- Password_Label ----
                Password_Label.setText(bundle.getString("Password_Label.text"));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(392, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                            .addGap(220, 220, 220))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(217, 217, 217)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(Name_Label, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Password_Label, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                            .addGap(251, 251, 251)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(username, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(password, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                            .addContainerGap(180, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(Name_Label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addGap(99, 99, 99)
                                    .addComponent(username, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                            .addGap(81, 81, 81)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Password_Label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(235, Short.MAX_VALUE))
                );
            }

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- EmployeeLog ----
                EmployeeLog.setText(bundle.getString("EmployeeLog.text"));
                EmployeeLog.addActionListener(e -> EmployeeLog(e));

                //---- CustomerLog ----
                CustomerLog.setText(bundle.getString("CustomerLog.text"));
                CustomerLog.addActionListener(e -> CustomerLog(e));

                //---- button1 ----
                button1.setText(bundle.getString("button1.text"));
                button1.addActionListener(e -> GuestLogin(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(EmployeeLog)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                            .addComponent(CustomerLog, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                            .addGap(169, 169, 169)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                            .addGap(100, 100, 100))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, buttonBarLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(EmployeeLog)
                                .addComponent(button1)
                                .addComponent(CustomerLog)))
                );
            }

            GroupLayout dialogPaneLayout = new GroupLayout(dialogPane);
            dialogPane.setLayout(dialogPaneLayout);
            dialogPaneLayout.setHorizontalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            dialogPaneLayout.setVerticalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
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
    private JLabel label1;
    private JLabel Name_Label;
    private JLabel Password_Label;
    private JTextField username;
    private JPasswordField password;
    private JPanel buttonBar;
    private JButton EmployeeLog;
    private JButton CustomerLog;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new LoginPannel().setVisible(true);
    }
}
