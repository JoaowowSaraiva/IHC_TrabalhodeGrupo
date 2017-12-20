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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
 * @author smf_1
 */
public class VehiclesController implements Initializable {
  @FXML
    ListView <HBOXCell> list = new ListView<HBOXCell>();
    
    @FXML
    Label nome;
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
        Label Lid=new Label();
        
        
        HBOXCell(String labelText, String id){
            super();
            
            label.setText(labelText);
            HBox.setHgrow(label, Priority.ALWAYS);
            label.setMaxWidth(Double.MAX_VALUE);
            Lid.setText(id);
            Lid.setVisible(false);
            this.getChildren().addAll(label,Lid);
            
        }
        
        @Override
        public String toString(){
            
           return Lid.getText();           
            
        }
      
              
    }
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    @FXML
    private void adicionar() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("addveiculo.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            closeButtonAction();
            stage.setScene(scene);
            stage.setTitle("Adicionar Veiculo");
            stage.setResizable(false);
            stage.show();
    } 
    
     @FXML
    void erro() throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("erroFXML.fxml"));
        Parent root=(Parent)loader.load();
        ErroFXMLController setControler=loader.getController();
        setControler.setERRO("Selecione um elemento da tabela dos veiculos!","", "", "", "");
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
            stage.setTitle("Erro de seleção!");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.show();
           
            
    }
    
    @FXML
    private void editar() throws IOException, SQLException{
        if(list.getSelectionModel().getSelectedItem()==null){
            erro();
            return;
            
        }
        
        String id=list.getSelectionModel().getSelectedItem().toString();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("editarveiculo.fxml"));
        Parent root=(Parent)loader.load();
        
        EditarveiculoController setControler=loader.getController();
        setControler.inicio(id);
        
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        closeButtonAction();
        
        stage.setScene(scene);
            stage.setTitle("Grupo de Concertinas do Reboleiro - Editar Veiculo!");
            stage.setResizable(false);
            
            stage.show();
        
        
    }
    
    public void estatistica() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CarroAtuacao.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setTitle("Grupo de Concertinas do Reboleiro - Estatistica");
            
            stage.show();
    }
            
    
    
    
    public void createContent() throws SQLException{
        //borderpane

        Query q = new Query();
        List<String> names = q.selectVeiculoeID();
        

        List<HBOXCell> list1 = new ArrayList();
        for (int i = 0; i < names.size(); i++) {
            String []a=names.get(i).split(" ");
            list1.add(new HBOXCell (a[0],a[1]));
        }
        
        
        
        //ListView<HBOXCell> list = new ListView<HBOXCell>();
        ObservableList<HBOXCell> items = FXCollections.observableArrayList(list1);
        list.setItems(items);
        
        System.out.println( list.getItems().size());
    }
    
}
   