/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import Tabelas.MembroNPresencas;
import dbinteraction.Query;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class MembrosatatsController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private BarChart<String,Integer> grafico;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    Button close;

    
    public void preencher() throws SQLException{
        Query q=new Query();
        List<String> l =q.selectNames();
        List<MembroNPresencas> lista=q.presencas();
        
    
    
   
    XYChart.Series<String, Integer> series = new XYChart.Series<>(); 
    for(int i=0;i<lista.size();i++){
        series.getData().add(new XYChart.Data<>(lista.get(i).getNome(),lista.get(i).getNumero()));
    
    }
    grafico.getData().addAll(series);
   
    }
    
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            preencher();
        } catch (SQLException ex) {
            Logger.getLogger(MembrosatatsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
