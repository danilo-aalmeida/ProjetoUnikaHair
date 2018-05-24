package br.com.fean.si.poo2.projetounikahair.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fean.si.poo2.projetounikahair.dao.DAOException;
import br.com.fean.si.poo2.projetounikahair.dao.ExemploDAO;
import br.com.fean.si.poo2.projetounikahair.model.exemploVeppo.Exemplo;

public class JDBCExemploDAO extends AbstractJDBCDAO implements ExemploDAO {

	@Override
	public boolean cadastrarNovoRegistro(Exemplo exemplo) throws DAOException {
		String sql = "INSERT INTO EXEMPLO (NOME, VALOR) VALUES(?,?)";

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, exemplo.getNome());
			pstmt.setDouble(2, exemplo.getValor());
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Erro: Ao tentar adicionar um novo exemplo!");
			return false;
		} finally {
			close(pstmt);
			close(connection);
		}
		return true;
	}

	@Override
	public List<Exemplo> apresentarRegistrosPorFiltro(String filtro) throws DAOException {
		String sql = "select * from EXEMPLO where NOME like ? or ID = ? or VALOR = ?";

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Exemplo> registros = new ArrayList<>();

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, '%'+filtro+'%');
			pstmt.setInt(2, converterParaInteiro(filtro));
			pstmt.setDouble(3, converterParaDouble(filtro));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Integer codigo = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Double valor = rs.getDouble("VALOR");
				registros.add(new Exemplo(codigo, nome, valor));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Erro: Ao tentar adicionar um novo exemplo!");
		} finally {
			close(pstmt);
			close(connection);
		}
		return registros;
	}

	private Double converterParaDouble(String filtro) {
		try {
			return Double.valueOf(filtro);
		} catch (Exception e) {
			return 0d;
		}
	}

	private Integer converterParaInteiro(String filtro) {
		try {
			return Integer.valueOf(filtro);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Exemplo> apresentarTodosRegistros() throws DAOException {
		String sql = "select * from EXEMPLO";

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Exemplo> registros = new ArrayList<>();

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Integer codigo = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Double valor = rs.getDouble("VALOR");
				registros.add(new Exemplo(codigo, nome, valor));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Erro: Ao tentar adicionar um novo exemplo!");
		} finally {
			close(pstmt);
			close(connection);
		}
		return registros;
	}
}