/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pembelajaransejarah;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLHubunganController implements Initializable {

    @FXML
    private TableView<HubunganModel> tbvhubungan;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnhapus;
    @FXML
    private TextArea txadeskripsi;
    @FXML
    private TextField txtkodehubungan;
    @FXML
    private Button btntambah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
        tbvhubungan.getSelectionModel().selectFirst();
        showDeskripsi();
    }    
    
     public void showdata(){
        ObservableList<HubunganModel> data=FXMLDocumentController.dthubungan.Load();
        if(data!=null){            
            tbvhubungan.getColumns().clear();            
            tbvhubungan.getItems().clear();
            
            TableColumn col=new TableColumn("Kode Hubungan");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("kodeHubungan"));
            tbvhubungan.getColumns().addAll(col);
            col=new TableColumn("Kode Negara");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("kodeNegara"));
            tbvhubungan.getColumns().addAll(col);
            col=new TableColumn("Kode Kejadian");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("kodeKejadian"));
            tbvhubungan.getColumns().addAll(col);
            col=new TableColumn("Deskrispi Hubungan");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("deskripsiHubungan"));
            tbvhubungan.getColumns().addAll(col);
            tbvhubungan.setItems(data);
        } else {  
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvhubungan.getScene().getWindow().hide();
        }                
    }
    
     public void showDeskripsi(){
        String deskripsi;
        deskripsi = tbvhubungan.getSelectionModel().getSelectedItem().getDeskripsiHubungan();
        txadeskripsi.setText(deskripsi);
    }
    
    @FXML
    private void pilihdata(MouseEvent event) {
        showDeskripsi();
    }

    @FXML
    private void awalklik(ActionEvent event) {
        tbvhubungan.getSelectionModel().selectFirst();
        showDeskripsi();
        tbvhubungan.requestFocus(); 
    }
    
    @FXML
    private void sesudahklik(ActionEvent event) {
        tbvhubungan.getSelectionModel().selectBelowCell();
        showDeskripsi();
        tbvhubungan.requestFocus();
    }

    @FXML
    private void akhirklik(ActionEvent event) {
        tbvhubungan.getSelectionModel().selectLast();   
        showDeskripsi();   
        tbvhubungan.requestFocus();  
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
        tbvhubungan.getSelectionModel().selectAboveCell();
        showDeskripsi();
        tbvhubungan.requestFocus();
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        HubunganModel s= new HubunganModel();       
        s=tbvhubungan.getSelectionModel().getSelectedItem();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Mau dihapus?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
           if(FXMLDocumentController.dthubungan.delete(s.getKodeHubungan())){
               Alert b=new Alert(Alert.AlertType.INFORMATION,"Data berhasil dihapus", ButtonType.OK);
               b.showAndWait();
           } else {
               Alert b=new Alert(Alert.AlertType.ERROR,"Data gagal dihapus", ButtonType.OK);
               b.showAndWait();               
           }    
           showdata();           
           awalklik(event);       
        }
    }
    
    

    @FXML
    private void cariData(KeyEvent event) {
        HubunganModel s = new HubunganModel();
        String key = txtkodehubungan.getText();
        if(key!=""){
        ObservableList<HubunganModel> data=FXMLDocumentController.dthubungan.CariHubungan(key);
        if(data!=null){            
            tbvhubungan.getColumns().clear();            
            tbvhubungan.getItems().clear();
            
            TableColumn col=new TableColumn("Kode Hubungan");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("kodeHubungan"));
            tbvhubungan.getColumns().addAll(col);
            col=new TableColumn("Kode Negara");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("kodeNegara"));
            tbvhubungan.getColumns().addAll(col);
            col=new TableColumn("Kode Kejadian");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("kodeKejadian"));
            tbvhubungan.getColumns().addAll(col);
            col=new TableColumn("Deskrispi Hubungan");
            col.setCellValueFactory(new PropertyValueFactory<HubunganModel, String>("deskripsiHubungan"));
            tbvhubungan.getColumns().addAll(col);
            tbvhubungan.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvhubungan.getScene().getWindow().hide();
        }            
            } else{
               showdata();
            }
    }

    @FXML
    private void tambahklik(ActionEvent event) {
        try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputHubungan.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    
}
