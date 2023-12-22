/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pembelajaransejarah;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    public static DBNegara dtnegara = new DBNegara();
    public static DBKejadian dtkejadian = new DBKejadian();
    public static DBHubungan dthubungan = new DBHubungan();
    
    @FXML
    private MenuItem DisplayNegara;
    @FXML
    private MenuItem DisplayKejadian;
    @FXML
    private MenuItem InputNegara;
    @FXML
    private MenuItem InputKejadian;
    @FXML
    private MenuItem BelajarHubungan;
    @FXML
    private MenuItem simulasibelajar;
    @FXML
    private MenuItem jawabsoal;
    @FXML
    private MenuItem InputHubungan;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DisplayNegaraClick(ActionEvent event) {
        try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDisplayNegara.fxml"));    
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

    @FXML
    private void DisplayKejadianClick(ActionEvent event) {
         try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDisplayKejadian.fxml"));    
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

    @FXML
    private void InputNegaraClick(ActionEvent event) {
         try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputNegara.fxml"));    
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

    @FXML
    private void InputKejadianClick(ActionEvent event) {
         try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputKejadian.fxml"));    
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

    @FXML
    private void BelajarHubunganClick(ActionEvent event) {
        try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLHubungan.fxml"));    
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

    @FXML
    private void simulasibelajar(ActionEvent event) {
         try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLSimulasibelajar.fxml"));    
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

    @FXML
    private void jawabsoal(ActionEvent event) {
         try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLJawabSoal.fxml"));    
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

    @FXML
    private void InputHubunganKlik(ActionEvent event) {
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
