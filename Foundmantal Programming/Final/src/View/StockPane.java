/*
 * Created by JFormDesigner on Mon May 16 11:47:26 CST 2022
 */

package View;

import Controller.StockController;
import Model.Product;
import Utils.JDBC;
import jdk.nashorn.internal.scripts.JD;

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
 * @author Chenling Zhang
 */
public class StockPane extends JFrame {
    public StockPane() {
        initComponents();
    }

    private void productTableMouseClicked(MouseEvent e) {
        // TODO add your code here
        DefaultTableModel dtm = (DefaultTableModel)productTable.getModel();
        this.ID.setText(dtm.getValueAt(productTable.getSelectedRow(), 0).toString());
        this.Name.setText(dtm.getValueAt(productTable.getSelectedRow(), 1).toString());
        this.Type.setText(dtm.getValueAt(productTable.getSelectedRow(), 2).toString());
        this.Min.setText(dtm.getValueAt(productTable.getSelectedRow(), 3).toString());
        this.Max.setText(dtm.getValueAt(productTable.getSelectedRow(), 4).toString());
        this.Current.setText(dtm.getValueAt(productTable.getSelectedRow(), 5).toString());
        this.Stage.setText(dtm.getValueAt(productTable.getSelectedRow(), 6).toString());
    }

    private void ViewPenishable(ActionEvent e) {
        // TODO add your code here
        fillTable("view penishable");

    }

    private void ViewUnpenishable(ActionEvent e) {
        // TODO add your code here
        fillTable("view unpenishable");
    }

    private void ViewAll(ActionEvent e) {
        // TODO add your code here
        fillTable("view all");
    }

