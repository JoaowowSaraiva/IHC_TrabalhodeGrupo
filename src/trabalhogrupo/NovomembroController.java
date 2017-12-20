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
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import trabalhogrupo.ConnectDB.Connect;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class NovomembroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connect con;
    @FXML
    Label laste,firste,datae;
    @FXML
    TextField first;
    @FXML
    TextField last;
    @FXML
    DatePicker data;
    @FXML
    Button close;
    
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
     private void Membrosactivity () throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("membros.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            closeButtonAction();
            stage.setScene(scene);
            stage.setTitle("Membros");
            stage.setResizable(false);
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
    private void adicionaMembro(ActionEvent e) throws SQLException, IOException{
        Query q = new Query();
        int flag=0;
         String css="-fx-border-color:red";
        if(first.getText().equals("")){
           first.setStyle(css);
           flag=1;
            
        }else{
            first.setStyle("");
        }
        
        if(last.getText().equals("")){
            last.setStyle(css);
            flag=1;
        }else{
             last.setStyle("");
        }
        if(data.getValue()==null){
           data.setStyle(css);
            flag=1;
        }else{
           data.setStyle("");
        }
        
        if(flag==1){
            erro();
            return;
        }
        LocalDate dat=data.getValue();
        String data1=dat.toString();

        Inserts I=new Inserts();
        I.inserirmembro(first.getText(), last.getText(),data1);
        Membrosactivity();
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
