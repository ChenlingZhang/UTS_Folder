package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;

public class SessionController extends Controller<Session> {

    public void login() throws IOException {

        Stage loginStage = new Stage();
        loginStage.getIcons().add(new Image("view/book.png"));
        loginStage.setX(ViewLoader.X);
        loginStage.setY(ViewLoader.Y);
        ViewLoader.showStage(model, "/view/login.fxml", "Sign In", loginStage);
        stage.close();
    }

    public void exit() {
        stage.close();
    }
}
