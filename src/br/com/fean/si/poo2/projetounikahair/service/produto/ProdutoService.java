package br.com.fean.si.poo2.projetounikahair.service.produto;

import java.util.List;

import br.com.fean.si.poo2.projetounikahair.dao.produto.JDBCProdutoDAO;
import br.com.fean.si.poo2.projetounikahair.model.produto.Produto;
import br.com.fean.si.poo2.projetounikahair.util.DAOException;

public class ProdutoService {
	JDBCProdutoDAO jdbcProdutoDAO = new JDBCProdutoDAO();
	
	public String inserir (Integer codigoProduto, String nomeProduto, Double precoVenda, Integer estoqueMinimo,
			Integer quantidadeEstoque, String marca, String categoriaProduto) throws DAOException {
		
		Produto novoProduto = new Produto(codigoProduto, nomeProduto, precoVenda, estoqueMinimo, quantidadeEstoque, marca, categoriaProduto);
		
		String retorno = jdbcProdutoDAO.cadastrarNovoProduto(novoProduto);
		
		return retorno;
		
	}
	
	public String editar (Integer codigoProduto, String nomeProduto, Double precoVenda, Integer estoqueMinimo,
			Integer quantidadeEstoque, String marca, String categoriaProduto, Integer codigoSelecionado) throws DAOException {
		Produto dadosProduto = new Produto(codigoProduto, nomeProduto, precoVenda, estoqueMinimo, quantidadeEstoque, marca, categoriaProduto);
		
		String retorno = jdbcProdutoDAO.editarProduto(dadosProduto, codigoSelecionado);
		
		
		
		return retorno;
		
	}
	
	public String apagar (Integer codigoSelecionado) throws DAOException {
		
		String retorno = jdbcProdutoDAO.apagarProduto(codigoSelecionado);
		return retorno;	
		
	}
	
	public List<Produto> listarPorNome (String nomePesquisado) throws DAOException{
		
	List<Produto> lista = jdbcProdutoDAO.listarProdutosPorNome(nomePesquisado);
	
	return lista;
		
	}

	public List<Produto> listarTodos () throws DAOException{
		
	List<Produto> lista = jdbcProdutoDAO.listarTodosProdutos();
	
	return lista;
		
	}

}
