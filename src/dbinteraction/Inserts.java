/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;


import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import trabalhogrupo.ConnectDB.Connect;
//bananas

/**
 *
 * @author Joao Saraiva
 */
public class Inserts {
    Connect conn = new Connect();

    public Inserts() {
    }
    public void inserirmembro(String Fname,String Lname, String data) throws SQLException{
        conn.conexion();
        String insert="INSERT INTO Member(FirstName,LastName,Birthday)VALUES(?,?,?)";
        conn.pst=conn.con.prepareStatement(insert);
        System.out.println("dps statment\n");
        conn.pst.setString(1,Fname);
        System.out.println("nome\n");
        conn.pst.setString(2,Lname);
        System.out.println("Ultimo\n");
        conn.pst.setString(3,data);
        System.out.println("data\n");
        
        conn.pst.execute();
        System.out.println("Execute");
                
    }
    public void inserirVeiculo(int id,int idmembro,String mat) throws SQLException{
        conn.conexion();
        String insert="INSERT INTO `CONCERTINAS`.`Vehicles`(`IdVehicles`,`NumberPlate`,`idMember`,`Part`)VALUES(?,?,?,?)";
        conn.pst=conn.con.prepareStatement(insert);
        conn.pst.setInt(1,id);
        conn.pst.setString(2, mat);
        conn.pst.setInt(3, idmembro);
        conn.pst.setInt(4,1);
        
        conn.pst.execute();
    
    }
    public void inserirConcerto(int id,String Local,String Data,float Duracao,int fatura) throws SQLException{
        conn.conexion();
        String insert="INSERT INTO `CONCERTINAS`.`Concert`(`IdConcert`,`Local`,`DateHour`,`Duration`,`Status`,`Fatura`) VALUES(?,?,?,?,?,?);";
        conn.pst=conn.con.prepareStatement(insert);
        conn.pst.setInt(1, id);
        conn.pst.setString(2, Local);
        conn.pst.setString(3, Data);
        conn.pst.setFloat(4, Duracao);
        conn.pst.setInt(5, 0);
        conn.pst.setInt(6, fatura);
        conn.pst.execute();
    
    
    }
}
