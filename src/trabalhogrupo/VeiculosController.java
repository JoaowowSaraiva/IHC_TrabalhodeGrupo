/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author Joao Saraiva
 */
public class VeiculosController implements Initializable {

    @FXML
    ListView<HBOXCell> list = new ListView<HBOXCell>();
    
    @FXML
    Label nome;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
     
            createContent();
        } catch (SQLException ex) {
            Logger.getLogger(MembrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    
    public static class HBOXCell extends HBox {
        
        Label label = new Label();
        
        
        HBOXCell(String labelText){
            super();
            
            label.setText(labelText);
            HBox.setHgrow(label, Priority.ALWAYS);
            label.setMaxWidth(Double.MAX_VALUE);

            this.getChildren().addAll(label);
            
        }
        
        @Override
        public String toString(){
            
           return label.getText();           
            
        }
      
              
    }
    
    
    public void createContent() throws SQLException{
        //borderpane

        Query q = new Query();
        List<String> names = q.selectVeiculo();
        

        List<HBOXCell> list1 = new ArrayList();
        for (int i = 0; i < names.size(); i++) {
            list1.add(new HBOXCell (names.get(i)));
        }
        
        
        
        //ListView<HBOXCell> list = new ListView<HBOXCell>();
        ObservableList<HBOXCell> items = FXCollections.observableArrayList(list1);
        list.setItems(items);
        
    }
}
