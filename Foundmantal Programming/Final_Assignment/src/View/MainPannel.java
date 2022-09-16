/*
 * Created by JFormDesigner on Tue May 10 19:45:37 CST 2022
 */

package View;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class MainPannel extends JFrame {
    public MainPannel() {
        initComponents();
    }

    private void Employeeview(ActionEvent e) {
        new EmployeeViewPannel().setVisible(true);
    }

    private void viewCustomer(ActionEvent e) {
        // TODO add your code here
        new CustomerViewPanel().setVisible(true);
    }

    private void ViewStock(ActionEvent e) {
        // TODO add your code here
        new StockViewPanel().setVisible(true);
    }

    private void add(ActionEvent e) {
        new EmployeeAddPanel().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chenling Zhang
        ResourceBundle bundle = ResourceBundle.getBundle("Rescources.properties.ControllerPannel");
        menuBar1 = new JMenuBar();
        StockController = new JMenu();
        menuItem1 = new JMenuItem();
        Add = new JMenuItem();
        EmployeeController = new JMenu();
        view = new JMenuItem();
        add = new JMenuItem();
        CustomerController = new JMenu();
        viewC = new JMenuItem();
        addC = new JMenuItem();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {
            menuBar1.setBackground(new Color(204, 204, 204));

            //======== StockController ========
            {
                StockController.setText(bundle.getString("StockController.text"));
                StockController.setBackground(Color.gray);

                //---- menuItem1 ----
                menuItem1.setText(bundle.getString("menuItem1.text"));
                menuItem1.setBackground(new Color(204, 204, 204));
                menuItem1.addActionListener(e -> ViewStock(e));
                StockController.add(menuItem1);

                //---- Add ----
                Add.setText(bundle.getString("Add.text"));
                Add.setBackground(new Color(204, 204, 204));
                StockController.add(Add);
            }
            menuBar1.add(StockController);

            //======== EmployeeController ========
            {
                EmployeeController.setText(bundle.getString("EmployeeController.text"));
                EmployeeController.setBackground(Color.gray);

                //---- view ----
                view.setText(bundle.getString("view.text"));
                view.setBackground(new Color(204, 204, 204));
                view.addActionListener(e -> Employeeview(e));
                EmployeeController.add(view);

                //---- add ----
                add.setText(bundle.getString("add.text"));
                add.setBackground(new Color(204, 204, 204));
                add.addActionListener(e -> add(e));
                EmployeeController.add(add);
            }
            menuBar1.add(EmployeeController);

            //======== CustomerController ========
            {
                CustomerController.setText(bundle.getString("CustomerController.text"));
                CustomerController.setBackground(Color.darkGray);

                //---- viewC ----
                viewC.setText(bundle.getString("viewC.text"));
                viewC.setBackground(new Color(204, 204, 204));
                viewC.addActionListener(e -> viewCustomer(e));
                CustomerController.add(viewC);

                //---- addC ----
                addC.setText(bundle.getString("addC.text"));
                addC.setBackground(new Color(204, 204, 204));
                CustomerController.add(addC);
            }
            menuBar1.add(CustomerController);
        }
        setJMenuBar(menuBar1);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 763, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 430, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chenling Zhang
    private JMenuBar menuBar1;
    private JMenu StockController;
    private JMenuItem menuItem1;
    private JMenuItem Add;
    private JMenu EmployeeController;
    private JMenuItem view;
    private JMenuItem add;
    private JMenu CustomerController;
    private JMenuItem viewC;
    private JMenuItem addC;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
