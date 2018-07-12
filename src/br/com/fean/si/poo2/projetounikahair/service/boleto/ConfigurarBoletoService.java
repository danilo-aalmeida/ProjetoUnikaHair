package br.com.fean.si.poo2.projetounikahair.service.boleto;

import java.util.List;

import br.com.fean.si.poo2.projetounikahair.dao.boleto.HIBERNATEBoletoDAO;
import br.com.fean.si.poo2.projetounikahair.model.boleto.Boleto;
import br.com.fean.si.poo2.projetounikahair.util.DAOException;

public class ConfigurarBoletoService {
	//JDBCBoletoDAO boletoDAO = new JDBCBoletoDAO();
	HIBERNATEBoletoDAO boletoDAO = new HIBERNATEBoletoDAO();
	
	public String inserir (Integer codigo, String nome, Integer numeroConta, String mensagemCliente) throws DAOException {
		Boleto novoBoleto = new Boleto(codigo, nome, numeroConta, mensagemCliente);
		
		
		String retorno = boletoDAO.cadastrarNovoBoleto(novoBoleto);
		
		return retorno;
		
	}
	
	public String editar (Integer codigo, String nome, Integer numeroConta, String mensagemCliente, Integer codigoSelecionado) throws DAOException {
		Boleto dadosBoleto = new Boleto(codigo, nome, numeroConta, mensagemCliente);
		
		
		String retorno = boletoDAO.editarBoleto(dadosBoleto, codigoSelecionado);
		
		
		
		return retorno;
		
	}
	
	public String apagar (Integer codigoSelecionado) throws DAOException {
		
		
		String retorno = boletoDAO.apagarBoleto(codigoSelecionado);
		
		
		return retorno;	
		
	}
	
	public List<Boleto> listarPorNome (String nomePesquisado) throws DAOException{
		
	
	List<Boleto> lista = boletoDAO.listarBoletosPorNome(nomePesquisado);
	
	return lista;
		
	}

	public List<Boleto> listarTodos () throws DAOException{
		
	
	List<Boleto> lista = boletoDAO.listarTodosBoletos();
	
	return lista;
		
	}

}
