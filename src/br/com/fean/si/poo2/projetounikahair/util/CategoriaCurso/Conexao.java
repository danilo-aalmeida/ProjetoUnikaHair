
package br.com.fean.si.poo2.projetounikahair.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;


public class Conexao {
    
    public Connection pegarConexao(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/teste?user=root&password=root");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro na conexão - "+e);
        }
        return con;
        
    }
}
