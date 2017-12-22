/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import Tabelas.TabelaS;
import dbinteraction.Query;
import dbinteraction.Updates;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class SalarioController implements Initializable {
    
    @FXML
    private TableView<TabelaS> tabela;

    @FXML
    private TableColumn<TabelaS,Double> tot;

    @FXML
    private ListView<SalarioController.HBOXCell> list;

    @FXML
    private Button close;

    @FXML
    private TableColumn<TabelaS, String> n;
    @FXML
    private Label nome;
    
    private List<TabelaS> listaS=new ArrayList();
    
    private ObservableList<TabelaS> obsList;
    
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
        setControler.setERRO("Selecione um elemento na tabela!","", "", "", "");
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
            stage.setTitle("Erro de seleção");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.show();
           
            
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
            
            this.getChildren().addAll(label,label2);
            
        }
        
        @Override
        public String toString(){
            
           return label2.getText();           
            
        
        }}
    
     public void atribuir(){
     n.setCellValueFactory(new PropertyValueFactory<>("nome"));
      tot.setCellValueFactory(new PropertyValueFactory<>("sal"));
        Query q=new Query();
        try {
            listaS=q.pagamento();
            obsList=FXCollections.observableArrayList(listaS);
            tabela.setItems(obsList);
        } catch (SQLException ex) {
            Logger.getLogger(SalarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      atribuir();
      
    }    
    
    public void detalhes() throws IOException{
        Query q=new Query();
        try{
            int i=tabela.getSelectionModel().getSelectedItem().getId();
            List<String> nomeL=q.VerAtuacoesPaga(i);
            List<SalarioController.HBOXCell> list1 = new ArrayList();
            
            for(int j =0;j<nomeL.size();j++){
                String []d=nomeL.get(j).split("[|]");
                list1.add(new SalarioController.HBOXCell (d[0],d[1]));
                
            }     
            ObservableList<SalarioController.HBOXCell> items = FXCollections.observableArrayList(list1);
            String aux2=nome.getText();
            nome.setText("Pagamento: "+tabela.getSelectionModel().getSelectedItem().getNome());
            list.setItems(items);
        }catch(Exception e){
            erro();
        }
    
    }
    
    public void pagar() throws IOException, SQLException{
            Updates U=new Updates();
            TabelaS aux=tabela.getSelectionModel().getSelectedItem();
            if(aux==null){
                erro();
                return;
                
            }
            int i=tabela.getSelectionModel().getSelectedItem().getId();
          
        
                
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação de Pagamento");
                alert.setHeaderText(null);
                alert.setContentText("Tem a certeza de efetuar o pagamento a "+aux.getNome()+"?");
                Optional<ButtonType> action=alert.showAndWait();

                    if(action.get()== ButtonType.OK){
                           U.pagamento(i);
                           atribuir();
                           
                    }
       
        
    }
    
}
