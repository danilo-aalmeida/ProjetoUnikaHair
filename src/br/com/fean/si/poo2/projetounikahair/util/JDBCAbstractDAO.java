package br.com.fean.si.poo2.projetounikahair.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JDBCAbstractDAO {

	private static final String DRIVER_JDBC = "com.mysql.jdbc.Driver";
	private static final String URL_JDBC = "jdbc:mysql://localhost:3306/UNIKA_HAIR?autoReconnect=true&useSSL=false";
	private static final String USER_JDBC = "root";
	private static final String PASSWORD_JDBC = "root";

	public Connection getConnection() {	

		try {
			Class.forName (DRIVER_JDBC);
			return DriverManager.getConnection(URL_JDBC, USER_JDBC, PASSWORD_JDBC);
		} catch (Exception e) {

			e.printStackTrace();
			System.exit(-1);
			return null;
		}
	}

	public void close (Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close (PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();			
			}
		}
	}

	public void close (ResultSet rs) {
		if ( rs != null) {
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