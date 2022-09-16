/*
 * Created by JFormDesigner on Tue May 10 15:42:56 CST 2022
 */

package View;

import Dao.EmployeeDao;
import Model.Employee;
import Utils.JDBC_Connection;
import Utils.StringUtil;
import com.mysql.cj.log.Log;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Chenling Zhang
 */
public class Login extends JFrame {
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton resetButton;
    private JLabel User;
    private JTextField username;
    private JLabel pwd;
    private JPasswordField password;
    public JDBC_Connection jdbc_connection = new JDBC_Connection();
    public Login() {
        initComponents();
    }

    /**
     * Reset username and password
     * @param e
     */
    private void reset(ActionEvent e) {
        // TODO add your code here
        this.username.setText("");
        this.password.setText("");
    }

    private void Login(ActionEvent e) {
        String name = this.username.getText();
        String pwd = new String(this.password.getPassword());
        if (StringUtil.isEmpty(name)){
            JOptionPane.showMessageDialog(null, "The username cannot be empty");
        }
        if (StringUtil.isEmpty(pwd)){
            JOptionPane.showMessageDialog(null,"The password cannot be empty");
        }
       Connection connection = null;
        try{
            connection = jdbc_connection.connect();
            Employee currentEmp = new EmployeeDao().login(connection,name,pwd);
            if (currentEmp != null){
                dispose();
                if (currentEmp.getPosition().equalsIgnoreCase("Owner")){
                    new MainPannel().setVisible(true);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Username or password wrong");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private void initComponents() {
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.login");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        resetButton = new JButton();
        User = new JLabel();
        username = new JTextField();
        pwd = new JLabel();
        password = new JPasswordField();


        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());


        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));


            {


                label1.setText(bundle.getString("label1.text"));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(286, 286, 286)
                            .addComponent(label1))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(label1))
                );
            }


            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};


                okButton.setText(bundle.getString("okButton.text"));
                okButton.addActionListener(e -> Login(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                resetButton.setText("Reset");
                resetButton.addActionListener(e -> reset(e));
                buttonBar.add(resetButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }


            User.setText(bundle.getString("User.text"));

            pwd.setText(bundle.getString("pwd.text"));

            GroupLayout dialogPaneLayout = new GroupLayout(dialogPane);
            dialogPane.setLayout(dialogPaneLayout);
            dialogPaneLayout.setHorizontalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addGroup(dialogPaneLayout.createParallelGroup()
                            .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addGroup(dialogPaneLayout.createParallelGroup()
                                    .addComponent(User)
                                    .addComponent(pwd))
                                .addGap(90, 90, 90)
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(username, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(password, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                        .addContainerGap())
            );
            dialogPaneLayout.setVerticalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(User)
                            .addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(pwd)
                            .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }


}

