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
import java.util.AbstractList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

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
    ListView <AtualizaConcertoController.HBOXCell> list = new ListView<AtualizaConcertoController.HBOXCell>();

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
    private Label adicionar;
    @FXML
    private Label remover;
    @FXML
    Label erroremove;
    
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
        List<String> nomeL=q.SelectNamesconcerto(Integer.parseInt(idhide.getText()));
         List<AtualizaConcertoController.HBOXCell> list1 = new ArrayList();
       List<String> nomesja=new ArrayList();
        for(int j =0;j<nomeL.size();j++){
            String []d=nomeL.get(j).split(" ");
            list1.add(new AtualizaConcertoController.HBOXCell (d[0]+" "+d[1],d[2]));
            nomesja.add(d[2]);
        }      
        
        
        //ListView<HBOXCell> list = new ListView<HBOXCell>();
        ObservableList<AtualizaConcertoController.HBOXCell> items = FXCollections.observableArrayList(list1);
        list.setItems(items);
        int flag=0,pos=0;
        List<String> nomec=q.selectNames2();
        
        for(int i=0;i<nomec.size();i++){
           String []xi=nomec.get(i).split(" ");
           flag=0;
            for(int p=0;p<nomesja.size();p++)
                 if(nomesja.get(p).equals(xi[2]))
                     flag=1;
            
            if(flag==0){
            membros.getItems().add(pos,xi[0]+" "+xi[1]);
            pos++;
            }
                     
        }
        
    }
    
    
    public static class HBOXCell extends HBox {
        
        Label label = new Label();
        Label label2=new Label();
        
        
        HBOXCell(String labelText,String id){
            super();
            
            label.setText(labelText);
            HBox.setHgrow(label, Priority.ALWAYS);
            label.setMaxWidth(Double.MAX_VALUE);
            label2.setText(id);
            label2.setVisible(false);
            this.getChildren().addAll(label,label2);
            
        }
        
        @Override
        public String toString(){
            
           return label2.getText();           
            
        
        }}
        
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
    
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
   @FXML 
   public void adicionar() throws SQLException{
       Query q=new Query();
       int a=membros.getSelectionModel().getSelectedIndex();
       
       String x=membros.getSelectionModel().getSelectedItem().toString();
       membros.getItems().remove(a);
       String []name=x.split(" ");
       int i=q.getidFrom(name[0],name[1]);
       HBOXCell h=new AtualizaConcertoController.HBOXCell (x,String.valueOf(i));
       list.getItems().add(list.getItems().size(),h);
       String b=adicionar.getText();
       adicionar.setText(String.valueOf(i)+" "+b);

      }
   @FXML 
   public void remover() throws SQLException{
         HBOXCell hboxC =(HBOXCell) list.getSelectionModel().getSelectedItem();
         String x=hboxC.toString();
         System.out.println(x);
         if(x==null)
         {
             erroremove.setText("Escolha um Membro");
             return;
         }
         erroremove.setText("");
         int i=list.getSelectionModel().getSelectedIndex();
         list.getItems().remove(i);
         String b=remover.getText();
         remover.setText(String.valueOf(x)+" "+b);
         
   }
              
    }    

