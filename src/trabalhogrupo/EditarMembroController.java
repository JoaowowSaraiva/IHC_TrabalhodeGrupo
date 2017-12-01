/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;

import Tabelas.Member;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class EditarMembroController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField last;

  
    @FXML
    private DatePicker data;

    @FXML
    private Button close;

    

    @FXML
    private TextField first;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void editar(Member m){
        first.setText(m.getFirstName());
        last.setText(m.getLastName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(m.getBirthday(), formatter);
        data.setValue(localDate);
        
    }
    
}
