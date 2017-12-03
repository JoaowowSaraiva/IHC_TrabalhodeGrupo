/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;



import Tabelas.Concert;
import Tabelas.Member;
import Tabelas.MembroNPresencas;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalhogrupo.ConnectDB.Connect;
/**
 *
 * @author Joao Saraiva
 */
public class Query {
    
    Connect conn = new Connect();

    public Query() {
    }
    
    public int maxIdConcerto() throws SQLException{
       conn.conexion();
        
        String result = new String();
        String query= "SELECT Max(IdConcert) FROM Concert";

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
    public List<String>selectConcerto(int status) throws SQLException{
        conn.conexion();
        List<String> list1=new ArrayList();
        String query="SELECT Concert.Local,Concert.DateHour,Concert.Payment\n" +
                     "FROM CONCERTINAS.Concert\n" +
                     "where Concert.status="+status+" order by Datehour DESC";
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        while(rs.next()){
            String x1=rs.getString("Local");
            String x2=rs.getString("Payment");
            Date d1=rs.getDate("DateHour");
            String x3=d1.toString();
            String x=String.format("%s|%s€|%s",x1,x2,x3);
            
            
            list1.add(x);
        }
        return list1;
        
    }
    public List<String>selectLocalConcerto(int id) throws SQLException{
        conn.conexion();
        List<String> list1=new ArrayList();
        String query="SELECT Concert.Local,Concert.DateHour\n" +
                     "FROM CONCERTINAS.Member_Concert,CONCERTINAS.Member,CONCERTINAS.Concert\n" +
                     "where Member_Concert.IdMember=Member.IdMembro and Concert.IdConcert=Member_Concert.IdConcert and Member.IdMembro="+id+" order by Datehour DESC";
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        while(rs.next()){
            String x1=rs.getString("Local");
            list1.add(x1);
        }
        return list1;
        
    }
    public List<String>selectDataConcerto(int id) throws SQLException{
        conn.conexion();
        List<String> list1=new ArrayList();
        String query="SELECT Concert.Local,Concert.DateHour\n" +
                     "FROM CONCERTINAS.Member_Concert,CONCERTINAS.Member,CONCERTINAS.Concert\n" +
                     "where Member_Concert.IdMember=Member.IdMembro and Concert.IdConcert=Member_Concert.IdConcert and Member.IdMembro="+id+" order by Datehour DESC";
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        while(rs.next()){
            
            Date d1=rs.getDate("DateHour");
     
            list1.add(d1.toString());
        }
        return list1;
        
    }
    
    public Member getMoreInfoFromName(String[] fullname) throws SQLException{
        conn.conexion();
        
        String query = "Select * From Member Where FirstName=" + '"' +fullname[0] + '"' + " AND LastName=" +'"' + fullname[1] + '"';
        
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        Member oM=null; 
        while(rs.next()){
            String x1 = rs.getString("FirstName");
            String x2 = rs.getString("LastName");
            Date d1 = rs.getDate("Birthday");
            String x3 = d1.toString();
            int x4 = rs.getInt("IdMembro");
            
            //System.out.println("TEste: " + x1+" "+ x2+" "+sx3+" id:"+x4);
            oM = new Member(x4,x1,x2,x3);
        }        
        
        return oM;
    }
    
    public List<String> selectVeiculo () throws SQLException{
          conn.conexion();
          List<String> list1 = new ArrayList();
          String query = "Select * From Vehicles";

          conn.pst=conn.con.prepareStatement(query);
          ResultSet rs = conn.pst.executeQuery();

          while(rs.next()){
              String matricula = rs.getString("NumberPlate");
              list1.add(matricula);
          }

          return list1;       
      }

}
