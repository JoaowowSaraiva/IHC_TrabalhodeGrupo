/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class AtualizaConcertoController implements Initializable {

    @FXML
    private Label veiculoe;

    @FXML
    private ComboBox veiculo;

    @FXML
    private Label faturae;

    @FXML
    private Label horae;

    @FXML
    private DatePicker data;

    @FXML
    private ComboBox hora;

    @FXML
    private ComboBox membros;

    @FXML
    private Label duracaoe;

    @FXML
    private Label locale;

    @FXML
    private ListView list;

    @FXML
    private TextField local;

    @FXML
    private BorderPane concelhoe;

    @FXML
    private TextField concelho;

    @FXML
    private ComboBox fatura;

    @FXML
    private ComboBox min;

    @FXML
    private Label datae;

    @FXML
    private Label pagamentoe;

    @FXML
    private ComboBox duracao;

    @FXML
    private TextField pagamento;

    @FXML
    private Button close;
    
    @FXML
    private Label idhide;
    
    @FXML
    public void setidhide(String value) throws SQLException{
        idhide.setText(value);
        idhide.setVisible(false);
        System.out.println(idhide.getText());
         Query q=new Query();
        String r=q.selectConcertoMais(Integer.parseInt(idhide.getText()));
        String[] a=r.split("[|]");
        
        local.setText(a[0]);
        String[]b=a[1].split(" ");
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(b[0],formatter);
        data.setValue(localDate);
        String c[]=b[1].split(":");
        hora.getSelectionModel().select(c[0]);
        min.getSelectionModel().select(c[1]);
        if(a[2].equals("0.5"))
            duracao.getSelectionModel().select(0);
        if(a[2].equals("1.0"))
            duracao.getSelectionModel().select(1);
        if(a[2].equals("1.5"))
            duracao.getSelectionModel().select(2);
        if(a[2].equals("2.0"))
            duracao.getSelectionModel().select(3);
        if(a[5].equals("1"))
            fatura.getSelectionModel().select(0);
        if(a[5].equals("0"))
            fatura.getSelectionModel().select(1);
        pagamento.setText(a[3]);
        if(!a[4].equals(" ")){
            int x=(Integer.parseInt(a[4]))-1;
            veiculo.getSelectionModel().select(x);
        }
        
        
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Query q=new Query();
        for(int j=0;j<24;j++){
        String x;
       if(j<10){
           x="0"+Integer.toString(j);
       }else{
           x=Integer.toString(j);
       }
       hora.getItems().add(j,x);
    }
    
        min.getItems().addAll("00","15","30","45");
        fatura.getItems().addAll("Sim","Nao");
        duracao.getItems().addAll("30","60","90","120");
        try {
            List<String>carros=q.selectVeiculo();
            for(int i=0;i<carros.size();i++){
                veiculo.getItems().add(i,carros.get(i));
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaConcertoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    
        
        
    
    
}
