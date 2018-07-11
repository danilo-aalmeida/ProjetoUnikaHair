package br.com.fean.si.poo2.projetounikahair.dao.boleto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.dao.DAOException;
import br.com.fean.si.poo2.projetounikahair.dao.JDBCAbstractDAO;
import br.com.fean.si.poo2.projetounikahair.model.boleto.Boleto;

public class JDBCBoletoDAO extends JDBCAbstractDAO implements BoletoDAO {

	public String cadastrarNovoBoleto(Boleto boleto) throws DAOException {

		String insertSQL = "INSERT INTO BOLETO (COD_BANCO,NOME_BANCO, NUMERO_CONTA,MENSAGEM_CLIENTE) VALUE (?,?,?,?);";
		Connection connection = null;
		PreparedStatement pstmt = null;
		String retorno = "Boleto cadastrado com sucesso";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setInt(1, boleto.getCodigoBanco());
			pstmt.setString(2, boleto.getNomeBanco());
			pstmt.setInt(3, boleto.getNumeroConta());
			pstmt.setString(4, boleto.getMensagemCliente());
			pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			retorno = "Erro ao cadastrar novo boleto " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}
		return retorno;
	}

	public String editarBoleto(Boleto boleto, int codigoSelecionado) throws DAOException {
		
		String insertSQL = "UPDATE BOLETO SET COD_BANCO=?,NOME_BANCO=?, NUMERO_CONTA=?,MENSAGEM_CLIENTE=? WHERE COD_BANCO=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		String retorno = "Boleto atualizado com sucesso";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setInt(1, boleto.getCodigoBanco());
			pstmt.setString(2, boleto.getNomeBanco());
			pstmt.setInt(3, boleto.getNumeroConta());
			pstmt.setString(4, boleto.getMensagemCliente());
			pstmt.setInt(5, codigoSelecionado);
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			retorno =  "Erro ao atualizar boleto " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}
		return retorno;
	}

	public String apagarBoleto(int codigoSelecionado) throws DAOException {
		
		String insertSQL = "DELETE FROM BOLETO WHERE COD_BANCO=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		String retorno = "Boleto apagado com sucesso";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setInt(1, codigoSelecionado);
			pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			 retorno = "Erro ao apagar boleto " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}
		return retorno;
	}


	public List<Boleto> listarBoletosPorNome (String nomeBancoPesquisado) throws DAOException{
		String selectSQL = "SELECT COD_BANCO,NOME_BANCO, NUMERO_CONTA, MENSAGEM_CLIENTE FROM BOLETO WHERE UPPER(NOME_BANCO) LIKE (UPPER('%" + nomeBancoPesquisado + "%'))";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Boleto> listaBoletosPesquisados = new ArrayList<Boleto>();

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer codigoBanco = rs.getInt("COD_BANCO");
				String nomeBanco = rs.getString("NOME_BANCO");
				Integer numeroConta = rs.getInt("NUMERO_CONTA");
				String mensagemCliente = rs.getString("MENSAGEM_CLIENTE");
				listaBoletosPesquisados.add(new Boleto (codigoBanco, nomeBanco,numeroConta,mensagemCliente));
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar banco: " + sqle);
			return null;
		} finally {
			close(connection);
			close(pstmt);
			close(rs);
		}
		return listaBoletosPesquisados;
	}

	public List<Boleto> listarTodosBoletos () throws DAOException {
		String selectSQL = "SELECT COD_BANCO,NOME_BANCO, NUMERO_CONTA, MENSAGEM_CLIENTE FROM BOLETO ORDER BY NOME_BANCO ASC";

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Boleto> listaBoletos = new ArrayList<Boleto>();

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer codigoBanco = rs.getInt("COD_BANCO");
				String nomeBanco = rs.getString("NOME_BANCO");
				Integer numeroConta = rs.getInt("NUMERO_CONTA");
				String mensagemCliente = rs.getString("MENSAGEM_CLIENTE");
				listaBoletos.add(new Boleto (codigoBanco, nomeBanco,numeroConta,mensagemCliente));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar banco");
			return null;
		} finally {
			close(connection);
			close(pstmt);
			close(rs);
		}
		return listaBoletos;
	}
}