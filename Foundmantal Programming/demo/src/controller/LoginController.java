package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculty;
import model.Session;

public class LoginController extends Controller<Session> {

    @FXML
    private Label label_error;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPassword;

    public void ok() throws IOException {

        String email = txtEmail.getText();
        String password = txtPassword.getText();

        Faculty faculty = model.getFaculty(email, password);

        if (faculty != null) {
            Stage facultyStage = new Stage();
            facultyStage.getIcons().add(new Image("view/book.png"));
            facultyStage.setX(ViewLoader.X);
            facultyStage.setY(ViewLoader.Y);
            ViewLoader.showStage(faculty, "/view/faculty.fxml", "Sign In", facultyStage);

            stage.close();
        } else {
            label_error.setText("Incorrect login details");
            txtEmail.setText("");
            txtPassword.setText("");
        }
    }

    public void cancel() {
        stage.close();
    }
}
