/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class CarroAtuacaoController implements Initializable {

    @FXML
    PieChart pie;
     @FXML
    private Button close;
    
      @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Query q=new Query();
        try {
            List<String> resul=q.CarrosAtuacoes();
            ObservableList<PieChart.Data> list=FXCollections.observableArrayList();
            for(int i=0;i<resul.size();i++){
                String []x=resul.get(i).split(" ");
                list.add(new PieChart.Data(x[0],Integer.parseInt(x[1])));
            }
            pie.setData(list);
        } catch (SQLException ex) {
            Logger.getLogger(CarroAtuacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
}
