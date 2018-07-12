package br.com.fean.si.poo2.projetounikahair.dao.categoriacurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.model.categoriacurso.CategoriaCurso;
import br.com.fean.si.poo2.projetounikahair.util.JDBCAbstractDAO;

public class JDBCCategoriaCursoDAO extends JDBCAbstractDAO implements CategoriaCursoDAO {

	@Override
	public String inserir(CategoriaCurso categoriaCurso) {

		String insertSQL = "INSERT INTO categoriacurso (nome, descricao ) VALUES (?,?)";
		Connection connection = null;
		PreparedStatement pstmt = null;		
		String retorno="Inserção realizada com sucesso";
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setString(1, categoriaCurso.getNome());
			pstmt.setString(2, categoriaCurso.getDescricao());
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			retorno = "Erro ao cadastrar nova categoria de curso " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}

		return retorno;
	}

	@Override
	public String editar(CategoriaCurso categoriaCurso) {
		String insertSQL = "UPDATE  categoriacurso set nome=?, descricao=? where id = ?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		String retorno="Alteração realizada com sucesso";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setString(1, categoriaCurso.getNome());
			pstmt.setString(2, categoriaCurso.getDescricao());
			pstmt.setInt(3, categoriaCurso.getId());
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			retorno = "Erro ao alterar categoria de curso " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}

		return retorno;
	}

	@Override
	public String apagar(CategoriaCurso categoriaCurso) {
		String insertSQL = "DELETE from categoriacurso where id=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		String retorno="Exclusão realizada com sucesso";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setInt(1, categoriaCurso.getId());
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			retorno = "Erro ao excluir categoria de curso " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}


		return retorno;
	}

	@Override
	public ArrayList<CategoriaCurso> listar(String termoPesquisa) {
		ArrayList<CategoriaCurso> lista = new ArrayList<CategoriaCurso>();
		String selectSQL = "select * from categoriacurso";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if (termoPesquisa.length()>0){
			selectSQL += " where nome like '%"+termoPesquisa+"%'"; 
		}
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CategoriaCurso categoriaCurso = new CategoriaCurso(
						rs.getInt("id"),rs.getString("nome"),rs.getString("descricao"));
				lista.add(categoriaCurso);
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
		
		return lista;
	}

}
