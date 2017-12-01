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
public class Updates {
    Connect conn = new Connect();

    public Updates() {
    }
    
    public void updateIdMembro(String id,String nome,String apelido,String data) throws SQLException{
           String update="UPDATE Member SET FirstName=\""+nome+"\",LastName=\""+apelido+"\",Birthday=\""+data+"\"WHERE IdMembro="+id+" ";
           conn.pst=conn.con.prepareStatement(update);
           conn.pst.executeQuery();
    }
}
