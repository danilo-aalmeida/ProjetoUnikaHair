package br.com.fean.si.poo2.projetounikahair.controller.boleto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.dao.DAOException;
import br.com.fean.si.poo2.projetounikahair.model.boleto.Boleto;
import br.com.fean.si.poo2.projetounikahair.service.boleto.ConfigurarBoletoService;
import br.com.fean.si.poo2.projetounikahair.view.boleto.PainelConfigurarBoleto;

public class ConfigurarBoletoController implements ActionListener{
	PainelConfigurarBoleto painel = null;
	ConfigurarBoletoService configurarBoletoService = new ConfigurarBoletoService();
	int codigoSelecionado = 0;

	
	public ConfigurarBoletoController (PainelConfigurarBoleto painelConfigurarBoleto) throws DAOException {
		painel = painelConfigurarBoleto;
		painel.getBotApagar().addActionListener(this);
		painel.getBotCancelar().addActionListener(this);
		painel.getBotNovo().addActionListener(this);
		painel.getBotPesquisaNomeBanco().addActionListener(this);
		painel.getBotSalvar().addActionListener(this);
		
		
		painel.getTabTabela().addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			private int linha;

			@SuppressWarnings("unused")
			private int coluna;
		
			@Override
			public void mouseClicked (MouseEvent e) {
				linha = painel.getTabTabela().getSelectedRow();
				coluna = painel.getTabTabela().getSelectedColumn();
				painel.getTabTabela().getColumnName(1);
				
				String codigoBanco = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 0);
				String nomeBanco = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 1);
				String numeroConta = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 2);
				String mensagemCliente = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 3);

				painel.getTexCodigoBanco().setText(codigoBanco);
				painel.getTexNomeBanco().setText(nomeBanco);
				painel.getTexNumeroConta().setText(numeroConta);
				painel.getTexMensagemCliente().setText(mensagemCliente);
				codigoSelecionado = Integer.parseInt(codigoBanco);

				alterarStatusBotoesCampos(true,true,true,true,false,true, true, true,false);
			}
		});
		carregarTabelaTotal();
		alterarStatusBotoesCampos(false,false,false,false,true,false,false,false,true);
		
	}
	
	public void preencherTabela(List<Boleto> listaBoletos) {
		painel.getModelo().setRowCount(0);
		for (Boleto boleto : listaBoletos) {
			painel.getModelo().addRow(new String[]{boleto.getCodigoBanco().toString(), boleto.getNomeBanco(), boleto.getNumeroConta().toString(),boleto.getMensagemCliente()});
		}
	}
	
	public void carregarTabelaTotal() throws DAOException {
		painel.getModelo().setRowCount(0);
		List<Boleto> listaTodosBoletos = new ArrayList<Boleto>();
		listaTodosBoletos = configurarBoletoService.listarTodos();
		preencherTabela(listaTodosBoletos);
	}
		
		public void limparCampos () {
			painel.getTexCodigoBanco().setText("");
			painel.getTexNomeBanco().setText("");
			painel.getTexNumeroConta().setText("");
			painel.getTexMensagemCliente().setText("");
			painel.getTexPesquisaNomeBanco().setText("");
		}
		
		public void alterarStatusBotoesCampos(boolean codigoBanco, boolean nomeBanco, boolean numeroConta, 
				boolean mensagemCliente, boolean novo, boolean apagar, boolean salvar, boolean cancelar,
				boolean limpaCampos) {

			painel.getTexCodigoBanco().setEnabled(codigoBanco); 
			painel.getTexNomeBanco().setEnabled(nomeBanco); 
			painel.getTexNumeroConta().setEnabled(numeroConta); 
			painel.getTexMensagemCliente().setEnabled(mensagemCliente); 

			painel.getBotNovo().setVisible(novo); 
			painel.getBotApagar().setVisible(apagar); 
			painel.getBotSalvar().setVisible(salvar); 
			painel.getBotCancelar().setVisible(cancelar); 

			if (limpaCampos) {
				codigoSelecionado = 0;
				limparCampos();
			}
		}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(painel.getBotSalvar())) {
			
			if(codigoSelecionado==0) {
				try {
					
					configurarBoletoService.inserir(Integer.parseInt(painel.getTexCodigoBanco().getText()),
					painel.getTexNomeBanco().getText(),
					Integer.parseInt(painel.getTexNumeroConta().getText()),
					painel.getTexMensagemCliente().getText());
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					
					configurarBoletoService.editar(Integer.parseInt(painel.getTexCodigoBanco().getText()),
					painel.getTexNomeBanco().getText(),
					Integer.parseInt(painel.getTexNumeroConta().getText()),
					painel.getTexMensagemCliente().getText(), codigoSelecionado);
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
			}
			alterarStatusBotoesCampos(false,false, false, false, true, false, false, false,true);
		} else if (ae.getSource().equals(painel.getBotPesquisaNomeBanco())) {
			try {
				List<Boleto> listaBoletosPesquisados = new ArrayList<Boleto>();
				listaBoletosPesquisados = configurarBoletoService.listarPorNome(painel.getTexPesquisaNomeBanco().getText());
				limparCampos();
				preencherTabela(listaBoletosPesquisados);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} else if (ae.getSource().equals(painel.getBotNovo())) {
			alterarStatusBotoesCampos(true,true,true,true,false,false,true,true,true);
		} else if (ae.getSource().equals(painel.getBotApagar())) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar o boleto selecionado ?", "Informe", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				try {
					configurarBoletoService.apagar(codigoSelecionado);
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
				alterarStatusBotoesCampos(false,false,false,false,true,false,false,false,true);
			}
		} else if (ae.getSource().equals(painel.getBotCancelar())) {
			alterarStatusBotoesCampos(false,false,false,false,true,false,false,false,true);
		}
		
	}
	
	
	
}
