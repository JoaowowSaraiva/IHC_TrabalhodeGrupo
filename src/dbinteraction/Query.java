/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import trabalhogrupo.ConnectDB.Connect;

/**
 *
 * @author Joao Saraiva
 */
public class Query {
    
    Connect conn = new Connect();

    public Query() {
    }
    
    public String teste () throws SQLException{
       conn.conexion();
        
        String result = new String();
        String query= "Select * From Member";

        conn.pst=conn.con.prepareStatement(query);
        //Statement stm=null;
             
        //stm = conn.con.createStatement();

        
        ResultSet rs = conn.pst.executeQuery();
        //ResultSet rs = stm.executeQuery(query);
        

        while(rs.next()){
            String x1 = rs.getString("FirstName");
            System.out.println(x1+ "\n");           
        }        
        return result;
        
    }
    
}
