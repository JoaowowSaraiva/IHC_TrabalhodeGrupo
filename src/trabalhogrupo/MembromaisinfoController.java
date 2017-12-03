package trabalhogrupo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Tabelas.Member;
import dbinteraction.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    @FXML
    Button close;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public static class HBOXCell extends HBox {
        
        Label label = new Label();
        Label label1=new Label();
        Button button = new Button();
        Button button2 = new Button();
        
        
        HBOXCell(String labelText,String labelText2/*, String buttonText,String buttonText2,String espaco*/){
            super();
            
            label.setText(labelText);
            HBox.setHgrow(label, Priority.ALWAYS);
            label.setMaxWidth(Double.MAX_VALUE);
            label1.setText(labelText2);

           // button.setText(buttonText);
           //label1.setText(espaco);
           // button2.setText(buttonText2);
            
        
            this.getChildren().addAll(label,label1/*, button,label1,button2*/);
            
        }
        
        @Override
        public String toString(){
            
           return label.getText();           
            
        }
      
              
    }
    
    
    public void createContent(int id) throws SQLException{
        //borderpane

        Query q = new Query();
        List<String> l = q.selectLocalConcerto(id);
        List<String> d = q.selectDataConcerto(id);
        
        

        List<HBOXCell> list1 = new ArrayList();
        if(l.size()==0)
            list1.add(new HBOXCell("Nenhuma Informação para mostrar",""));
        for (int i = 0; i < l.size(); i++) {
            String x1=l.get(i);
            String x2=d.get(i);
            
            list1.add(new HBOXCell (x1,x2/*, "Mais Info","Editar","  "*/));
        }
        
        
        
        //ListView<HBOXCell> list = new ListView<HBOXCell>();
        ObservableList<HBOXCell> items = FXCollections.observableArrayList(list1);
        listview.setItems(items);
        listview.setFocusTraversable( false );
        
    }
    public void recebeMembro(Member m) throws SQLException{
        apelido.setText(m.getLastName());
        data.setText(m.getBirthday());
        nome.setText(m.getFirstName());
        createContent(m.getIdMember());
        
    }
    @FXML
    private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) close.getScene().getWindow();
    // do what you have to do
    stage.close();
}

}
