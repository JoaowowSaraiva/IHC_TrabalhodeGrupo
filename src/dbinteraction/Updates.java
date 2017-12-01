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
           String update="UPDATE Member SET FirstName=?,LastName=?,Birthday=? WHERE IdMembro=?";
           conn.pst=conn.con.prepareStatement(update);
           conn.pst.setString(1, nome);
           System.out.println(nome);
           conn.pst.setString(2, apelido);
           System.out.println(apelido);
           
           conn.pst.setString(3,data);
           System.out.println(data);
           
           conn.pst.setInt(4,Integer.parseInt(id));
           System.out.println(Integer.parseInt(id));
           conn.pst.execute();
    }
}
