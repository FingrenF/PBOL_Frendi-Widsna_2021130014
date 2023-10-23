/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pembelajaransejarah;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLInputKejadianController implements Initializable {

    boolean editdata = false;
    @FXML
    private TextField txtkodekejadian;
    @FXML
    private TextField txtnamakejadian;
    @FXML
    private TextField txttahunawal;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txttahunakhir;
    @FXML
    private TextArea txadeskripsi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(KejadianModel d){
        if(!d.getKodeKejadian().isEmpty()){
          editdata=true;
          txtkodekejadian.setText(d.getKodeKejadian());
          txtnamakejadian.setText(d.getNamaKejadian());          
          txttahunawal.setText(d.getTahunAwal());
          txttahunakhir.setText(d.getTahunAkhir());
          txadeskripsi.setText(d.getDeskripsi());
          txtkodekejadian.setEditable(false);          
          txtnamakejadian.requestFocus();         
        }
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        txtkodekejadian.setText("");        
        txtnamakejadian.setText("");
        txttahunawal.setText(""); 
        txttahunakhir.setText(""); 
        txadeskripsi.setText("");
        txtkodekejadian.requestFocus();
    }

    @FXML
    private void simpanklik(ActionEvent event) {
        KejadianModel n=new KejadianModel();        
        n.setKodeKejadian(txtkodekejadian.getText());
        n.setNamaKejadian(txtnamakejadian.getText());
        n.setTahunAwal(txttahunawal.getText());
        n.setTahunAkhir((txttahunakhir.getText()));
        n.setDeskripsi(txadeskripsi.getText());
        
        FXMLDocumentController.dtkejadian.setKejadianModel(n);
        if(editdata){
            if(FXMLDocumentController.dtkejadian.update()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   
               txtkodekejadian.setEditable(true);        
               hapusklik(event);                
            } else {               
                Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
                a.showAndWait(); 
            } }else if(FXMLDocumentController.dtkejadian.validasi(n.getKodeKejadian())<=0){
               if(FXMLDocumentController.dtkejadian.insert()){
                    Alert a = new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
                    a.showAndWait();            
                    hapusklik(event);
            } else {
               Alert a = new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtkodekejadian.requestFocus();
        }
    }
    
}
