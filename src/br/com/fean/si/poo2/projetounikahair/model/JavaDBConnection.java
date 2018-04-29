package br.com.fean.si.poo2.projetounikahair.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaDBConnection {
	
	private String stringConnection;
	
	
	
	public JavaDBConnection () throws ClassNotFoundException, SQLException {
		Class.forName ("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection ("");
		
		
	}
	

}
