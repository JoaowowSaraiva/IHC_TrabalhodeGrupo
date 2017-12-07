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
import java.sql.Time;
import java.sql.Timestamp;
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
    
      public List<String> selectNames2 () throws SQLException{
         conn.conexion();
        
        List<String> list1 = new ArrayList();
        String query = "Select * From Member";
        
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        
        while(rs.next()){
            String x1 = rs.getString("FirstName");
            String x2=rs.getString("LastName");
            String x0=rs.getString("IdMembro");
            list1.add(x1+" "+x2+" "+x0);
            //System.out.println(x1);
        }
        
     
        
        
        return list1;
    }
     public List<String> SelectNamesconcerto (int i) throws SQLException{
         conn.conexion();
        
        List<String> list1 = new ArrayList();
        String query = "SELECT IdMember,FirstName,LastName FROM CONCERTINAS.Member_Concert, CONCERTINAS.Member where Member_Concert.IdConcert="+i+" and Member.IdMembro=Member_Concert.IdMember;";
        
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        
        while(rs.next()){
            String x0=rs.getString("IdMember");
            String x1 = rs.getString("FirstName");
            String x2=rs.getString("LastName");
            list1.add(x1+" "+x2+" "+x0);
            //System.out.println(x1);
        }
        
        
        
        return list1;
    }
    public List<String>selectConcerto(int status) throws SQLException{
        conn.conexion();
        List<String> list1=new ArrayList();
        String query="SELECT Concert.IdConcert,Concert.Local,Concert.DateHour,Concert.Payment\n" +
                     "FROM CONCERTINAS.Concert\n" +
                     "where Concert.status="+status+" order by Datehour DESC";
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        while(rs.next()){
            String x1=rs.getString("Local");
            String x2=rs.getString("Payment");
            Date d1=rs.getDate("DateHour");
            int i=rs.getInt("IdConcert");
            String x4=String.valueOf(i);
            String x3=d1.toString();
            String x=String.format("%s|%s€|%s|%s",x1,x2,x3,x4);
            
            
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
     public String selectConcertoMais(int status) throws SQLException{
        conn.conexion();
       String x=null;
        String query="SELECT *\n" +
                     "FROM CONCERTINAS.Concert\n" +
                     "where IdConcert="+status+" order by Datehour DESC";
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
        while(rs.next()){
            String x1=rs.getString("Local");
                      
            Timestamp t=rs.getTimestamp("DateHour");
            String x3=t.toString();
            
             float dur=rs.getFloat("Duration");
            String x4=String.valueOf(dur);
            
            double pay=rs.getDouble("Payment");
         
            String x5;
            if(rs.wasNull()){
            x5=" ";
            
            }else{
              x5=String.valueOf(pay);
            }
            
            int v=rs.getInt("IdVehicles");
            String x7;
            if(rs.wasNull()){
            x7=" ";
            
            }else{
             x7=String.valueOf(v);
            }
            int f=rs.getInt("Fatura");
            String x8=String.valueOf(f);
          
             x=String.format("%s|%s|%s|%s|%s|%s",x1,x3,x4,x5,x7,x8);
            
            
            
        }
        return x;
        
    }
    public int getidFrom(String x,String y) throws SQLException{
        conn.conexion();
        
        String query = "Select * From Member Where FirstName=" + '"' +x + '"' + " AND LastName=" +'"' + y + '"';
        
        conn.pst=conn.con.prepareStatement(query);
        ResultSet rs = conn.pst.executeQuery();
         int x4=0;
        while(rs.next()){
            
          x4= rs.getInt("IdMembro");
            
            //System.out.println("TEste: " + x1+" "+ x2+" "+sx3+" id:"+x4);
           
        }        
        
        return x4;
    }
    

}
