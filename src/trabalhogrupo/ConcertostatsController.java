/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import dbinteraction.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class ConcertostatsController implements Initializable {

    @FXML
    private LineChart<?, ?> grafico;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

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
        XYChart.Series series =new XYChart.Series();
        String x="";
        for(int i=1;i<=12;i++){
            if(i==1){
                x="Janeiro";
            }
            if(i==2){
                x="Fevereiro";
            }
            if(i==3){
                x="Março";
            }
            if(i==4){
                x="Abril";
            }
            if(i==5){
                x="Maio";
            }
            if(i==6){
                x="Junho";
            }
            if(i==7){
                x="Julho";
            }
            if(i==8){
                x="Agosto";
            }
            if(i==9){
                x="Setembro";
            }
            if(i==10){
                x="Outubro";
            }
            if(i==11){
                x="Novembro";
            }
            if(i==12){
                x="Dezembro";
            }

            try {
                
                series.getData().add(new XYChart.Data(x,q.veratuacaomes(i)));
              //  System.out.println("addicionar");
                        } catch (SQLException ex) {
                Logger.getLogger(ConcertostatsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        grafico.getData().addAll(series);
    }    
    
}
