/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private ListView<?> list;

    @FXML
    private Button close;

    @FXML
    private Label local;
    
     @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
   @FXML
   public void maisinformacao(String id) throws SQLException{
       Query q=new Query();
       String r=q.selectConcertoMais(Integer.parseInt(id));
        String[] a=r.split("[|]");
        local.setText(a[0]);
        datahora.setText(a[1]);
        if(a[2].equals(0.5)){
            duracao.setText("30 min");
        }
        if(a[2].equals(1.0)){
            duracao.setText("60 min");
        }
        if(a[2].equals(1.5)){
            duracao.setText("90 min");
        }
        if(a[2].equals(2.0)){
            duracao.setText("120 min");
        }
        pagamento.setText(a[3]);
        if(a[5].equals(1)){
            fatura.setText("Sim");
        }
        if(a[5].equals(0)){
            fatura.setText("Não");
        }
        veiculo.setText(q.selectVeiculoporid3(a[4]));
        
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
