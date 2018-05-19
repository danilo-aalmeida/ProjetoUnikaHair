package br.com.fean.si.poo2.projetounikahair.controller.boleto;

import java.util.List;

import br.com.fean.si.poo2.projetounikahair.controller.DAOException;
import br.com.fean.si.poo2.projetounikahair.model.boleto.Boleto;

public interface BoletoDAO {

	public void cadastrarNovoBoleto (Boleto boleto) throws DAOException;
	public List<Boleto> listarBoletosPorNome (String nomeBancoPesquisado) throws DAOException;
	public List<Boleto> listarTodosBoletos() throws DAOException;
	public void editarBoleto(Boleto boleto, int codigoSelecionado) throws DAOException;
	public void apagarBoleto(int codigoSelecionado) throws DAOException;
	

}
