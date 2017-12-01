/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import Tabelas.Member;
import dbinteraction.Inserts;
import dbinteraction.Query;
import dbinteraction.Updates;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class EditarMembroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField last;
    @FXML
    private DatePicker data;
    @FXML
    private Button close;
    @FXML
    private TextField first;
     @FXML
    private Label laste;

    @FXML
    private Label datae;

    @FXML
    private Label firste;
    
    @FXML
    private Label idhide;
    
   
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void editar(Member m){
        first.setText(m.getFirstName());
        last.setText(m.getLastName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(m.getBirthday(), formatter);
        data.setValue(localDate);
        
        idhide.setText(Integer.toString(m.getIdMember()));
        idhide.setVisible(false);
        
    }
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
     @FXML
     private void Mactivity () throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("membros.fxml"));
            Stage stage = new Stage();              
            
            Scene scene = new Scene(root);
            closeButtonAction();
            stage.setScene(scene);
            stage.setTitle("Editar Membro");
            stage.setResizable(false);
            stage.show();
    }
    @FXML
    private void EditarMembro(ActionEvent e) throws SQLException, IOException{
        Query q = new Query();
        
        
        if(first.getText().equals("")){
            firste.setText("Preencha esta campo!");
            
        }else{
            firste.setText("");
        }
        
        if(last.getText().equals("")){
            laste.setText("Preencha esta campo!");
            
        }else{
            laste.setText("");
        }
        if(data.getValue()==null){
            datae.setText("Preencha esta campo!");
        }else{
            datae.setText("");
        }
        
        if(data.getValue()==null||last.getText().equals("")||first.getText().equals("")){
            return;
        }
        LocalDate dat=data.getValue();
        String data1=dat.toString();
        
        
        Updates U=new Updates();
        
        U.updateIdMembro(idhide.getText(),first.getText(), last.getText(),data1);
        Mactivity();
       
    }
    
}
