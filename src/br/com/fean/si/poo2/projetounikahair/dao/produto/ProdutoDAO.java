package br.com.fean.si.poo2.projetounikahair.dao.produto;

import java.util.List;

import br.com.fean.si.poo2.projetounikahair.model.produto.Produto;
import br.com.fean.si.poo2.projetounikahair.util.DAOException;

public interface ProdutoDAO {

	public String cadastrarNovoProduto (Produto produto) throws DAOException;
	public List<Produto> listarProdutosPorNome (String nomeBancoPesquisado) throws DAOException;
	public List<Produto> listarTodosProdutos() throws DAOException;
	public String editarProduto(Produto produto, int codigoSelecionado) throws DAOException;
	public String apagarProduto(int codigoSelecionado) throws DAOException;

}
