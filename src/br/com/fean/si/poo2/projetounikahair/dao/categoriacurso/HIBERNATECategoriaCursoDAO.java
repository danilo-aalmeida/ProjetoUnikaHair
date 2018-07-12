package br.com.fean.si.poo2.projetounikahair.dao.categoriacurso;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.model.categoriacurso.CategoriaCurso;
import br.com.fean.si.poo2.projetounikahair.util.EntityManagerUtil;

public class HIBERNATECategoriaCursoDAO implements CategoriaCursoDAO{

	private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@Override
	public String inserir(CategoriaCurso categoriaCurso) {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Categoria de Curso cadastrda com sucesso";

		try {
			tx.begin();
			entityManager.persist(categoriaCurso);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao cadastrar nova categoria de curso" + t;

		}

		return retorno;
	}

	@Override
	public String editar(CategoriaCurso categoriaCurso) {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Categoria de Curso atualizada com sucesso";

		try {
			tx.begin();
			entityManager.merge(categoriaCurso);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao editar categoria de curso " + t;
		}

		return retorno;
	}

	@Override
	public String apagar(CategoriaCurso categoriaCurso) {
		EntityTransaction tx = entityManager.getTransaction();
		String retorno = "Categoria de Curso apagada com sucesso";

		try {
			tx.begin();
			entityManager.remove(categoriaCurso);
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
			retorno = "Erro ao apagar categoria de curso " + t;
		}

		return retorno;
	}

	@SuppressWarnings({ "null", "unchecked" })
	@Override
	public ArrayList<CategoriaCurso> listar(String termoPesquisa) {
		ArrayList<CategoriaCurso> lista = new ArrayList<CategoriaCurso>();
		String select = "SELECT C FROM CATEGORIACURSO AS C";



		try {

			Query query = null;


			if (termoPesquisa.length()>0){
				select += " WHERE C.NOME = :paramNomeCategoria";
				query.setParameter("paramNomeCategoria", termoPesquisa);
			}

			query = entityManager.createQuery(select);
			lista = (ArrayList<CategoriaCurso>) query.getResultList();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar categoria curso: " + e);
			return null;
		}


		return lista;
	}

}
