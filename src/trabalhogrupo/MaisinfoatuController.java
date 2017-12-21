/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class MaisinfoatuController implements Initializable {

    @FXML
    private Label veiculo;

    @FXML
    private Label fatura;

    @FXML
    private Label duracao;

    @FXML
    private Label datahora;

    @FXML
    private Label pagamento;

    @FXML
    private Button close;

    @FXML
    private Label local;
    @FXML
    ListView <MaisinfoatuController.HBOXCell> list = new ListView<MaisinfoatuController.HBOXCell>();
    
     @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
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
   @FXML
   public void maisinformacao(String id) throws SQLException{
       Query q=new Query();
       String r=q.selectConcertoMais(Integer.parseInt(id));
        String[] a=r.split("[|]");
        local.setText(a[0]);
        String[] b=a[1].split(" ");
        String[] c=b[1].split(":");
        datahora.setText(b[0]+" "+c[0]+":"+c[1]);
        if(a[2].equals("0.5")){
            duracao.setText("30 min");
        }
        if(a[2].equals("1.0")){
            duracao.setText("60 min");
        }
        if(a[2].equals("1.5")){
            duracao.setText("90 min");
        }
        if(a[2].equals("2.0")){
            duracao.setText("120 min");
        }
        pagamento.setText(a[3]);
        if(a[5].equals("1")){
            fatura.setText("Sim");
        }
        if(a[5].equals("0")){
            fatura.setText("Não");
        }
        veiculo.setText(q.selectVeiculoporid3(a[4]));
        
         List<String> nomeL=q.SelectNamesconcerto(Integer.parseInt(id));
         List<MaisinfoatuController.HBOXCell> list1 = new ArrayList();
       List<String> nomesja=new ArrayList();
        for(int j =0;j<nomeL.size();j++){
            String []d=nomeL.get(j).split(" ");
            list1.add(new MaisinfoatuController.HBOXCell (d[0]+" "+d[1],d[3]+"€"));
        }
        ObservableList<MaisinfoatuController.HBOXCell> items = FXCollections.observableArrayList(list1);
        list.setItems(items);
   }
        
       
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
