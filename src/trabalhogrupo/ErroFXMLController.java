/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class ErroFXMLController implements Initializable {
    @FXML
    private Label erro1;

    @FXML
    private Label erro2;

    @FXML
    private Label erro3;

    @FXML
    private Label erro4;

    @FXML
    private Label erro5;
    
    @FXML
    private Button close;
  
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    @FXML
    void setERRO(String a,String b,String c,String d,String e){
        erro1.setText(a);
        erro2.setText(b);
        erro3.setText(c);
        erro4.setText(d);
        erro5.setText(e);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
