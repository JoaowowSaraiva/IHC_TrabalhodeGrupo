/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;



import Tabelas.MembroNPresencas;
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
    
    public int maxIdMembro() throws SQLException{
       conn.conexion();
        
        String result = new String();
        String query= "SELECT Max(IdMembro) FROM Member";

        conn.pst=conn.con.prepareStatement(query);
        //Statement stm=null;
             
        //stm = conn.con.createStatement();
        ResultSet rs = conn.pst.executeQuery();
        //ResultSet rs = stm.executeQuery(query);
        while(rs.next()){
            return(rs.getInt(1));
        }        
        return 0;
        
    }
    public List<MembroNPresencas> presencas() throws SQLException{
        conn.conexion();
        
        List<MembroNPresencas> lista=new ArrayList();
        String query="SELECT FirstName,LastName, count(*) as conta FROM CONCERTINAS.Member_Concert,CONCERTINAS.Member\n" +
                        "where Member_Concert.IdMember=Member.IdMembro group by(Member.IdMembro);";
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs=conn.pst.executeQuery();
        while(rs.next()){
            
            String nome=rs.getString("FirstName")+" "+rs.getNString("LastName");
            int i=rs.getInt("conta");
            MembroNPresencas mp=new MembroNPresencas(nome, i);
            lista.add(mp);
            
        }
    
        return lista;
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
