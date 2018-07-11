package br.com.fean.si.poo2.projetounikahair.dao.categoriacurso;

import java.util.ArrayList;

import br.com.fean.si.poo2.projetounikahair.model.categoriacurso.CategoriaCurso;



public interface CategoriaCursoDAO {
	
	public String inserir(CategoriaCurso categoriaCurso);
	public String editar(CategoriaCurso categoriaCurso);
	public String apagar(CategoriaCurso categoriaCurso);
	public ArrayList<CategoriaCurso> listar(String termoPesquisa);

}
