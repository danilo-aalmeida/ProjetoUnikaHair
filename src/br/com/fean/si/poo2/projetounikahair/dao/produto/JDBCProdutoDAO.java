package br.com.fean.si.poo2.projetounikahair.dao.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.model.produto.Produto;
import br.com.fean.si.poo2.projetounikahair.util.DAOException;
import br.com.fean.si.poo2.projetounikahair.util.JDBCAbstractDAO;

public class JDBCProdutoDAO extends JDBCAbstractDAO implements ProdutoDAO {

	public String cadastrarNovoProduto(Produto produto) throws DAOException {

		String insertSQL = "INSERT INTO PRODUTO (COD_PRODUTO, NOME_PRODUTO, PRECO_VENDA, ESTOQUE_MINIMO, QUANTIDADE_ESTOQUE, MARCA, CATEGORIA_PRODUTO) VALUE (?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement pstmt = null;
		String retorno = "Produto cadastrado com sucesso";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setInt(1, produto.getCodigoProduto());
			pstmt.setString(2, produto.getNomeProduto());
			pstmt.setDouble(3, produto.getPrecoVenda());
			pstmt.setInt(4, produto.getEstoqueMinimo());
			pstmt.setInt(5, produto.getQuantidadeEstoque());
			pstmt.setString(6, produto.getMarca());
			pstmt.setString(7, produto.getCategoriaProduto());
			pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			retorno = "Erro ao cadastrar novo produto " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}
		return retorno;
	}

	public String editarProduto(Produto produto, int codigoSelecionado) throws DAOException {
		
		String insertSQL = "UPDATE PRODUTO SET COD_PRODUTO=?,NOME_PRODUTO=?, PRECO_VENDA=?,ESTOQUE_MINIMO=?, QUANTIDADE_ESTOQUE=?, MARCA=?, CATEGORIA_PRODUTO=? WHERE COD_PRODUTO=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		String retorno = "Produto atualizado com sucesso";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setInt(1, produto.getCodigoProduto());
			pstmt.setString(2, produto.getNomeProduto());
			pstmt.setDouble(3, produto.getPrecoVenda());
			pstmt.setInt(4, produto.getEstoqueMinimo());
			pstmt.setInt(5, produto.getQuantidadeEstoque());
			pstmt.setString(6, produto.getMarca());
			pstmt.setString(7, produto.getCategoriaProduto());
			pstmt.setInt(8, codigoSelecionado);
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			retorno =  "Erro ao atualizar produto " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}
		return retorno;
	}

	public String apagarProduto(int codigoSelecionado) throws DAOException {
		
		String insertSQL = "DELETE FROM PRODUTO WHERE COD_PRODUTO=?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		String retorno = "Produto apagado com sucesso";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(insertSQL);
			pstmt.setInt(1, codigoSelecionado);
			pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			 retorno = "Erro ao apagar produto " + sqle;
		} finally {
			close (pstmt);
			close (connection);
		}
		return retorno;
	}


	public List<Produto> listarProdutosPorNome (String nomeProdutoPesquisado) throws DAOException{
		String selectSQL = "SELECT COD_PRODUTO, NOME_PRODUTO, PRECO_VENDA, ESTOQUE_MINIMO, QUANTIDADE_ESTOQUE, MARCA, CATEGORIA_PRODUTO FROM PRODUTO WHERE UPPER(NOME_PRODUTO) LIKE (UPPER('%" + nomeProdutoPesquisado + "%'))";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Produto> listaProdutosPesquisados = new ArrayList<Produto>();

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer codigoProduto = rs.getInt("COD_PRODUTO");
				String nomeProduto = rs.getString("NOME_PRODUTO");
				Double precoVenda = rs.getDouble("PRECO_VENDA");
				Integer estoqueMinimo = rs.getInt("ESTOQUE_MINIMO");
				Integer quantidadeEstoque = rs.getInt("QUANTIDADE_ESTOQUE");
				String marca = rs.getString("MARCA");
				String categoriaProduto = rs.getString("CATEGORIA_PRODUTO");
				listaProdutosPesquisados.add(new Produto (codigoProduto, nomeProduto, precoVenda, estoqueMinimo, quantidadeEstoque, marca, categoriaProduto));
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + sqle);
			return null;
		} finally {
			close(connection);
			close(pstmt);
			close(rs);
		}
		return listaProdutosPesquisados;
	}

	public List<Produto> listarTodosProdutos () throws DAOException {
		String selectSQL = "SELECT COD_PRODUTO, NOME_PRODUTO, PRECO_VENDA, ESTOQUE_MINIMO, QUANTIDADE_ESTOQUE, MARCA, CATEGORIA_PRODUTO FROM PRODUTO ORDER BY COD_PRODUTO ASC";

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Produto> listaProdutos = new ArrayList<Produto>();

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer codigoProduto = rs.getInt("COD_PRODUTO");
				String nomeProduto = rs.getString("NOME_PRODUTO");
				Double precoVenda = rs.getDouble("PRECO_VENDA");
				Integer estoqueMinimo = rs.getInt("ESTOQUE_MINIMO");
				Integer quantidadeEstoque = rs.getInt("QUANTIDADE_ESTOQUE");
				String marca = rs.getString("MARCA");
				String categoriaProduto = rs.getString("CATEGORIA_PRODUTO");
				listaProdutos.add(new Produto (codigoProduto, nomeProduto, precoVenda, estoqueMinimo, quantidadeEstoque, marca, categoriaProduto));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar produto");
			return null;
		} finally {
			close(connection);
			close(pstmt);
			close(rs);
		}
		return listaProdutos;
	}

}