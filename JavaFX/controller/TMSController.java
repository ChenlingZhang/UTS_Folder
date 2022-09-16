package controller;

import au.edu.uts.ap.javafx.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import model.Report;
import model.TMS;


public class TMSController extends Controller<TMS> {

    @FXML
    private TableView<Report> tableView;
    @FXML
    private TableColumn<Report, String> nameColumn;
    @FXML
    private TableColumn<Report, Number> tuitionColumn;
    @FXML
    private TableColumn<Report, Number> scholarshipColumn;
    @FXML
    private TableColumn<Report, Number> deducionColumn;
    @FXML
    private TableColumn<Report, Number> netFeeColumn;
    @FXML
    private Label labelTotalTuition;
    @FXML
    private Label labelTotalNetFee;
    @FXML
    private Label labelTotalBAS;
    @FXML
    private Label labelTotalScholarship;
    @FXML
    private Label labelTotalDedution;

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tuitionColumn.setCellValueFactory(cellData -> cellData.getValue().totalFeeProperty());
        scholarshipColumn.setCellValueFactory(cellData -> cellData.getValue().scholarshipProperty());
        deducionColumn.setCellValueFactory(cellData -> cellData.getValue().deductionProperty());
        netFeeColumn.setCellValueFactory(cellData -> cellData.getValue().netFeeProperty());
        tuitionColumn.setCellFactory(column -> {
            return new TableCellCallback();
        });
        scholarshipColumn.setCellFactory(column -> {
            return new TableCellCallback();
        });
        deducionColumn.setCellFactory(column -> {
            return new TableCellCallback();
        });
        netFeeColumn.setCellFactory(column -> {
            return new TableCellCallback();
        });
        tableView.setItems(model.reports());
        
        labelTotalTuition.setText(String.format("$%.2f", model.getTotalTuitionFee()));
        labelTotalNetFee.setText(String.format("$%.2f", model.getTotalNetFee()));
        labelTotalBAS.setText(String.format("$%.2f", model.getBas()));
        labelTotalScholarship.setText(String.format("$%.2f", model.getTotalScholarship()));
        labelTotalDedution.setText(String.format("$%.2f", model.getTotalDeduction()));
    }

    @FXML
    public void close() {
        stage.close();
    }

    class TableCellCallback extends TableCell<Report, Number> {

        @Override
        protected void updateItem(Number item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
            } else {
                setText(String.format("$%.2f", item));
            }
        }
    }
}
