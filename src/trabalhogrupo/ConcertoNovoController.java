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
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class ConcertoNovoController implements Initializable {
    @FXML
    private Label conceloerro;

    @FXML
    private Button close;

    @FXML
    private DatePicker data;

    @FXML
    private ComboBox minuto;

    @FXML
    private ComboBox hora;

    @FXML
    private Label locale;

    @FXML
    private TextField local;

    @FXML
    private TextField concelho;

    @FXML
    private ComboBox fatura;

    @FXML
    private Label faturae;

    @FXML
    private Label duracaoe;

    @FXML
    private ComboBox<String> duracao;

    @FXML
    private Label horaerro;

    @FXML
    private Label dataerro;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    for(int j=0;j<24;j++){
        String x;
       if(j<10){
           x="0"+Integer.toString(j);
       }else{
           x=Integer.toString(j);
       }
       hora.getItems().add(j,x);
    }
    
    minuto.getItems().addAll("00","15","30","45");
    fatura.getItems().addAll("Sim","Nao");
    duracao.getItems().addAll("30","60","90","120");
    }    
    
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    @FXML
    private void adicionaConcerto() throws SQLException, IOException{
        Query q=new Query();
        int i=q.maxIdConcerto()+1;
        String local1=local.getText()+" "+concelho.getText();
        System.out.println(local1);
        LocalDate dat=data.getValue();
        String data=dat.toString()+"T";
        
        String h=hora.getSelectionModel().getSelectedItem().toString();
      
        String m=minuto.getSelectionModel().getSelectedItem().toString();
        data=data+h+":"+m+":00";
        System.out.println(data);
        String dur=duracao.getSelectionModel().getSelectedItem().toString();
        float x=(float) 0.0;
        if(dur.equals("30")){
            x=(float) 0.5;
        }if(dur.equals("60")){
            x=(float) 1.0;
        }if(dur.equals("90")){
            x=(float) 0.5;
        }if(dur.equals("120")){
            x=(float) 2.0;
        }
        System.out.println("duracao: "+x);
        String fat=fatura.getSelectionModel().getSelectedItem().toString();
        int fatura1=0;
        if(fat.equals("Sim")){
            fatura1=1;
        }
        Inserts I=new Inserts();
        I.inserirConcerto(i, local1, data, x, fatura1);
        Concertosactivity();
                
        
    }
     @FXML
     private void Concertosactivity () throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("membros.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            closeButtonAction();
            stage.setScene(scene);
            stage.setTitle("Membros");
            stage.setResizable(false);
            stage.show();
    }
}
