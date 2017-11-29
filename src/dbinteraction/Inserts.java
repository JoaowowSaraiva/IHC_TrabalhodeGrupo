/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbinteraction;

import java.sql.Date;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import trabalhogrupo.ConnectDB.Connect;

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
        String insert="INSERT INTO Member(FirstName,LastName,Birthday)VALUES(?,?,?,?)";
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
}
