/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import trabalhogrupo.ConnectDB.Connect;

/**
 *
 * @author Joao Saraiva
 */
public class FXMLDocumentController implements Initializable {
    
    
    Connect con;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
       
        con.conexion();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con=new Connect();    }    

    
}
