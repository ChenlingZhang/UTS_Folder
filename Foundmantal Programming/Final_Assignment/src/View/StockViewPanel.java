/*
 * Created by JFormDesigner on Wed May 11 00:15:24 CST 2022
 */

package View;

import java.awt.event.*;
import Dao.StockDao;
import Utils.JDBC_Connection;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Chenling Zhang
 */
public class StockViewPanel extends JFrame {
    public StockViewPanel() {
        initComponents();
    }

    private void viewPerishableProducts(ActionEvent e) {
        // TODO add your code here
        fillPerishableProducts();
        
    }

    private void ViewUnperishableProducts(ActionEvent e) {
        // TODO add your code here
        fillUnperishableProducts();
    }

    private void ViewAllProducts(ActionEvent e) {
        // TODO add your code here
        fillAllStockList();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chenling Zhang
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.ControllerPannel");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        StockTable = new JTable();
        buttonBar = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        okButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
            EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing
            . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
            java . awt. Color .red ) ,dialogPane. getBorder () ) ); dialogPane. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
            { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )
            throw new RuntimeException( ) ;} } );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== scrollPane1 ========
                {

                    //---- StockTable ----
                    StockTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "ID", "Name", "Type", "Min Stock", "MaxStock", "CurrentStock", "Stage"
                        }
                    ));
                    scrollPane1.setViewportView(StockTable);
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- button1 ----
                button1.setText(bundle.getString("button1.text"));
                button1.addActionListener(e -> viewPerishableProducts(e));
                buttonBar.add(button1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- button2 ----
                button2.setText(bundle.getString("button2.text"));
                button2.addActionListener(e -> ViewUnperishableProducts(e));
                buttonBar.add(button2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText(bundle.getString("okButton.text_2"));
                okButton.addActionListener(e -> ViewAllProducts(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
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
    private JTable StockTable;
    private JPanel buttonBar;
    private JButton button1;
    private JButton button2;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * Fill UnperishableProducts
     */
    private void fillUnperishableProducts(){
        DefaultTableModel dtm = (DefaultTableModel) StockTable.getModel();
        dtm.setRowCount(0);
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            ResultSet resultSet = new StockDao().unperishProductList(connection);
            while(resultSet.next()){
                Vector v = new Vector();
                v.add(resultSet.getInt("ID"));
                v.add(resultSet.getString("Name"));
                v.add(resultSet.getString("Type"));
                v.add(resultSet.getString("minStock"));
                v.add(resultSet.getString("maxStock"));
                v.add(resultSet.getString("currentStock"));
                v.add(resultSet.getString("stage"));
                dtm.addRow(v);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                new JDBC_Connection().closeConnection(connection);
            }
            catch (Exception e){
                e.printStackTrace();

            }
         }
    }

    /**
     * Fill Perishable Products
     */
    private void fillPerishableProducts(){
        DefaultTableModel dtm = (DefaultTableModel) StockTable.getModel();
        dtm.setRowCount(0);
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            ResultSet resultSet = new StockDao().pershiableProductList(connection);
            while(resultSet.next()){
                Vector v = new Vector();
                v.add(resultSet.getInt("ID"));
                v.add(resultSet.getString("Name"));
                v.add(resultSet.getString("Type"));
                v.add(resultSet.getString("minStock"));
                v.add(resultSet.getString("maxStock"));
                v.add(resultSet.getString("currentStock"));
                v.add(resultSet.getString("stage"));
                dtm.addRow(v);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                new JDBC_Connection().closeConnection(connection);
            }
            catch (Exception e){
                e.printStackTrace();

            }
        }
    }

    /**
     * Fill All Products
     */
    
    private void fillAllStockList(){
        DefaultTableModel dtm = (DefaultTableModel) StockTable.getModel();
        dtm.setRowCount(0);
        Connection connection = null;
        try{
            connection = new JDBC_Connection().connect();
            ResultSet resultSet = new StockDao().stockList(connection);
            while(resultSet.next()){
                Vector v = new Vector();
                v.add(resultSet.getInt("ID"));
                v.add(resultSet.getString("Name"));
                v.add(resultSet.getString("Type"));
                v.add(resultSet.getString("minStock"));
                v.add(resultSet.getString("maxStock"));
                v.add(resultSet.getString("currentStock"));
                v.add(resultSet.getString("stage"));
                dtm.addRow(v);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                new JDBC_Connection().closeConnection(connection);
            }
            catch (Exception e){
                e.printStackTrace();

            }
        }
    }


}
