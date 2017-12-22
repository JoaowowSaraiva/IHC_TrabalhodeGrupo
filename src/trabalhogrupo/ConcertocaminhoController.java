/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author smf_1
 */
public class ConcertocaminhoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private WebView map;
    @FXML
    Button close;
    
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    public void EnviaStringMapa(String a) throws IOException, URISyntaxException{
        String url="https://www.google.pt/maps/dir/Reboleiro/";
    
        String[] b=a.split(" ");
        for(int i=0;i<b.length;i++)
            if(i+1!=b.length)
                url=url+b[i]+"+";
            else{
                url=url+b[i]+"/";
            }
        Desktop d=Desktop.getDesktop();
        d.browse(new URI(url));
        map.getEngine().load(url);
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
