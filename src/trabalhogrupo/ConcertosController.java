/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
public class ConcertosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    Button close;
    @FXML
    private ListView liste;
    @FXML
    Label mensagemerrod;
    @FXML
    Label mensagemerroe;
    @FXML
    private ListView listd;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            createContent();
        } catch (SQLException ex) {
            Logger.getLogger(ConcertosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public static class HBOXCell extends HBox {
        
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4= new Label();
        
        
        
        HBOXCell(String labelText,String labelText3,String labelId,String preco/*, String buttonText,String buttonText2,String espaco*/){
            super();
            
            label1.setText(labelText);
            HBox.setHgrow(label1, Priority.ALWAYS);
            label1.setMaxWidth(Double.MAX_VALUE);
          //  label2.setText(labelText2+"            ");
          label4.setText(preco+"       ");
          label2.setText(labelId);
          label2.setVisible(false);
            
            label3.setText(labelText3);

           // button.setText(buttonText);
           //label1.setText(espaco);
           // button2.setText(buttonText2);
            
        
            this.getChildren().addAll(label1,label4,label2,label3/*, button,label1,button2*/);
            
        }
        @Override
        public String toString(){
            
           return label2.getText();           
            
        }
       
        public String toString2(){
            
           return label1.getText();           
            
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
    void erro(int i) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("erroFXML.fxml"));
        Parent root=(Parent)loader.load();
        ErroFXMLController setControler=loader.getController();
        String x="direita";
        if(i==0){
            x="esquerda";
        }
        setControler.setERRO("Selecione um elemento da tabela da "+x+"!","", "", "", "");
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
            stage.setTitle("Erro de seleção!");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.show();
           
            
    }

    
    public void createContent() throws SQLException{
        //borderpane

        Query q = new Query();
        List<String> Pconcertos = q.selectConcerto(0);
        List<String> Hconcertos= q.selectConcerto(1);
                

        List<HBOXCell> list1 = new ArrayList();
         if(Pconcertos.size()==0){
             list1.add(new HBOXCell ("Sem Atuções para mostrar","","",""/*, "Mais Info","Editar","  "*/));
             listd.setMouseTransparent(true);
        }
        for (int i = 0; i < Pconcertos.size(); i++) {
            listd.setMouseTransparent(false);
            String x=Pconcertos.get(i);
            System.out.println(Pconcertos.get(i));
            String[] a=x.split("[|]");
            list1.add(new HBOXCell (a[0],a[2],a[3],""/*, "Mais Info","Editar","  "*/));
        }
        
        
         List<HBOXCell> list2 = new ArrayList();
         if(Hconcertos.size()==0){
             liste.setMouseTransparent(true);
             list2.add(new HBOXCell ("Sem Atuções para mostrar","","",""/*, "Mais Info","Editar","  "*/));
        }
        for (int i = 0; i < Hconcertos.size(); i++) {
            liste.setMouseTransparent(false);
            String t=Hconcertos.get(i);
            System.out.println(Pconcertos.get(i));
            String[] n=t.split("[|]");
            list2.add(new HBOXCell (n[0],n[2],n[3],n[1]/* "Mais Info","Editar","  "*/));
        }
        
        
        
        //ListView<HBOXCell> list = new ListView<HBOXCell>();
        ObservableList<HBOXCell> items = FXCollections.observableArrayList(list1);
        listd.setItems(items);
        
        ObservableList<HBOXCell> items2 = FXCollections.observableArrayList(list2);
        liste.setItems(items2);
        
    }
      @FXML
    private void MostrarItinerario(ActionEvent event) throws SQLException, IOException, URISyntaxException{
       
      HBOXCell hboxC =(HBOXCell) listd.getSelectionModel().getSelectedItem();
      
      //hboxC.toString();
      if(hboxC==null){
          erro(1);
          return;
      }
       mensagemerrod.setText("");
     
    
        System.out.println( hboxC.toString());
        String local = hboxC.toString2();
          System.out.println(local);

        String url="https://www.google.pt/maps/dir/Reboleiro/";
    
        String[] b=local.split(" ");
        for(int i=0;i<b.length;i++)
            if(i+1!=b.length)
                url=url+b[i]+"+";
            else{
                url=url+b[i]+"/";
            }
        Desktop d=Desktop.getDesktop();
        d.browse(new URI(url));
        
                
    
    }
    @FXML
     private void adicionaConcertoactivity (ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("ConcertoNovo.fxml"));
            Stage stage = new Stage();              
        
            Scene scene = new Scene(root);
            closeButtonAction();
            stage.setScene(scene);
            stage.setTitle("Adiciona Concerto");
            stage.setResizable(false);
            stage.show();
    }

   @FXML
    private void AddInfo(ActionEvent event) throws SQLException, IOException{
       
      ConcertosController.HBOXCell hboxC =(ConcertosController.HBOXCell) listd.getSelectionModel().getSelectedItem();
      
      //hboxC.toString();
      if(hboxC==null){
          erro(1);
          return;
      }
    
     
    
        System.out.println( hboxC.toString());
        String local = hboxC.toString();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("AtualizaConcerto.fxml"));
        Parent root=(Parent)loader.load();
        AtualizaConcertoController setControler=loader.getController();
        setControler.setidhide(local);
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        closeButtonAction();
        stage.setScene(scene);
            stage.setTitle("Adiciona Concerto");
            stage.setResizable(false);
            stage.show();
                
   
    }
    @FXML
    private void editar(ActionEvent event) throws SQLException, IOException{
       
      ConcertosController.HBOXCell hboxC =(ConcertosController.HBOXCell) liste.getSelectionModel().getSelectedItem();
      
      //hboxC.toString();
      if(hboxC==null){
          erro(0);
          return;
      }
    }
     @FXML
    private void maisinfo(ActionEvent event) throws SQLException, IOException{
       
      ConcertosController.HBOXCell hboxC =(ConcertosController.HBOXCell) liste.getSelectionModel().getSelectedItem();
      
      //hboxC.toString();
      if(hboxC==null){
          erro(0);
          return;
      }
    }
}