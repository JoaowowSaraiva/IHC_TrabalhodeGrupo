/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trabalhogrupo.ConnectDB.Connect;
import trabalhogrupo.MembrosController.HBOXCell;

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
    
    public List<String> selectNames () throws SQLException{
         conn.conexion();
        
        List<String> list1 = new ArrayList();
        String query = "Select * From Member";
        
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        
        while(rs.next()){
            String x1 = rs.getString("FirstName");
            String x2=rs.getString("LastName");
            list1.add(x1+" "+x2);
            //System.out.println(x1);
        }
        
        
        
        return list1;
    }
    
}
