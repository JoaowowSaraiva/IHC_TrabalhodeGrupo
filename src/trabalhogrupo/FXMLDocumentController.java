/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
       
         
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con=new Connect();    }    

    


    @FXML
    private void funcaoMudaActivity (ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("membros.fxml"));
            Stage stage = new Stage();              
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
    }

}  
