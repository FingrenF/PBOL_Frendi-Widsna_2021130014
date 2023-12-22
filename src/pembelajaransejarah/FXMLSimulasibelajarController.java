/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pembelajaransejarah;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLSimulasibelajarController implements Initializable {

    @FXML
    private TableView<NegaraModel> tbvnegara;
    @FXML
    private TextArea txasejarahnegara;
    @FXML
    private Button btnkeluar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shownegara();
    }    
    
     public void shownegara(){
        ObservableList<NegaraModel> data=FXMLDocumentController.dtnegara.Load();
        if(data!=null){            
            tbvnegara.getColumns().clear();            
            tbvnegara.getItems().clear();
            
            TableColumn col=new TableColumn("Nama Negara");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("namaNegara"));
            tbvnegara.getColumns().addAll(col);
            tbvnegara.setItems(data);
        } else {  
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvnegara.getScene().getWindow().hide();
        }                
    }
    
    @FXML
    private void pilihnegara(MouseEvent event) {
        NegaraModel selectedNegara = tbvnegara.getSelectionModel().getSelectedItem();
        if (selectedNegara != null) {
        ObservableList<HubunganModel> hubunganList = DBHubungan.getInstance().getDescriptionsByNegara(selectedNegara);

        StringBuilder result = new StringBuilder();
        int number = 1;
        for (HubunganModel hubungan : hubunganList) {
            result.append(number).append(". ")
                    .append("Pada ").append(hubungan.getKejadianModel().getNamaKejadian())
                    .append(" ").append(hubungan.getDeskripsiHubungan())
                    .append("\n\n");
            number++;
        }

        txasejarahnegara.setText(result.toString());
    }
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }
    
}
