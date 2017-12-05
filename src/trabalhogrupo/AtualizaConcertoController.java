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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class AtualizaConcertoController implements Initializable {

    @FXML
    private Label veiculoe;

    @FXML
    private ComboBox veiculo;

    @FXML
    private Label faturae;

    @FXML
    private Label horae;

    @FXML
    private DatePicker data;

    @FXML
    private ComboBox hora;

    @FXML
    private ComboBox membros;

    @FXML
    private Label duracaoe;

    @FXML
    private Label locale;

    @FXML
    private ListView list;

    @FXML
    private TextField local;

    @FXML
    private BorderPane concelhoe;

    @FXML
    private TextField concelho;

    @FXML
    private ComboBox<?> fatura;

    @FXML
    private ComboBox<?> min;

    @FXML
    private Label datae;

    @FXML
    private Label pagamentoe;

    @FXML
    private ComboBox<?> duracao;

    @FXML
    private TextField pagamento;

    @FXML
    private Button close;
    
    @FXML
    private Label idhide;
    
    @FXML
    public void setidhide(String value){
        idhide.setText(value);
        idhide.setVisible(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
