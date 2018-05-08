package br.com.fean.si.poo2.projetounikahair.controller.boleto;

import java.util.List;

import br.com.fean.si.poo2.projetounikahair.controller.DAOException;
import br.com.fean.si.poo2.projetounikahair.model.Boleto;

public interface BoletoDAO {

	public void cadastrarNovoBoleto (Boleto boleto) throws DAOException;
	public List<Boleto> listarBoletosPorNome (String nomeBancoPesquisado) throws DAOException;
	public List<Boleto> listarTodosBoletos() throws DAOException;


}
