package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Student;

public class SlipController extends Controller<Student> {

    @FXML
    private Label lableCredits;
    @FXML
    private Label lableTotalFee;
    @FXML
    private Label lableNetFee;
    @FXML
    private Label lablePayPerCredit;
    @FXML
    private Label lableScholarship;
    @FXML
    private Label lableDeduction;

    @FXML
    public void initialize() {
        lableCredits.setText(String.valueOf(model.getCredits()) + " credits");
        lableTotalFee.setText(String.format("$%.2f", model.getTotalFee()));
        lableNetFee.setText(String.format("$%.2f", model.getNetFee()));
        lablePayPerCredit.setText(String.format("$%.2f", model.getPayPerCredit()));
        lableScholarship.setText(String.format("$%.2f", model.getScholarship()));
        lableDeduction.setText(String.format("$%.2f", model.getDeduction()));
    }
    @FXML
    public void close(){
        stage.close();
    }
}
