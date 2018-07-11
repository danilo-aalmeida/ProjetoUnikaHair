package br.com.fean.si.poo2.projetounikahair.dao.boleto;

import java.util.List;

import br.com.fean.si.poo2.projetounikahair.dao.DAOException;
import br.com.fean.si.poo2.projetounikahair.model.boleto.Boleto;

public interface BoletoDAO {

	public String cadastrarNovoBoleto (Boleto boleto) throws DAOException;
	public List<Boleto> listarBoletosPorNome (String nomeBancoPesquisado) throws DAOException;
	public List<Boleto> listarTodosBoletos() throws DAOException;
	public String editarBoleto(Boleto boleto, int codigoSelecionado) throws DAOException;
	public String apagarBoleto(int codigoSelecionado) throws DAOException;

}
