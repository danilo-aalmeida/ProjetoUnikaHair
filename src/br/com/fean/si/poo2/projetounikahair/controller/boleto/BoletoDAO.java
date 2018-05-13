package br.com.fean.si.poo2.projetounikahair.controller.boleto;

import javax.swing.table.DefaultTableModel;

import br.com.fean.si.poo2.projetounikahair.controller.DAOException;
import br.com.fean.si.poo2.projetounikahair.model.boleto.Boleto;

public interface BoletoDAO {

	public void cadastrarNovoBoleto (Boleto boleto) throws DAOException;
	public DefaultTableModel listarBoletosPorNome (String nomeBancoPesquisado) throws DAOException;
	public DefaultTableModel listarTodosBoletos() throws DAOException;


}
