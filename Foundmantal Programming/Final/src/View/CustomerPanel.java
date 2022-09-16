/*
 * Created by JFormDesigner on Mon May 16 14:29:03 CST 2022
 */

package View;

import Controller.MenuDao;
import Model.Menu;
import Utils.JDBC;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Zeyu Cui
 */
public class CustomerPanel extends JFrame {
    ArrayList<Menu> orderList = new ArrayList<Model.Menu>();
    public CustomerPanel() {
        initComponents();
    }

    private void MenuTableMouseClicked(MouseEvent e) {
        // TODO add your code here
        DefaultTableModel dtm = (DefaultTableModel) MenuTable.getModel();
        this.Name.setText(dtm.getValueAt(MenuTable.getSelectedRow(),0).toString());
        this.Price.setText(dtm.getValueAt(MenuTable.getSelectedRow(),1).toString());
    }

    private void ViewMenu(ActionEvent e) {
        // TODO add your code here
        DefaultTableModel dtm = (DefaultTableModel) MenuTable.getModel();
        dtm.setRowCount(0);
        Connection connection = null;
        try{
            connection = new JDBC().connect();
            ResultSet resultSet = new MenuDao().viewMenu(connection);
            while (resultSet.next()){
                Vector vector = new Vector();
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("price"));
                dtm.addRow(vector);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            try{
                new JDBC().closeConnection(connection);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    private void AddOrder(ActionEvent e) {
        // TODO add your code here
        Connection connection = null;
        try{
            connection = new JDBC().connect();
            String avaliable = new MenuDao().isItemAvaliable(connection, this.Name.getText(),this.Price.getText());
            if (avaliable.equalsIgnoreCase("true")){
                orderList.add(new Model.Menu(this.Name.getText(), Float.parseFloat(this.Price.getText()),avaliable));
                JOptionPane.showMessageDialog(null,"Sucess Add");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            try {
                new JDBC().closeConnection(connection);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void CheckOut(ActionEvent e) {
        // TODO add your code here
        double price = 0.0;
        for (Menu m: orderList) {
            price += (double) (m.getPrice());
        }
        JOptionPane.showMessageDialog(null,
                "Total Price:  " + price
                );
    }

    private void Return(ActionEvent e) {
        // TODO add your code here
        dispose();
        new LoginPannel().setVisible(true);
    }
    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chenling Zhang
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.CustomerPannel");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        MenuTable = new JTable();
        Add = new JButton();
        View = new JButton();
        button1 = new JButton();
        label1 = new JLabel();
        Name = new JTextField();
        label2 = new JLabel();
        Price = new JTextField();
        Return = new JButton();
        buttonBar = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //======== contentPanel ========
            {

                //======== scrollPane1 ========
                {

                    //---- MenuTable ----
                    MenuTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "Name", "Price"
                        }
                    ));
                    MenuTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    MenuTable.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            MenuTableMouseClicked(e);
                            MenuTableMouseClicked(e);
                        }
                    });
                    scrollPane1.setViewportView(MenuTable);
                }

                //---- Add ----
                Add.setText("Add To Order");
                Add.addActionListener(e -> AddOrder(e));

                //---- View ----
                View.setText("View Menu");
                View.addActionListener(e -> ViewMenu(e));

                //---- button1 ----
                button1.setText("ChechOut");
                button1.addActionListener(e -> CheckOut(e));

                //---- label1 ----
                label1.setText(bundle.getString("label1.text"));

                //---- label2 ----
                label2.setText(bundle.getString("label2.text"));

                //---- Return ----
                Return.setText("Return");
                Return.addActionListener(e -> Return(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(69, 69, 69)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(View, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(Add, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(Return, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(81, 81, 81)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Name, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2)
                                        .addComponent(Price, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
                            .addContainerGap(87, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(Price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                                    .addComponent(View)
                                    .addGap(18, 18, 18)
                                    .addComponent(Add)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1)
                                    .addGap(18, 18, 18)
                                    .addComponent(Return)
                                    .addGap(38, 38, 38)))
                            .addContainerGap())
                );
            }

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGap(0, 979, Short.MAX_VALUE)
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
    private JScrollPane scrollPane1;
    private JTable MenuTable;
    private JButton Add;
    private JButton View;
    private JButton button1;
    private JLabel label1;
    private JTextField Name;
    private JLabel label2;
    private JTextField Price;
    private JButton Return;
    private JPanel buttonBar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
