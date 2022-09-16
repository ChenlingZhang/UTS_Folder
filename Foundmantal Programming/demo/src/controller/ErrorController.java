package controller;

import au.edu.uts.ap.javafx.Controller;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.InputException;


public class ErrorController extends Controller<InputException> {

    @FXML
    private Label labelErrors;
//    @FXML
//    private ListView listView;
    @FXML
    public void initialize() {

        labelErrors.setText(model.getMessage());
        //listView.setItems(FXCollections.observableArrayList(model));
    }
    public void okay() {
        stage.close();
    }
}
