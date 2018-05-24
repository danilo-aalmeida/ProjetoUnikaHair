package br.com.fean.si.poo2.projetounikahair.controller.exemploVeppo;

import java.util.Collections;
import java.util.List;

import br.com.fean.si.poo2.projetounikahair.dao.DAOException;
import br.com.fean.si.poo2.projetounikahair.dao.DAOFactory;
import br.com.fean.si.poo2.projetounikahair.dao.ExemploDAO;
import br.com.fean.si.poo2.projetounikahair.model.exemploVeppo.Exemplo;

/**
 * @author joao(jhveppo@gmail.com)
 *
 */
public class ExemploManagerBean {
	
	private ExemploDAO dao;

	public ExemploManagerBean() {
		dao = DAOFactory.cadastreExemploDAO();
	}
	
	public List<Exemplo> carregarRegistros() {
		try {
			return dao.apresentarTodosRegistros();
		} catch (DAOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public boolean cadastrarRegistro(Exemplo sammple) {
		try {
			return dao.cadastrarNovoRegistro(sammple);
		} catch (DAOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Exemplo> carregarRegistrosPorFiltro(String filtro) {
		try {
			return dao.apresentarRegistrosPorFiltro(filtro);
		} catch (DAOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
