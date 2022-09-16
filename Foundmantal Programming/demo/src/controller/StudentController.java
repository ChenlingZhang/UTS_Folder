package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import java.util.LinkedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.InputException;
import model.Student;

public class StudentController extends Controller<Student> {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtCredits;
    @FXML
    private TextField txtScholarship;
    @FXML
    private TextField txtDeduction;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;

    @FXML
    public void initialize() {
        if (!model.getName().isEmpty()) {
            txtName.setText(model.getName());
            txtEmail.setText(model.getEmail());
            txtPhone.setText(model.getPhone());
            txtAddress.setText(model.getAddress());
            txtID.setText(model.getID());
            txtType.setText(model.getType());
            txtCredits.setText(Integer.toString(model.getCredits()));
            txtScholarship.setText(Double.toString(model.getScholarship()));
            txtDeduction.setText(Double.toString(model.getDeduction()));
            btnAdd.setDisable(true);
            btnUpdate.setDisable(false);
        } else {
            txtCredits.setText("0");
            txtScholarship.setText("0.0");
            btnAdd.setDisable(false);
            btnUpdate.setDisable(true);
        }
    }

    public void add() throws IOException {

        String name = txtName.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();
        String type = txtType.getText();
        String id = txtID.getText();
        int credits = 0;
        double scholarship = 0;
        String deduction = txtDeduction.getText();

        Validator v = new Validator();
        v.clear();
        String str = "";
        try {
            credits = Integer.parseInt(txtCredits.getText().trim());
            scholarship = Double.parseDouble(txtScholarship.getText().trim());
            v.generateErrors(name, email, phone, address, type, id, credits, scholarship);
            if (!v.errors().isEmpty()) {
                for (String s : v.errors()) {
                    str += s + "\n";
                }
                throw new InputException(str);
            }
        } catch (InputException e) {

            showErrorWindow(e);
        } catch (NumberFormatException e) {
            showErrorWindow(new InputException(e.getMessage()));
        }
        model.getFaculty().addStudent(new Student(name, email, phone, address, type, id, credits, scholarship, deduction));
    }

    public void update() throws IOException {

        String name = txtName.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();
        String type = txtType.getText();
        String id = txtID.getText();
        int credits = 0;
        double scholarship = 0;
        String deduction = txtDeduction.getText();

        Validator v = new Validator();
        v.clear();
        String str = "";
        try {
            credits = Integer.parseInt(txtCredits.getText().trim());
            scholarship = Double.parseDouble(txtScholarship.getText().trim());
            v.generateErrors(name, email, phone, address, type, id, credits, scholarship);
            if (!v.errors().isEmpty()) {
                for (String s : v.errors()) {
                    str += s + "\n";
                }
                throw new InputException(str);
            }
        } catch (InputException e) {

            showErrorWindow(e);
        } catch (NumberFormatException e) {
            showErrorWindow(new InputException(e.getMessage()));
        }
        model.updateDetails(name, email, phone, address, type, id, credits, scholarship, deduction);
    }

    public void close() {
        stage.close();
    }

    void showErrorWindow(Exception e) throws IOException {
        Stage errorStage = new Stage();
        errorStage.initModality(Modality.APPLICATION_MODAL);
        errorStage.getIcons().add(new Image("view/error.png"));
        errorStage.setX(ViewLoader.X);
        errorStage.setY(ViewLoader.Y);
        ViewLoader.showStage(e, "/view/error.fxml", "Input Exceptions", errorStage);
    }

//    boolean verify() throws IOException {
//
//        Validator v = new Validator();
//        v.clear();
//
//        String credits = txtCredits.getText().trim();
//        String scholarship = txtScholarship.getText().trim();
//        v.generateErrors(
//                txtName.getText(),
//                txtEmail.getText(),
//                txtPhone.getText(),
//                txtAddress.getText(),
//                txtType.getText(),
//                txtID.getText(),
//                credits.isEmpty() ? -1 : Integer.parseInt(credits),
//                scholarship.isEmpty() ? -1 : Double.parseDouble(scholarship)
//        );
//
//        LinkedList<String> errors = v.errors();
//        if (errors.isEmpty()) {
//            return true;
//        } else {
//            Stage errorStage = new Stage();
//            errorStage.initModality(Modality.APPLICATION_MODAL);
//            errorStage.getIcons().add(new Image("view/error.png"));
//            errorStage.setX(ViewLoader.X);
//            errorStage.setY(ViewLoader.Y);
//            ViewLoader.showStage(new InputException(errors.toString()), "/view/error.fxml", "Input Exceptions", errorStage);
//        }
//        return false;
//    }
}
