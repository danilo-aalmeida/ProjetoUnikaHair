package br.com.fean.si.poo2.projetounikahair.service.boleto;

import java.util.List;

import br.com.fean.si.poo2.projetounikahair.dao.DAOException;
import br.com.fean.si.poo2.projetounikahair.dao.boleto.JDBCBoletoDAO;
import br.com.fean.si.poo2.projetounikahair.model.boleto.Boleto;

public class ConfigurarBoletoService {
	JDBCBoletoDAO jdbcBoletoDAO = new JDBCBoletoDAO();
	
	public String inserir (Integer codigo, String nome, Integer numeroConta, String mensagemCliente) throws DAOException {
		Boleto novoBoleto = new Boleto(codigo, nome, numeroConta, mensagemCliente);
		
		String retorno = jdbcBoletoDAO.cadastrarNovoBoleto(novoBoleto);
		
		return retorno;
		
	}
	
	public String editar (Integer codigo, String nome, Integer numeroConta, String mensagemCliente, Integer codigoSelecionado) throws DAOException {
		Boleto dadosBoleto = new Boleto(codigo, nome, numeroConta, mensagemCliente);
		
		String retorno = jdbcBoletoDAO.editarBoleto(dadosBoleto, codigoSelecionado);
		
		
		
		return retorno;
		
	}
	
	public String apagar (Integer codigoSelecionado) throws DAOException {
		
		String retorno = jdbcBoletoDAO.apagarBoleto(codigoSelecionado);
		return retorno;	
		
	}
	
	public List<Boleto> listarPorNome (String nomePesquisado) throws DAOException{
		
	List<Boleto> lista = jdbcBoletoDAO.listarBoletosPorNome(nomePesquisado);
	
	return lista;
		
	}

	public List<Boleto> listarTodos () throws DAOException{
		
	List<Boleto> lista = jdbcBoletoDAO.listarTodosBoletos();
	
	return lista;
		
	}

}
