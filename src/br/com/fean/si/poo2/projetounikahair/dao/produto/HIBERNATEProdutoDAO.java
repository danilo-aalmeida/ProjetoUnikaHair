package br.com.fean.si.poo2.projetounikahair.dao.produto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.model.produto.Produto;
import br.com.fean.si.poo2.projetounikahair.util.DAOException;
import br.com.fean.si.poo2.projetounikahair.util.EntityManagerUtil;

public class HIBERNATEProdutoDAO implements ProdutoDAO{

	private final EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	@Override
	public String cadastrarNovoProduto(Produto produto) throws DAOException {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Produto cadastrado com sucesso";
		
		try {
			tx.begin();
			entityManager.persist(produto);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao cadastrar novo produto " + t;
		} 		
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listarProdutosPorNome(String nomeProdutoPesquisado) throws DAOException {
		List<Produto> listaProdutosPesquisados = new ArrayList<Produto>();
		
		try {
			Query query = entityManager.createQuery("SELECT P FROM PRODUTO AS P +"
					+ "WHERE P.NOME_PRODUTO = :paramNomeProduto");
			query.setParameter("paramNomeProduto", nomeProdutoPesquisado);
			listaProdutosPesquisados = query.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e);
			return null;
			
		}
		
		return listaProdutosPesquisados;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listarTodosProdutos() throws DAOException {
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		try {
			Query query = entityManager.createQuery("SELECT P FROM PRODUTO AS P ");
			listaProdutos = query.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e);
			return null;
			
		}
		return listaProdutos;
	}

	@Override
	public String editarProduto(Produto produto, int codigoSelecionado) throws DAOException {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Produto atualizado com sucesso";
		
		try {
			tx.begin();
			entityManager.merge(produto);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao editar produto " + t;
		}
		
		return retorno;
	}

	@Override
	public String apagarProduto(int codigoSelecionado) throws DAOException {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Produto apagado com sucesso";
		Produto produto = null;
		try {
			tx.begin();
			produto = entityManager.find(Produto.class, codigoSelecionado);
			entityManager.remove(produto);
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao apagar produto " + t;
			
		}
		
		return retorno;
	}

}
