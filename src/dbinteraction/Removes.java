/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import trabalhogrupo.ConnectDB.Connect;

/**
 *
 * @author Joao Saraiva
 */
public class Removes {
     Connect conn = new Connect();

    public Removes() {
    }
    public void ApagarMembro(List<String> membros,String id) throws SQLException{
        conn.conexion();
        for(int i=0;i<membros.size();i++){
        String query="DELETE FROM `CONCERTINAS`.`Member_Concert` WHERE Member_Concert.IdConcert=? and Member_Concert.IdMember=?";
        conn.pst=conn.con.prepareStatement(query);
        conn.pst.setInt(2, Integer.parseInt(membros.get(i)));
        conn.pst.setInt(1, Integer.parseInt(id));
        conn.pst.execute();
        }
    }
}
