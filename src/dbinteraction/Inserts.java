/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;

import java.sql.SQLException;
import trabalhogrupo.ConnectDB.Connect;

/**
 *
 * @author Joao Saraiva
 */
public class Inserts {
    Connect conn = new Connect();

    public Inserts() {
    }
    public void inserirmembro(String Fname,String Lname) throws SQLException{
        conn.conexion();
        String insert="INSERT INTO `CONCERTINAS`.`Member` (`FirstName`,`LastName`,`Birthday`) VALUES(?,?,?,?)";
        conn.pst=conn.con.prepareStatement(insert);
       
        
    }
}
