/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import trabalhogrupo.ConnectDB.Connect;

/**
 *
 * @author Joao Saraiva
 */
public class FXMLDocumentController implements Initializable {
    
    
    Connect con;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        
       
        con.conexion();
        
        Query q = new Query();
        
        q.teste();
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con=new Connect();    }    

    
}
