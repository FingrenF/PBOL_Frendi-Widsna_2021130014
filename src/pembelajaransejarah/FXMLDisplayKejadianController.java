/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pembelajaransejarah;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLDisplayKejadianController implements Initializable {
    
    @FXML
    private TableView<KejadianModel> tbvkejadian;
    @FXML
    private Button btntambah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnubah;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnakhir;
    @FXML
    private TextField searchbar;
    @FXML
    private TextArea txadeskripsi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
        tbvkejadian.getSelectionModel().selectFirst();
        showDeskripsi();
    }    
    
    public void showdata(){
        ObservableList<KejadianModel> data=FXMLDocumentController.dtkejadian.Load();
        if(data!=null){            
            tbvkejadian.getColumns().clear();            
            tbvkejadian.getItems().clear();
            
            TableColumn col=new TableColumn("Kode Kejadian");
            col.setCellValueFactory(new PropertyValueFactory<KejadianModel, String>("kodeKejadian"));
            tbvkejadian.getColumns().addAll(col);
            col=new TableColumn("Nama Kejadian");
            col.setCellValueFactory(new PropertyValueFactory<KejadianModel, String>("namaKejadian"));
            tbvkejadian.getColumns().addAll(col);
            col=new TableColumn("Tahun Awal");
            col.setCellValueFactory(new PropertyValueFactory<KejadianModel, String>("tahunAwal"));
            tbvkejadian.getColumns().addAll(col);
            col=new TableColumn("Tahun AKhir");
            col.setCellValueFactory(new PropertyValueFactory<KejadianModel, String>("tahunAkhir"));
            tbvkejadian.getColumns().addAll(col);
            tbvkejadian.setItems(data);
        } else {  
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvkejadian.getScene().getWindow().hide();
        }                
    }
    
    @FXML
    private void tableklik(MouseEvent event) {
        showDeskripsi();
    }

    @FXML
    private void tambahklik(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputKejadian.fxml"));    
            Parent root = (Parent)loader.load();        
            Scene scene = new Scene(root);        
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);        
            stg.setIconified(false);        
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e){   
            e.printStackTrace();
        }
        showdata();        
        awalklik(event);
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        KejadianModel s= new KejadianModel();       
        s=tbvkejadian.getSelectionModel().getSelectedItem();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Mau dihapus?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
           if(FXMLDocumentController.dtkejadian.delete(s.getKodeKejadian())){
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
    private void ubahklik(ActionEvent event) {
        KejadianModel s= new KejadianModel();
        s=tbvkejadian.getSelectionModel().getSelectedItem();
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputKejadian.fxml"));    
            Parent root = (Parent)loader.load();
            FXMLInputKejadianController isidt=(FXMLInputKejadianController)loader.getController();
            isidt.execute(s);                
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e){   
            e.printStackTrace(); 
        }
        showdata();  
        awalklik(event);
    }

    @FXML
    private void awalklik(ActionEvent event) {
        tbvkejadian.getSelectionModel().selectFirst();
        showDeskripsi();
        tbvkejadian.requestFocus(); 
    }
    
    @FXML
    private void sesudahklik(ActionEvent event) {
        tbvkejadian.getSelectionModel().selectBelowCell();
        showDeskripsi();
        tbvkejadian.requestFocus();
    }

    @FXML
    private void akhirklik(ActionEvent event) {
        tbvkejadian.getSelectionModel().selectLast();   
        showDeskripsi();   
        tbvkejadian.requestFocus();  
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
        tbvkejadian.getSelectionModel().selectAboveCell();
        showDeskripsi();
        tbvkejadian.requestFocus();
    }

    @FXML
    private void cariData(KeyEvent event) {
         KejadianModel s = new KejadianModel();
        String key = searchbar.getText();
        if(key!=""){
        ObservableList<KejadianModel> data=FXMLDocumentController.dtkejadian.CariKejadian(key,key);
        if(data!=null){            
            tbvkejadian.getColumns().clear();
            tbvkejadian.getItems().clear();
            TableColumn col=new TableColumn("Kode Kejadian");
            col.setCellValueFactory(new PropertyValueFactory<KejadianModel, String>("kodeKejadian"));
            tbvkejadian.getColumns().addAll(col);
            col=new TableColumn("Nama Kejadian");
            col.setCellValueFactory(new PropertyValueFactory<KejadianModel, String>("namaKejadian"));
            tbvkejadian.getColumns().addAll(col);
            col=new TableColumn("Tahun Awal");
            col.setCellValueFactory(new PropertyValueFactory<KejadianModel, String>("tahunAwal"));
            tbvkejadian.getColumns().addAll(col);
            col=new TableColumn("Tahun AKhir");
            col.setCellValueFactory(new PropertyValueFactory<KejadianModel, String>("tahunAkhir"));
            tbvkejadian.getColumns().addAll(col);
            tbvkejadian.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvkejadian.getScene().getWindow().hide();;
        }            
            } else{
               showdata();
            }
    }
    public void showDeskripsi(){
        String deskripsi;
        deskripsi = tbvkejadian.getSelectionModel().getSelectedItem().getDeskripsi();
        txadeskripsi.setText(deskripsi);
    }
    
}
