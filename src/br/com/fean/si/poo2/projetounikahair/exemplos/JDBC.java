package br.com.fean.si.poo2.projetounikahair.exemplos;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
*
* @author jordan
*/
public class JDBC {

/**
* @param args the command line arguments
*/
public static void main(String[] args) throws ClassNotFoundException, SQLException {
// TODO code application logic here
//insert into teste (nome) values ('testando');
Class.forName ("com.mysql.jdbc.Driver");
Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/teste?user=root&password=root");

PreparedStatement ps = con.prepareStatement("INSERT INTO teste (nome) VALUES (?)"); 
ps.setString(1,"joao"); 
ps.execute ();
JOptionPane.showMessageDialog(null,"dado inserido");

}

}
