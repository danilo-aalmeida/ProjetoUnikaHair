package br.com.fean.si.poo2.projetounikahair.view.boleto;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fean.si.poo2.projetounikahair.dao.DAOException;
import br.com.fean.si.poo2.projetounikahair.exemplos.PainelCRUDGenerico;
import br.com.fean.si.poo2.projetounikahair.exemplos.SpringUtilities;

public class PainelConfigurarBoleto extends PainelCRUDGenerico{

	/* Descrição: O sistema deve permitir ao usuário informar os dados para a geração do 
	 boleto, tais como: código do banco, nro da conta, mensagem ao cliente... 
	 */

	//Componentes da Tabela
	private static final long serialVersionUID = 1L;
	private JTable tabTabela = new JTable ();
	private DefaultTableModel modelo = (DefaultTableModel) tabTabela.getModel();
	JScrollPane scroll = new JScrollPane(tabTabela);

	//Componentes do Formulário
	private JTextField texCodigoBanco = new JTextField();
	private JTextField texNomeBanco = new JTextField();
	private JTextField texNumeroConta = new JTextField();
	private JTextField texMensagemCliente = new JTextField();

	// Componentes dos Botões
	private JButton botSalvar = new JButton("Salvar");
	private JButton botCancelar = new JButton("Cancelar");
	private JButton botNovo = new JButton("Novo");
	private JButton botApagar = new JButton("Apagar");

	// Componentes de Pesquisa
	private JLabel labPesquisaNomeBanco = new JLabel("Pesquisar pelo Nome do Banco: ");
	private JTextField texPesquisaNomeBanco = new JTextField(50);
	private JButton botPesquisaNomeBanco = new JButton("Pesquisar");
	//private int codigoSelecionado = 0 ;
	
	// Instanciando Classe de Manipulação DAO
	/*private JDBCBoletoDAO jdbcBoleto = new JDBCBoletoDAO(); */

