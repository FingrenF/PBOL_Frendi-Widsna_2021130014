/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pembelajaransejarah;

import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLInputHubunganController implements Initializable {

    @FXML
    private TableView<NegaraModel> tbvnegara;
    @FXML
    private TableView<KejadianModel> tbvkejadian;
    @FXML
    private TextArea txadeskripsi;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txthubungan;
    @FXML
    private TextField txtkodenegara;
    @FXML
    private TextField txtkodekejadian;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdatanegara();
        tbvnegara.getSelectionModel().selectFirst();
        txtkodenegara.setText(tbvnegara.getSelectionModel().getSelectedItem().getKodeNegara());
        showdatakejadian();
        tbvkejadian.getSelectionModel().selectFirst();
        txtkodekejadian.setText(tbvkejadian.getSelectionModel().getSelectedItem().getKodeKejadian());
    }    
    
    public void showdatanegara(){
        ObservableList<NegaraModel> datanegara=FXMLDocumentController.dtnegara.Load();
        if(datanegara!=null){            
            tbvnegara.getColumns().clear();            
            tbvnegara.getItems().clear();
            TableColumn col=new TableColumn("Kode Negara");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("kodeNegara"));
            tbvnegara.getColumns().addAll(col);
            
            col=new TableColumn("Nama Negara");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("namaNegara"));
            tbvnegara.getColumns().addAll(col);
            
            tbvnegara.setItems(datanegara);
            
    }else {  Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvnegara.getScene().getWindow().hide();

        }
    }
    
    public void showdatakejadian(){
        ObservableList<KejadianModel> datakejadian=FXMLDocumentController.dtkejadian.Load();
        if(datakejadian!=null){            
            tbvkejadian.getColumns().clear();            
            tbvkejadian.getItems().clear();
            TableColumn col=new TableColumn("Kode Kejadian");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("kodeKejadian"));
            tbvkejadian.getColumns().addAll(col);
            
            col=new TableColumn("Nama Kejadian");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("namaKejadian"));
            tbvkejadian.getColumns().addAll(col);
            
            tbvkejadian.setItems(datakejadian);
            
    }else {  Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvkejadian.getScene().getWindow().hide();

        }
    }
    
    @FXML
    private void simpanklik(ActionEvent event) {
        HubunganModel n = new HubunganModel();
        n.setKodeHubungan(txthubungan.getText());
        n.setKodeNegara(txtkodenegara.getText());
        n.setKodeKejadian(txtkodekejadian.getText());
        n.setDeskripsiHubungan(txadeskripsi.getText());
        
        FXMLDocumentController.dthubungan.setHubunganModel(n);
        if (FXMLDocumentController.dthubungan.insert()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Berhasil disimpan",ButtonType.OK);
            a.showAndWait();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data Gagal disimpan", ButtonType.OK);
            a.showAndWait();
        }
    }

    @FXML
    private void pilihnegara(MouseEvent event) {
        txtkodenegara.setText(tbvnegara.getSelectionModel().getSelectedItem().getKodeNegara());
    }

    @FXML
    private void pilihkejadian(MouseEvent event) {
        txtkodekejadian.setText(tbvkejadian.getSelectionModel().getSelectedItem().getKodeKejadian());
    }
    
}
