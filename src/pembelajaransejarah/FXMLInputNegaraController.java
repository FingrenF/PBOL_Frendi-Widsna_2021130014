/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pembelajaransejarah;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLInputNegaraController implements Initializable {

    boolean editdata = false;
    @FXML
    private TextField txtkodenegara;
    @FXML
    private TextField txtnamanegara;
    @FXML
    private TextField txttahunditemukan;
    @FXML
    private TextField txtbendera;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtmasa;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void execute(NegaraModel d){
        if(!d.getKodeNegara().isEmpty()){
          editdata=true;
          txtkodenegara.setText(d.getKodeNegara());
          txtnamanegara.setText(d.getNamaNegara());          
          txttahunditemukan.setText(d.getTahunDitemukan());
            String masa;
            switch (d.getMasehi()) {
                case ("Masehi"):
                    masa = "true";
                    break;
                case ("Sebelum Masehi"):
                    masa = "false";
                    break;
                default:
                    throw new AssertionError();
            }
          txtmasa.setText(masa);
          txtbendera.setText(d.getBendera());          
          txtkodenegara.setEditable(false);          
          txtnamanegara.requestFocus();         
        }
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        txtkodenegara.setText("");        
        txtnamanegara.setText("");
        txttahunditemukan.setText(""); 
        txtbendera.setText("");
        txtkodenegara.requestFocus();
    }

    @FXML
    private void simpanklik(ActionEvent event) {
        NegaraModel n=new NegaraModel();        
        n.setKodeNegara(txtkodenegara.getText());
        n.setNamaNegara(txtnamanegara.getText());
        n.setTahunDitemukan(txttahunditemukan.getText());
        n.setMasa((txtmasa.getText()));
        n.setBendera(txtbendera.getText());
        
        FXMLDocumentController.dtnegara.setNegaraModel(n);
        if(editdata){
            if(FXMLDocumentController.dtnegara.update()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   
               txtkodenegara.setEditable(true);        
               hapusklik(event);                
            } else {               
                Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
                a.showAndWait(); 
            } }else if(FXMLDocumentController.dtnegara.validasi(n.getKodeNegara())<=0){
               if(FXMLDocumentController.dtnegara.insert()){
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
            txtkodenegara.requestFocus();
        }
    }
    
    
}
