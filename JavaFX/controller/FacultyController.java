package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Faculty;
import model.Student;
import model.TMS;

public class FacultyController extends Controller<Faculty> {

    @FXML
    private TextField filterName;
    @FXML
    private TextField filterEmail;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSelect;
    @FXML
    private Button btnSlip;
    @FXML
    private Button btnReport;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;
    @FXML
    private TableColumn<Student, String> phoneColumn;

    private Student selectedStudent = null;

    @FXML
    public void initialize() {

        filterName.setFocusTraversable(false);
        filterEmail.setFocusTraversable(false);
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

        tableView.setItems(model.getStudents());

        tableView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Student> observable, Student oldValue, Student newValue) -> {
            btnDelete.setDisable(false);
            btnSelect.setDisable(false);
            btnSlip.setDisable(false);
            btnReport.setDisable(false);
            selectedStudent = newValue;
        });

        filterName.textProperty().addListener((observable, oldValue, newValue) -> {
            model.filterList(newValue, null);
        });
        filterName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                filterName.setText("");
            }
        });
        filterEmail.textProperty().addListener((observable, oldValue, newValue) -> {
            model.filterList(null, newValue);
        });
        filterEmail.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                filterEmail.setText("");
            }
        });
    }

    public void add() throws IOException {
        
        Student student = new Student("","","","","","",0,0,"");
        student.setFaculty(model);
        
        Stage studentStage = new Stage();
        studentStage.getIcons().add(new Image("view/edit.png"));
        studentStage.setX(ViewLoader.X);
        studentStage.setY(ViewLoader.Y);
        ViewLoader.showStage(student, "/view/student.fxml", "Adding New Student", studentStage);
    }

    public void delete() {
        model.removeStudent(selectedStudent);
    }

    public void select() throws IOException {
        Stage studentStage = new Stage();
        studentStage.initModality(Modality.APPLICATION_MODAL);
        studentStage.getIcons().add(new Image("view/edit.png"));
        studentStage.setX(ViewLoader.X);
        studentStage.setY(ViewLoader.Y);
        ViewLoader.showStage(selectedStudent, "/view/student.fxml", "Accessing File:" + selectedStudent.getName(), studentStage);
    }

    public void slip() throws IOException {
        Stage slipStage = new Stage();
        slipStage.initModality(Modality.APPLICATION_MODAL);
        slipStage.getIcons().add(new Image("view/edit.png"));
        slipStage.setX(ViewLoader.X);
        slipStage.setY(ViewLoader.Y);
        ViewLoader.showStage(selectedStudent, "/view/slip.fxml", selectedStudent.getName() + " SLIP Report", slipStage);
    }

    public void report() throws IOException {
        Stage reportStage = new Stage();
        reportStage.initModality(Modality.APPLICATION_MODAL);
        reportStage.getIcons().add(new Image("view/uts.jpeg"));
        reportStage.setX(ViewLoader.X);
        reportStage.setY(ViewLoader.Y);
        ViewLoader.showStage(new TMS(model), "/view/tms.fxml", "TMS Report", reportStage);
    }

    public void close() {
        stage.close();
    }

}
