/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import Tabelas.Member;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class MembromaisinfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private Label apelido;

    @FXML
    private Label data;

    @FXML
    private ListView listview;

    @FXML
    private Label nome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void recebeMembro(Member m){
        apelido.setText(m.getLastName());
        data.setText(m.getBirthday());
        nome.setText(m.getFirstName());
    }
}
