package br.com.fean.si.poo2.projetounikahair.dao;

import java.util.List;

import br.com.fean.si.poo2.projetounikahair.model.exemploVeppo.Exemplo;

public interface ExemploDAO {
	public boolean cadastrarNovoRegistro(Exemplo exemplo) throws DAOException;
	public List<Exemplo> apresentarRegistrosPorFiltro(String nome) throws DAOException;
	public List<Exemplo> apresentarTodosRegistros() throws DAOException;
}
