package br.com.fean.si.poo2.projetounikahair.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractJDBCDAO {
	
	public static final String DRIVER_JDBC = "com.mysql.jdbc.Driver";
	public static final String URL_JDBC = "jdbc:mysql://localhost:3306/brincadeira?autoReconnect=true&useSSL=false";
	public static final String USER_JDBC = "root";
	public static final String PASSWORD_JDBC = "padrao";
	
	public Connection getConnection() {
		try {
			Class.forName(DRIVER_JDBC);
			return DriverManager.getConnection(URL_JDBC, USER_JDBC,
					PASSWORD_JDBC);
		} catch (Exception e) {
			System.err.println("Erro ao conectar ao banco de dados");
			e.printStackTrace();
			System.err.println("A aplicacao sera finalizada");
			System.exit(-1);
			return null;
		}	
	}
	public void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public java.sql.Date converterUtilDateToSQLDate(java.util.Date data){
		return new java.sql.Date(data.getTime());
	}
	public java.util.Date converterSQLDateToUtilDate(java.sql.Date data){
		return new java.util.Date(data.getTime());
	}

}
