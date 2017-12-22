/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;

import java.sql.SQLException;
import java.util.List;
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
            conn.conexion();
            
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
    public void editConcerto(int idConcerto,String Local,String data,float duracao,int status,int fatura,Double pagamento,int carro) throws SQLException{
            conn.conexion();
            
            String update="UPDATE `CONCERTINAS`.`Concert` SET `Local` =?,`DateHour` =?,`Duration` =?,`Status`=?,`Payment` =?,`IdVehicles` =?,`Fatura` = ? WHERE `IdConcert` =?";
            conn.pst=conn.con.prepareStatement(update);
            conn.pst.setString(1,Local);
            conn.pst.setString(2,data);
            conn.pst.setFloat(3, duracao);
            conn.pst.setInt(4,status);
            conn.pst.setDouble(5,pagamento);
            conn.pst.setInt(6, carro);
            conn.pst.setInt(7,fatura);
            conn.pst.setInt(8,idConcerto);
            conn.pst.execute();
            
    }
    
    public void editVeiculo(String placa,int idM,int idV) throws SQLException{
        conn.conexion();
        String update="UPDATE `CONCERTINAS`.`Vehicles` SET `NumberPlate` = ?, `idMember` = ? WHERE `IdVehicles` = ?";
        conn.pst=conn.con.prepareStatement(update);
        
        conn.pst.setString(1, placa);
        conn.pst.setInt(2, idM);
        conn.pst.setInt(3, idV);
        
        conn.pst.execute();
        
    }
    public void addelementosConcerto(int membros,int idConcerto) throws SQLException{
    conn.conexion();
          
                String addquery="INSERT INTO `CONCERTINAS`.`Member_Concert`(`IdMember`,`IdConcert`,`Status`)VALUES(?,?,?);";
                 conn.pst=conn.con.prepareStatement(addquery);
                 
                 conn.pst.setInt(1,membros);
                 conn.pst.setInt(2,idConcerto);
                 System.out.println(idConcerto);
                 conn.pst.setInt(3,0);
            
                 conn.pst.execute();
            }     
    public void addelementosConcerto1(int membros,int idConcerto, double pagamento) throws SQLException{
    conn.conexion();
          
                String addquery="INSERT INTO `CONCERTINAS`.`Member_Concert`(`IdMember`,`IdConcert`,`Status`,`Payment`)VALUES(?,?,?,?);";
                 conn.pst=conn.con.prepareStatement(addquery);
                 
                 conn.pst.setInt(1,membros);
                 conn.pst.setInt(2,idConcerto);
                 System.out.println(idConcerto);
                 conn.pst.setInt(3,0);
                  conn.pst.setDouble(4, pagamento);
            
                 conn.pst.execute();
            }     
     public void atribuirpaga(int membro,int idConcerto, double pagamento) throws SQLException{
    conn.conexion();
          
                String addquery="UPDATE `CONCERTINAS`.`Member_Concert` SET `Payment`=? WHERE `IdMember` =? AND `IdConcert` =?";
                 conn.pst=conn.con.prepareStatement(addquery);
                 conn.pst.setDouble(1, pagamento);
                 conn.pst.setInt(2,membro);
                 conn.pst.setInt(3, idConcerto);
               
                 
                 conn.pst.execute();
            }     
            
          public void pagamento(int membro) throws SQLException{
            conn.conexion();
          
                String addquery="UPDATE `CONCERTINAS`.`Member_Concert` SET `Status`=? WHERE `IdMember` =? and !isnull(Payment)";
                 conn.pst=conn.con.prepareStatement(addquery);
                 
                 conn.pst.setInt(1,1);
                 conn.pst.setInt(2, membro);
               
                 
                 conn.pst.execute();
            }   
          public void SetNULLPaga(int concerto) throws SQLException{
            conn.conexion();
          
                String addquery="UPDATE `CONCERTINAS`.`Member_Concert` SET `Payment`=NULL WHERE IdConcert=?";
                 conn.pst=conn.con.prepareStatement(addquery);
                 
                
                 conn.pst.setInt(1, concerto);
               
                 
                 conn.pst.execute();
            }   
            
    
    
    
    
}
