package br.com.fean.si.poo2.projetounikahair.dao.boleto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.model.boleto.Boleto;
import br.com.fean.si.poo2.projetounikahair.util.DAOException;
import br.com.fean.si.poo2.projetounikahair.util.EntityManagerUtil;

public class HIBERNATEBoletoDAO implements BoletoDAO{
	
	private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@Override
	public String cadastrarNovoBoleto(Boleto boleto) throws DAOException {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Boleto cadastrado com sucesso";
		
		try {
			tx.begin();
			entityManager.persist(boleto);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao cadastrar novo boleto " + t;
		} 		
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Boleto> listarBoletosPorNome(String nomeBancoPesquisado) throws DAOException {
		List<Boleto> listaBoletosPesquisados = new ArrayList<Boleto>();
		
		try {
			Query query = entityManager.createQuery("SELECT B FROM BOLETO AS B +"
					+ "WHERE B.NOME_BANCO = :paramNomeBanco");
			query.setParameter("paramNomeBanco", nomeBancoPesquisado);
			listaBoletosPesquisados = query.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar banco: " + e);
			return null;
			
		}
		
		return listaBoletosPesquisados;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Boleto> listarTodosBoletos() throws DAOException {
		List<Boleto> listaBoletos = new ArrayList<Boleto>();
		
		try {
			Query query = entityManager.createQuery("SELECT B FROM BOLETO AS B ");
			listaBoletos = query.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar banco: " + e);
			return null;
			
		}
		return listaBoletos;
	}

	@Override
	public String editarBoleto(Boleto boleto, int codigoSelecionado) throws DAOException {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Boleto atualizado com sucesso";
		
		try {
			tx.begin();
			entityManager.merge(boleto);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao editar boleto " + t;
		}
		
		return retorno;
	}

	@Override
	public String apagarBoleto(int codigoSelecionado) throws DAOException {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Boleto apagado com sucesso";
		Boleto boleto = null;
		try {
			tx.begin();
			boleto = entityManager.find(Boleto.class, codigoSelecionado);
			entityManager.remove(boleto);
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao apagar boleto " + t;
			
		}
		
		return retorno;
	}

}