    private void DeleteProduct(ActionEvent e) {
        // TODO add your code here
        String id = this.ID.getText();
        StockController stockController = new StockController();
        Connection connection = null;
        try {
            connection = new JDBC().connect();
            int result = stockController.deleteProduct(connection, id);
            if (result > 0){
                JOptionPane.showMessageDialog(null,"Successful Delete!!");
            }
        }
        catch (Exception exception){
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

    private void UpdateProduct(ActionEvent e) {
        // TODO add your code here
        Product product = productMaker();
        StockController stockController = new StockController();
        Connection connection = null;

        try {
            connection = new JDBC().connect();
            int result = stockController.updateProduct(connection,product);
            if (result >0){
                JOptionPane.showMessageDialog(null,"update Success!!!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                new JDBC().closeConnection(connection);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private Product productMaker(){
        int id = Integer.parseInt(this.ID.getText());
        String name = this.Name.getText();
        int type = 0;
        if (this.Type.getText().equalsIgnoreCase("Perishable")){
            type = 0;
        }else if(this.Type.getText().equalsIgnoreCase("Unperishable")){
            type = 1;
        }
        int minStock = Integer.parseInt(this.Min.getText());
        int maxStock = Integer.parseInt(this.Max.getText());
        int currentStock = Integer.parseInt(this.Current.getText());
        String stage = this.Stage.getText();
        return new Product(id,name,type,minStock,maxStock,currentStock,stage);
    }

    private void AddStock(ActionEvent e) {
        // TODO add your code here
        Product product = productMaker();
        Connection connection = null;
        try{
            connection = new JDBC().connect();
            int result = new StockController().addProduct(connection,product);
            if (result>0){
                JOptionPane.showMessageDialog(null, "Success Add");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            try{
                new JDBC().closeConnection(connection);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    private void GoBack(ActionEvent e) {
        // TODO add your code here
        new LoginPannel();
    }

    private void Return(ActionEvent e) {
        // TODO add your code here
        dispose();
        new LoginPannel().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chenling Zhang
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.EmployeePanelController");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        scrollPane1 = new JScrollPane();
        productTable = new JTable();
        View_Penishable = new JButton();
        View_unpenishable = new JButton();
        View_All = new JButton();
        Add_Stock = new JButton();
        label1 = new JLabel();
        ID = new JTextField();
        label2 = new JLabel();
        Name = new JTextField();
        label3 = new JLabel();
        Type = new JTextField();
        label4 = new JLabel();
        Min = new JTextField();
        label5 = new JLabel();
        Max = new JTextField();
        label6 = new JLabel();
        Current = new JTextField();
        label7 = new JLabel();
        Stage = new JTextField();
        Update = new JButton();
        Delete = new JButton();
        GoBack = new JButton();
        Return = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),
            java.awt.Color.red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //======== contentPanel ========
            {

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGap(0, 984, Short.MAX_VALUE)
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGap(0, 550, Short.MAX_VALUE)
                );
            }

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- okButton ----
                okButton.setText(bundle.getString("okButton.text"));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGap(904, 904, 904)
                            .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addComponent(okButton)
                );
            }

            //======== scrollPane1 ========
            {

                //---- productTable ----
                productTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "ID", "Name", "Type", "minStock", "maxStock", "CurrentStock", "Stage"
                    }
                ));
                productTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                productTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        productTableMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(productTable);
            }

            //---- View_Penishable ----
            View_Penishable.setText(bundle.getString("View_Penishable.text"));
            View_Penishable.addActionListener(e -> ViewPenishable(e));

            //---- View_unpenishable ----
            View_unpenishable.setText(bundle.getString("View_unpenishable.text"));
            View_unpenishable.addActionListener(e -> ViewUnpenishable(e));

            //---- View_All ----
            View_All.setText(bundle.getString("View_All.text"));
            View_All.addActionListener(e -> ViewAll(e));

            //---- Add_Stock ----
            Add_Stock.setText(bundle.getString("Add_Stock.text"));
            Add_Stock.addActionListener(e -> AddStock(e));

            //---- label1 ----
            label1.setText(bundle.getString("label1.text"));

            //---- label2 ----
            label2.setText(bundle.getString("label2.text"));

            //---- label3 ----
            label3.setText(bundle.getString("label3.text"));

            //---- label4 ----
            label4.setText(bundle.getString("label4.text"));

            //---- label5 ----
            label5.setText(bundle.getString("label5.text"));

            //---- label6 ----
            label6.setText(bundle.getString("label6.text"));

            //---- label7 ----
            label7.setText(bundle.getString("label7.text"));

            //---- Update ----
            Update.setText(bundle.getString("Update.text"));
            Update.addActionListener(e -> UpdateProduct(e));

            //---- Delete ----
            Delete.setText(bundle.getString("Delete.text"));
            Delete.addActionListener(e -> DeleteProduct(e));

            //---- GoBack ----
            GoBack.setText("Go Back");
            GoBack.addActionListener(e -> GoBack(e));

            //---- Return ----
            Return.setText("Return");
            Return.addActionListener(e -> Return(e));

            GroupLayout dialogPaneLayout = new GroupLayout(dialogPane);
            dialogPane.setLayout(dialogPaneLayout);
            dialogPaneLayout.setHorizontalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addGroup(dialogPaneLayout.createParallelGroup()
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(dialogPaneLayout.createParallelGroup()
                                    .addGroup(dialogPaneLayout.createSequentialGroup()
                                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2)
                                            .addComponent(label3)
                                            .addComponent(label5)
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label4))
                                        .addGap(69, 69, 69)
                                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ID, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Name, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Type, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Max, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Current, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Stage, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Min, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(Delete, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Update, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Add_Stock, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(View_Penishable, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(View_unpenishable, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(View_All, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Return, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                        .addComponent(GoBack, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
            );
            dialogPaneLayout.setVerticalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialogPaneLayout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1)
                                    .addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(Type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(Min, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5)
                                    .addComponent(Max, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6)
                                    .addComponent(Current, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label7)
                                    .addComponent(Stage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Delete, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Update)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Add_Stock, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(View_Penishable)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(View_unpenishable)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(View_All)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(GoBack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Return)))
                        .addGap(6, 6, 6)
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
    private JPanel buttonBar;
    private JButton okButton;
    private JScrollPane scrollPane1;
    private JTable productTable;
    private JButton View_Penishable;
    private JButton View_unpenishable;
    private JButton View_All;
    private JButton Add_Stock;
    private JLabel label1;
    private JTextField ID;
    private JLabel label2;
    private JTextField Name;
    private JLabel label3;
    private JTextField Type;
    private JLabel label4;
    private JTextField Min;
    private JLabel label5;
    private JTextField Max;
    private JLabel label6;
    private JTextField Current;
    private JLabel label7;
    private JTextField Stage;
    private JButton Update;
    private JButton Delete;
    private JButton GoBack;
    private JButton Return;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void tableFilter(ResultSet resultSet, DefaultTableModel dtm){
        try{
            while (resultSet.next()){
                Vector vector = new Vector();
                vector.add(resultSet.getInt("ID"));
                vector.add(resultSet.getString("Name"));
                if (resultSet.getInt("Type") == 0){
                    vector.add("Perishable");
                }else if (resultSet.getInt("Type") == 1){
                    vector.add("Unperishable");
                }else{
                    vector.add("Unknow");
                }
                vector.add(resultSet.getString("minStock"));
                vector.add(resultSet.getString("maxStock"));
                vector.add(resultSet.getString("currentStock"));
                vector.add(resultSet.getString("stage"));
                dtm.addRow(vector);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void fillTable(String searchType){
        DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();
        dtm.setRowCount(0);
        Connection connection = null;
        try{
            connection = new JDBC().connect();
            if (searchType.equalsIgnoreCase("view all")) {
                ResultSet resultSet = new StockController().viewAllProducts(connection);
                tableFilter(resultSet,dtm);
            }
            else if (searchType.equalsIgnoreCase("view penishable")){
                ResultSet resultSet = new StockController().viewPerishableProducts(connection);
                tableFilter(resultSet,dtm);
            }
            else if (searchType.equalsIgnoreCase("view unpenishable")){
                ResultSet resultSet = new StockController().viewUnperishableProducts(connection);
                tableFilter(resultSet,dtm);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                new JDBC().closeConnection(connection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
