/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhogrupo.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author smf_1
 */
public class Connect {
     public Connection con=null;// responsavel por realizar a conccecao
    public ResultSet rs=null;//responsavel para armazenar o resutado da pesquisa
    public PreparedStatement pst=null;//responsavel para preparar o resultado da pesquisa
    
    public void conexion() {
        
            try {
            
            con=DriverManager.getConnection("jdbc:mysql://dbconcertinas.csf0273oa3yc.us-east-2.rds.amazonaws.com:3306/CONCERTINAS","admin","sergiojoaoihc");
           JOptionPane.showMessageDialog(null, "Conncetado com sucesso");
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,"Erro de conexao");
        } 
        
    }
}

