/*
 * Created by JFormDesigner on Wed May 11 00:55:42 CST 2022
 */

package View;

import Dao.EmployeeDao;
import Model.Employee;
import Utils.JDBC_Connection;
import Utils.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Chenling Zhang
 */
public class EmployeeAddPanel extends JFrame {
    public EmployeeAddPanel() {
        initComponents();
    }

    private void Submit(ActionEvent e) {
        int id = Integer.parseInt(this.ID.getText());
        String name = this.Name.getText();
        String email = this.Email.getText();
        String password = this.Passoword.getText();
        String gender = this.Gender.getText();
        String position = this.Position.getText();
        String address = this.Address.getText();

        if (StringUtil.isEmpty(this.ID.getText())){
            JOptionPane.showMessageDialog(null,"ID cannot be numll");
        }
        else if (StringUtil.isEmpty(name)){
            JOptionPane.showMessageDialog(null,"Name cannot be numll");
        }
        else if(StringUtil.isEmpty(email)){
            JOptionPane.showMessageDialog(null,"email cannot be numll");
        }
        else if (StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null,"password cannot be numll");
        }
        else if (StringUtil.isEmpty(gender)){
            JOptionPane.showMessageDialog(null,"gender cannot be numll");
        }
        else if (StringUtil.isEmpty(position)){
            JOptionPane.showMessageDialog(null,"position cannot be numll");
        }
        else if (StringUtil.isEmpty(address)){
            JOptionPane.showMessageDialog(null,"address cannot be numll");
            return;
        }
        else{
            Employee employee = new Employee(id,name,email,gender,address,position,password);
            Connection connection = null;
            try{
                connection = new JDBC_Connection().connect();
                int affect = new EmployeeDao().addEmployee(employee,connection);
                if(affect>0){
                    JOptionPane.showMessageDialog(null,"Success Add");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error!!");
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
    }

    private void AddRest(ActionEvent e) {
        this.ID.setText("");
        this.Name.setText("");
        this.Email.setText("");
        this.Passoword.setText("");
        this.Gender.setText("");
        this.Position.setText("");
        this.Address.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chenling Zhang
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.ControllerPannel");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label6 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        ID = new JTextField();
        Name = new JTextField();
        Email = new JTextField();
        Passoword = new JTextField();
        Gender = new JTextField();
        Position = new JTextField();
        Address = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        okButton2 = new JButton();
        Title = new JLabel();

        //======== this ========
        setTitle(bundle.getString("this.title_4"));
        Container contentPane = getContentPane();

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,dialogPane. getBorder( )) )
            ; dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText(bundle.getString("label1.text"));

                //---- label6 ----
                label6.setText(bundle.getString("label6.text"));

                //---- label8 ----
                label8.setText(bundle.getString("label8.text"));

                //---- label9 ----
                label9.setText(bundle.getString("label9.text"));

                //---- label11 ----
                label11.setText(bundle.getString("label11.text"));

                //---- label12 ----
                label12.setText(bundle.getString("label12.text"));

                //---- label13 ----
                label13.setText(bundle.getString("label13.text"));

                //---- label14 ----
                label14.setText(bundle.getString("label14.text"));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label14)
                                .addComponent(label6)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8)
                                .addComponent(label11)
                                .addComponent(label12)
                                .addComponent(label13))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(Name, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(Email, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(Passoword, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(Gender, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(Position, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(Address, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(ID, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                            .addGap(55, 55, 55))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label1))
                                .addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label8)
                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label9)
                                .addComponent(Email, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label11)
                                .addComponent(Passoword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label12)
                                .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label13)
                                .addComponent(Position, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label14)
                                .addComponent(Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(54, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- okButton ----
                okButton.setText(bundle.getString("okButton.text_3"));
                okButton.addActionListener(e -> AddRest(e));

                //---- okButton2 ----
                okButton2.setText(bundle.getString("okButton2.text"));
                okButton2.addActionListener(e -> Submit(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addContainerGap(530, Short.MAX_VALUE)
                            .addComponent(okButton2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(okButton)
                                .addComponent(okButton2))
                            .addContainerGap())
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //---- Title ----
            Title.setText(bundle.getString("Title.text"));
            dialogPane.add(Title, BorderLayout.NORTH);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(dialogPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(dialogPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chenling Zhang
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label6;
    private JLabel label8;
    private JLabel label9;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JTextField ID;
    private JTextField Name;
    private JTextField Email;
    private JTextField Passoword;
    private JTextField Gender;
    private JTextField Position;
    private JTextField Address;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton okButton2;
    private JLabel Title;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
