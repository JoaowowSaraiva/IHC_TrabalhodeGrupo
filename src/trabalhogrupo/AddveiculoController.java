/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Inserts;
import dbinteraction.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class AddveiculoController implements Initializable {

    @FXML
    private TextField m1;

    @FXML
    private TextField m2;

    @FXML
    private TextField m3;

    @FXML
    private ComboBox<String> membro;

    @FXML
    private Button close;
    
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
        setControler.setERRO("Elementos do formulário estão mal preenchidos!","Os elementos errados estão rodeados a vermelho!", "", "", "");
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
            stage.setTitle("Erro no formulário");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.show();
           
            
    }
    @FXML
    void add(ActionEvent event) throws IOException, SQLException{
        Query q=new Query();
        int flag=0;
        String css="-fx-border-color:red";
        
        if(m1.getText().length()!=2){
            flag=1;
            m1.setStyle(css);
        
        }else{m1.setStyle("");}
            
        if(m2.getText().length()!=2){
            m2.setStyle(css);
            flag=1;
             }else{m2.setStyle("");}
        
        if(m3.getText().length()!=2){
            m3.setStyle(css);
            flag=1;
        }else{m3.setStyle("");}
        
        if(membro.getSelectionModel().getSelectedItem()==null){
            membro.setStyle(css);
            flag=1;
        }else{membro.setStyle("");}
        
            
        if(flag==1){
           erro();
           return;
        }
        String matricula=m1.getText()+"-"+m2.getText()+"-"+m3.getText();
        
        String m=membro.getSelectionModel().getSelectedItem();
        String []ax=m.split(" ");
        int id=q.getidFrom(ax[0],ax[1]);
        int idv=q.maxIdVeiculo()+1;
        Inserts I=new Inserts();
        I.inserirVeiculo(idv, id, matricula);
        VeiculosActivity();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Query q=new Query();
        try {
            List<String> a=q.selectNames();
            for(int i=0;i<a.size();i++){
                membro.getItems().add(i, a.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddveiculoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

     @FXML
     private void VeiculosActivity() throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("Vehicles.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            closeButtonAction();
            stage.setScene(scene);
            stage.setTitle("Grupo De Concertinas do Reboleiro - Veículos");
            stage.setResizable(false);
            stage.show();
    }
    
}
