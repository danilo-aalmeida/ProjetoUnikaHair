package br.com.fean.si.poo2.projetounikahair.exemplos;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

 class JDBC {

    
    public JDBC(){
        retornar();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        //insert into teste (nome) values ('testando');
        new JDBC();

    }
    /**
     * 
     */
    public void retornar(){
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/teste?useSSL=false","root","");

            PreparedStatement ps =  con.prepareStatement("select * from promocao ORDER BY NOME ASC"); 	
            ResultSet rs = ps.executeQuery ();
            while (rs.next()){
                JOptionPane.showMessageDialog(null,"nome: "+rs.getString("nome") + " Descricao: "+rs.getString("descricao"));
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro "+e);
        }
        
    }
    public void inserir(){
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/teste","root","");

            PreparedStatement ps = con.prepareStatement("INSERT INTO promocao (nome,descricao) VALUES (?,?)"); 
    		ps.setString(1,"joao"); 
    		ps.setString(2,"descricao");
    		ps.execute ();
            JOptionPane.showMessageDialog(null,"dado inserido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro"+e);
        }
        
    }
    
}
