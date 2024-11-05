package com.example.demo4;

import com.almasb.fxgl.entity.action.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.demo4.ListaUzytkownikow.uzytkownicy;
import static java.lang.Integer.parseInt;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private Label info;
    @FXML
    private ComboBox<String> gender;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> genders = FXCollections.observableArrayList("Mężczyzna", "kobieta");
        gender.setItems(genders);
        gender.setValue("Nie chcę podawać");
    }
    @FXML
    protected void save(ActionEvent event) throws IOException {
        String namee = name.getText();
        int ageInt = 0;
        try {
            ageInt = parseInt(age.getText());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        String ageString = age.getText();
        String genderr = gender.getSelectionModel().getSelectedItem();
        Uzytkownik newUser = new Uzytkownik(namee, ageInt, genderr);
        if (namee.isEmpty()) {
            info.setText("Błąd: Imię nie może być puste!");
        } else if (ageString.isEmpty()) {
            info.setText("Błąd: Wiek musi być liczbą dodatnią!");
        } else if (ageInt <= 0) {
            info.setText("Błąd: Wiek musi być liczbą dodatnią!");
        } else {
            info.setText("Dane Zapisane pomyślnie");
            uzytkownicy.add(newUser);
            for (Uzytkownik e : uzytkownicy) {
                System.out.print(e + " \n");
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("second-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(loader.load());
            stage.setScene(scene);


            stage.show();

        }


    }
}