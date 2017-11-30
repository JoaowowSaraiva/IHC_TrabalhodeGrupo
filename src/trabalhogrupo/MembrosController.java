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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joao Saraiva
 */
public class MembrosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    ListView<HBOXCell> list = new ListView<HBOXCell>();
    @FXML
    Button close;
    
    
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
        Label label1=new Label();
        Button button = new Button();
        Button button2 = new Button();
        
        
        HBOXCell(String labelText/*, String buttonText,String buttonText2,String espaco*/){
            super();
            
            label.setText(labelText);
            HBox.setHgrow(label, Priority.ALWAYS);
            label.setMaxWidth(Double.MAX_VALUE);

           // button.setText(buttonText);
           //label1.setText(espaco);
           // button2.setText(buttonText2);
            
        
            this.getChildren().addAll(label/*, button,label1,button2*/);
            
        }
        
        @Override
        public String toString(){
            
           return label.getText();           
            
        }
      
              
    }
    
    
    public void createContent() throws SQLException{
        //borderpane

        Query q = new Query();
        List<String> names = q.selectNames();
        

        List<HBOXCell> list1 = new ArrayList();
        for (int i = 0; i < names.size(); i++) {
            list1.add(new HBOXCell (names.get(i)/*, "Mais Info","Editar","  "*/));
        }
        
        
        
        //ListView<HBOXCell> list = new ListView<HBOXCell>();
        ObservableList<HBOXCell> items = FXCollections.observableArrayList(list1);
        list.setItems(items);
        
    }
     @FXML
     private void adicionaMembroactivity (ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("novomembro.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            closeButtonAction();
            stage.setScene(scene);
            stage.setTitle("Adiciona Membro");
            stage.setResizable(false);
            stage.show();
    }
     @FXML
     private void estatistica (ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("Membrosatats.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Adiciona Membro");
            stage.setMinHeight(800);
            stage.setMinWidth(1000);
            
            stage.show();
    }
     
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    @FXML
    private void maisInfo(ActionEvent event) throws SQLException{
        
      HBOXCell hboxC = list.getSelectionModel().getSelectedItem();
      Query q = new Query();
      //hboxC.toString();
    
        System.out.println( hboxC.toString());
        String fullName = hboxC.toString();
        
        String[] parts = fullName.split(" ");
        String firstname = parts [0];
        String lastname = parts[1];
        
        
        System.out.println("Firstname: " + firstname + "Lastname: " + lastname);
        q.getMoreInfoFromName(parts);
    }
    
    
}