	public PainelConfigurarBoleto () {
		setNomeModulo();
		setPainelDePesquisa();
		setPainelDaTabela();
		setPainelDoFormulario();
		try {
			setPainelDeBotoes();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
	public void setNomeModulo () {
		//Painel que vai o Rotulo da Funcionalidade
		paiModulo.add(new Label("Configurar Boleto"));
	}
	
	public void setPainelDePesquisa () {
		//Painel de Pesquisa
		paiPesquisa.add(labPesquisaNomeBanco);
		paiPesquisa.add(texPesquisaNomeBanco);
		paiPesquisa.add(botPesquisaNomeBanco);
	}
	
	public void setPainelDaTabela() {
		//Painel da Tabela
		setColunasTabela();
		paiTabela.add(scroll);
	}
	
	public void setPainelDoFormulario() {
		//Painel do Formulario
		JLabel codigoBanco = new JLabel ("Código do Banco: ");
		paiFormulario.add(codigoBanco);
		codigoBanco.setLabelFor(texCodigoBanco);
		paiFormulario.add(texCodigoBanco);

		JLabel nomeBanco = new JLabel ("Nome do Banco: ");
		paiFormulario.add(nomeBanco);
		codigoBanco.setLabelFor(texNomeBanco);
		paiFormulario.add(texNomeBanco);		

		JLabel numeroConta = new JLabel ("Número da Conta: ");
		paiFormulario.add(numeroConta);
		numeroConta.setLabelFor(texNumeroConta);
		paiFormulario.add(texNumeroConta);

		JLabel mensagemCliente = new JLabel ("Mensagem ao Cliente: ");
		paiFormulario.add(mensagemCliente);
		mensagemCliente.setLabelFor(texMensagemCliente);
		paiFormulario.add(texMensagemCliente);

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(paiFormulario,
				4, 2, //rows, cols
				6, 6, //initX, initY
				6, 6); //xPad, yPad

		paiFormulario.setOpaque(true); //content panes must be opaque
	}
	
	public void setColunasTabela(){
		modelo.addColumn("Código do Banco");
		modelo.addColumn("Nome do Banco");
		modelo.addColumn("Numero da Conta");
		modelo.addColumn("Mensagem ao Cliente");
	}
	
	public void setPainelDeBotoes() throws DAOException {
		//Painel de Botões
		paiBotoes.add(botNovo);
		paiBotoes.add(botSalvar);
		paiBotoes.add(botCancelar);
		paiBotoes.add(botApagar);

		/* botPesquisaNomeBanco.addActionListener(this);
		botSalvar.addActionListener(this);
		botCancelar.addActionListener(this);
		botApagar.addActionListener(this);
		botNovo.addActionListener(this);

		tabTabela.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			private int linha;

			@SuppressWarnings("unused")
			private int coluna;
		
			@Override
			public void mouseClicked (MouseEvent e) {
				linha = tabTabela.getSelectedRow();
				coluna = tabTabela.getSelectedColumn();
				tabTabela.getColumnName(1);
				
				String codigoBanco = (String) tabTabela.getValueAt(tabTabela.getSelectedRow(), 0);
				String nomeBanco = (String) tabTabela.getValueAt(tabTabela.getSelectedRow(), 1);
				String numeroConta = (String) tabTabela.getValueAt(tabTabela.getSelectedRow(), 2);
				String mensagemCliente = (String) tabTabela.getValueAt(tabTabela.getSelectedRow(), 3);

				texCodigoBanco.setText(codigoBanco);
				texNomeBanco.setText(nomeBanco);
				texNumeroConta.setText(numeroConta);
				texMensagemCliente.setText(mensagemCliente);
				codigoSelecionado = Integer.parseInt(codigoBanco);

				alterarStatusBotoesCampos(true,true,true,true,false,true, true, true,false);
			}
		});
		carregarTabelaTotal();
		alterarStatusBotoesCampos(false,false,false,false,true,false,false,false,true); */
	}

	public JTable getTabTabela() {
		return tabTabela;
	}

	public void setTabTabela(JTable tabTabela) {
		this.tabTabela = tabTabela;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JTextField getTexCodigoBanco() {
		return texCodigoBanco;
	}

	public void setTexCodigoBanco(JTextField texCodigoBanco) {
		this.texCodigoBanco = texCodigoBanco;
	}

	public JTextField getTexNomeBanco() {
		return texNomeBanco;
	}

	public void setTexNomeBanco(JTextField texNomeBanco) {
		this.texNomeBanco = texNomeBanco;
	}

	public JTextField getTexNumeroConta() {
		return texNumeroConta;
	}

	public void setTexNumeroConta(JTextField texNumeroConta) {
		this.texNumeroConta = texNumeroConta;
	}

	public JTextField getTexMensagemCliente() {
		return texMensagemCliente;
	}

	public void setTexMensagemCliente(JTextField texMensagemCliente) {
		this.texMensagemCliente = texMensagemCliente;
	}

	public JButton getBotSalvar() {
		return botSalvar;
	}

	public void setBotSalvar(JButton botSalvar) {
		this.botSalvar = botSalvar;
	}

	public JButton getBotCancelar() {
		return botCancelar;
	}

	public void setBotCancelar(JButton botCancelar) {
		this.botCancelar = botCancelar;
	}

	public JButton getBotNovo() {
		return botNovo;
	}

	public void setBotNovo(JButton botNovo) {
		this.botNovo = botNovo;
	}

	public JButton getBotApagar() {
		return botApagar;
	}

	public void setBotApagar(JButton botApagar) {
		this.botApagar = botApagar;
	}

	public JLabel getLabPesquisaNomeBanco() {
		return labPesquisaNomeBanco;
	}

	public void setLabPesquisaNomeBanco(JLabel labPesquisaNomeBanco) {
		this.labPesquisaNomeBanco = labPesquisaNomeBanco;
	}

	public JTextField getTexPesquisaNomeBanco() {
		return texPesquisaNomeBanco;
	}

	public void setTexPesquisaNomeBanco(JTextField texPesquisaNomeBanco) {
		this.texPesquisaNomeBanco = texPesquisaNomeBanco;
	}

	public JButton getBotPesquisaNomeBanco() {
		return botPesquisaNomeBanco;
	}

	public void setBotPesquisaNomeBanco(JButton botPesquisaNomeBanco) {
		this.botPesquisaNomeBanco = botPesquisaNomeBanco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	/* public void preencherTabela(List<Boleto> listaBoletos) {
		modelo.setRowCount(0);
		for (Boleto boleto : listaBoletos) {
			modelo.addRow(new String[]{boleto.getCodigoBanco().toString(), boleto.getNomeBanco(), boleto.getNumeroConta().toString(),boleto.getMensagemCliente()});
		}	
	} */

	/*public void carregarTabelaTotal() throws DAOException {
		modelo.setRowCount(0);
		List<Boleto> listaTodosBoletos = new ArrayList<Boleto>();
		listaTodosBoletos = jdbcBoleto.listarTodosBoletos();
		preencherTabela(listaTodosBoletos);
	} */

	/* public void limparCampos () {
		texCodigoBanco.setText("");
		texNomeBanco.setText("");
		texNumeroConta.setText("");
		texMensagemCliente.setText("");
		texPesquisaNomeBanco.setText("");
	} */

	/* public void alterarStatusBotoesCampos(boolean codigoBanco, boolean nomeBanco, boolean numeroConta, 
			boolean mensagemCliente, boolean novo, boolean apagar, boolean salvar, boolean cancelar,
			boolean limpaCampos) {

		texCodigoBanco.setEnabled(codigoBanco); 
		texNomeBanco.setEnabled(nomeBanco); 
		texNumeroConta.setEnabled(numeroConta); 
		texMensagemCliente.setEnabled(mensagemCliente); 

		botNovo.setVisible(novo); 
		botApagar.setVisible(apagar); 
		botSalvar.setVisible(salvar); 
		botCancelar.setVisible(cancelar); 

		if (limpaCampos) {
			codigoSelecionado = 0;
			limparCampos();
		}
	} */

	
	/* @Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(botSalvar)) {
			Boleto dadosBoleto = new Boleto(Integer.parseInt(texCodigoBanco.getText()),
					texNomeBanco.getText(),
					Integer.parseInt(texNumeroConta.getText()),
					texMensagemCliente.getText());

			if(codigoSelecionado==0) {
				try {
					jdbcBoleto.cadastrarNovoBoleto(dadosBoleto);
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					jdbcBoleto.editarBoleto(dadosBoleto, codigoSelecionado);
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
			}
			alterarStatusBotoesCampos(false,false, false, false, true, false, false, false,true);
		} else if (ae.getSource().equals(botPesquisaNomeBanco)) {
			try {
				List<Boleto> listaBoletosPesquisados = new ArrayList<Boleto>();
				listaBoletosPesquisados = jdbcBoleto.listarBoletosPorNome(texPesquisaNomeBanco.getText());
				limparCampos();
				preencherTabela(listaBoletosPesquisados);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} else if (ae.getSource().equals(botNovo)) {
			alterarStatusBotoesCampos(true,true,true,true,false,false,true,true,true);
		} else if (ae.getSource().equals(botApagar)) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar o boleto selecionado ?", "Informe", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				try {
					jdbcBoleto.apagarBoleto(codigoSelecionado);
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
				alterarStatusBotoesCampos(false,false,false,false,true,false,false,false,true);
			}
		} else if (ae.getSource().equals(botCancelar)) {
			alterarStatusBotoesCampos(false,false,false,false,true,false,false,false,true);
		}
	}*/
	
	
	
	
	
	
}