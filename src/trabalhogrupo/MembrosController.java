package trabalhogrupo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Tabelas.Member;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    
    @FXML
    Label mensagemerro;
    
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
            stage.setTitle("Membros - Adiciona Membro");
            stage.setResizable(false);
            stage.show();
    }
     @FXML
     private void estatistica (ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("Membrosatats.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Membros - Grafico de Presença em Atuações");
         
            
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
    void erro() throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("erroFXML.fxml"));
        Parent root=(Parent)loader.load();
        ErroFXMLController setControler=loader.getController();
        setControler.setERRO("Selecione um elemento da tabela dos Membros!","", "", "", "");
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
            stage.setTitle("Erro de seleção!");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.show();
           
            
    }
    
    @FXML
    private void maisInfo(ActionEvent event) throws SQLException, IOException{
       Member m=new Member();       
      HBOXCell hboxC = list.getSelectionModel().getSelectedItem();
      Query q = new Query();
      //hboxC.toString();
      if(hboxC==null){
          erro();
          return;
      }
       mensagemerro.setText("");
    
        System.out.println( hboxC.toString());
        String fullName = hboxC.toString();
        
        String[] parts = fullName.split(" ");
        String firstname = parts [0];
        String lastname = parts[1];
        
        
        
        m=q.getMoreInfoFromName(parts);
        //System.out.println("Firstname: " + m.getFirstName() + " Lastname: " + m.getLastName());
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Membromaisinfo.fxml"));
        Parent root=(Parent) loader.load();
        MembromaisinfoController setControler=loader.getController();
        setControler.recebeMembro(m);
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Membros - Mais informação");
        stage.setResizable(false);
        stage.show();
                
    
    }
    @FXML
    private void editar(ActionEvent event) throws SQLException, IOException{
       Member m=new Member();       
      HBOXCell hboxC = list.getSelectionModel().getSelectedItem();
      Query q = new Query();
      //hboxC.toString();
      if(hboxC==null){
          erro();
          return;
      }
       mensagemerro.setText("");
    
        System.out.println( hboxC.toString());
        String fullName = hboxC.toString();
        
        String[] parts = fullName.split(" ");
        String firstname = parts [0];
        String lastname = parts[1];
        
        
        
        m=q.getMoreInfoFromName(parts);
        //System.out.println("Firstname: " + m.getFirstName() + " Lastname: " + m.getLastName());
        FXMLLoader loader=new FXMLLoader(getClass().getResource("editarMembro.fxml"));
        Parent root=(Parent) loader.load();
        EditarMembroController setControler=loader.getController();
        setControler.editar(m);
        closeButtonAction();
        Stage stage=new Stage();
        
        stage.setTitle("Membros - Editar Membro");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
                
    
    }
}

