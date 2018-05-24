package br.com.fean.si.poo2.projetounikahair.dao;

import br.com.fean.si.poo2.projetounikahair.dao.jdbc.JDBCExemploDAO;

public class DAOFactory {
	
	public static ExemploDAO cadastreExemploDAO() {
		return new JDBCExemploDAO();
	}
}
