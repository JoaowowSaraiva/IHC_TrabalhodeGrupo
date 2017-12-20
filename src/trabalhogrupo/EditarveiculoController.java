/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Inserts;
import dbinteraction.Query;
import dbinteraction.Updates;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class EditarveiculoController implements Initializable {

     @FXML
    private TextField m1;

    @FXML
    private TextField m2;

    @FXML
    private TextField m3;

    @FXML
    private ComboBox<String> membro;

    @FXML
    private Label id;

    @FXML
    private Button close;
    
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
    void editar(ActionEvent event) throws SQLException, IOException {
      
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
        String matricula=null;
        if(id.getText().equals(4)){
            matricula=m1.getText()+m2.getText()+m3.getText();
        }else{
            matricula=m1.getText()+"-"+m2.getText()+"-"+m3.getText();
        }
        String m=membro.getSelectionModel().getSelectedItem();
        String []ax=m.split(" ");
        int id1=q.getidFrom(ax[0],ax[1]);
        
        Updates U=new Updates();
        System.out.println(matricula.length());
        U.editVeiculo(matricula,id1, Integer.parseInt(id.getText()));
        VeiculosActivity();
        
        
    
    }
     @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void inicio(String id1) throws SQLException{
        id.setVisible(false);
        id.setText(id1);
        char []letra=null;
        Query q=new Query();
        String info2=q.selectVeiculoporid2(id1);
        String []info=info2.split(" ");
        int x=0;
        String nome=q.selectNames3(info[1]);
            List<String> a=q.selectNames();
            for(int i=0;i<a.size();i++){
                membro.getItems().add(i, a.get(i));
                if(a.get(i).equals(nome))
                    x=i;
            }
            membro.getSelectionModel().select(x);
            if(id1.equals("4")){
                letra=info[0].toCharArray();
                m1.setText(""+letra[0]+letra[1]);
                m2.setText(""+letra[2]+letra[3]);
                m3.setText(""+letra[4]+letra[5]);
            }else{
                letra=info[0].toCharArray();
                m1.setText(""+letra[0]+letra[1]);
                m2.setText(""+letra[3]+letra[4]);
                m3.setText(""+letra[6]+letra[7]);
            }
     
    }
    
    
}
