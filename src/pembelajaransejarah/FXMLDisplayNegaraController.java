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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLDisplayNegaraController implements Initializable {

    @FXML
    private TableView<NegaraModel> tbvnegara;
    @FXML
    private ImageView imgbendera;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
        tbvnegara.getSelectionModel().selectFirst();
        showBendera();
    }    
    public void showdata(){
        ObservableList<NegaraModel> data=FXMLDocumentController.dtnegara.Load();
        if(data!=null){            
            tbvnegara.getColumns().clear();            
            tbvnegara.getItems().clear();
            
            TableColumn col=new TableColumn("Kode Negara");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("kodeNegara"));
            tbvnegara.getColumns().addAll(col);
            col=new TableColumn("Nama Negara");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("namaNegara"));
            tbvnegara.getColumns().addAll(col);
            col=new TableColumn("Tahun Ditemukan");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("tahunDitemukan"));
            tbvnegara.getColumns().addAll(col);
            col=new TableColumn("Masehi");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("masehi"));
            tbvnegara.getColumns().addAll(col); 
//            col=new TableColumn("Bendera");
//            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("bendera"));
//            tbvnegara.getColumns().addAll(col);
            tbvnegara.setItems(data);
        } else {  
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvnegara.getScene().getWindow().hide();
        }                
    }
    @FXML
    private void tambahklik(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputNegara.fxml"));    
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
        NegaraModel s= new NegaraModel();       
        s=tbvnegara.getSelectionModel().getSelectedItem();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Mau dihapus?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
           if(FXMLDocumentController.dtnegara.delete(s.getKodeNegara())){
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
        NegaraModel s= new NegaraModel();
        s=tbvnegara.getSelectionModel().getSelectedItem();
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputNegara.fxml"));    
            Parent root = (Parent)loader.load();
            FXMLInputNegaraController isidt=(FXMLInputNegaraController)loader.getController();
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
        tbvnegara.getSelectionModel().selectFirst();
        showBendera();
        tbvnegara.requestFocus(); 
    }
    
    @FXML
    private void sesudahklik(ActionEvent event) {
        tbvnegara.getSelectionModel().selectBelowCell(); 
        showBendera();
        tbvnegara.requestFocus();
    }

    @FXML
    private void akhirklik(ActionEvent event) {
        tbvnegara.getSelectionModel().selectLast();      
        showBendera();
        tbvnegara.requestFocus();  
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
        tbvnegara.getSelectionModel().selectAboveCell();
        showBendera();
        tbvnegara.requestFocus();
    }

    

    @FXML
    private void cariData(KeyEvent event) {
         NegaraModel s = new NegaraModel();
        String key = searchbar.getText();
        if(key!=""){
        ObservableList<NegaraModel> data=FXMLDocumentController.dtnegara.CariBrg(key,key);
        if(data!=null){            
            tbvnegara.getColumns().clear();
            tbvnegara.getItems().clear();
            TableColumn col=new TableColumn("Kode Negara");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("kodeNegara"));
            tbvnegara.getColumns().addAll(col);
            col=new TableColumn("Nama Negara");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("namaNegara"));
            tbvnegara.getColumns().addAll(col);
            col=new TableColumn("Tahun Ditemukan");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("tahunDitemukan"));
            tbvnegara.getColumns().addAll(col);
            col=new TableColumn("Masa Ditemukan");
            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("masehi"));
            tbvnegara.getColumns().addAll(col);
//            col=new TableColumn("Bendera");
//            col.setCellValueFactory(new PropertyValueFactory<NegaraModel, String>("bendera"));
//            tbvnegara.getColumns().addAll(col);
            tbvnegara.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvnegara.getScene().getWindow().hide();;
        }            
            } else{
               showdata();
            }        
    }
    
    public void showBendera(){
        Image gambar = null;
        try {
            gambar = new Image(new FileInputStream(tbvnegara.getSelectionModel().getSelectedItem().getBendera()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDisplayNegaraController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        imgbendera.setImage(gambar);
    }

    @FXML
    private void tableklik(MouseEvent event) {
        showBendera();
    }
}
