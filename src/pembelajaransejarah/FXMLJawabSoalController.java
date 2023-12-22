/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pembelajaransejarah;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLJawabSoalController implements Initializable {

   @FXML
    private ComboBox<String> jawaban1;
    @FXML
    private ComboBox<String> jawaban2;
    @FXML
    private ComboBox<String> jawaban3;
    @FXML
    private ComboBox<String> jawaban4;
    @FXML
    private ComboBox<String> jawaban5;
    @FXML
    private Button btnsubmit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize unique answer choices for each question
        initializeAnswerChoices();
    }

    private void initializeAnswerChoices() {
        // Sample data for unique answer choices
        jawaban1.getItems().addAll("Jepang memerdekakan Indonesia",
                                    "Jepang menguasai Asia",
                                    "Jepang Mengalami Kekalahan besar",
                                    "Jepang melakukan gencatan senjata dengan Amerika",
                                    "Jepang menjadi pemimpin Axis");
        jawaban2.getItems().addAll("Revolusi Industri",
                                    "Perubahan ekonomi di China",
                                    "Keterlibatan Amerika dalam perang",
                                    "Perubahan politik di Jerman",
                                    "Kolaborasi Rusia dalam penjelajahan antariksa");
        jawaban3.getItems().addAll("Brasil","China","Indonesia","Australia","Jepang");
        jawaban4.getItems().addAll("1945", "1957", "1910", "1861", "1776");
        jawaban5.getItems().addAll("Peluncuran satelit pertama",
                                    "Kolaborasi dengan Uni Soviet",
                                    "Membangun pesawat luar angkasa pertama",
                                    "Menjadi negara pertama di luar angkasa",
                                    "Mengembangkan teknologi antariksa");
    }

    @FXML
    private void submitklik() {
        // Create a map to store user-selected answers
        Map<Integer, String> userAnswers = new HashMap<>();

        // Retrieve selected answers from ComboBoxes
        userAnswers.put(1, jawaban1.getValue());
        userAnswers.put(2, jawaban2.getValue());
        userAnswers.put(3, jawaban3.getValue());
        userAnswers.put(4, jawaban4.getValue());
        userAnswers.put(5, jawaban5.getValue());

        // Calculate marks using DBJawaban
        int marks = DBJawaban.calculateMarks(userAnswers);

        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Nilai");
            alert.setHeaderText(null);
            alert.setContentText("Nilai: " + marks);
            alert.showAndWait();
    }
    
}
