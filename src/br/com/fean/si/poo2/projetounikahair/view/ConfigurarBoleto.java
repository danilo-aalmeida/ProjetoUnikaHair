package br.com.fean.si.poo2.projetounikahair.view;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fean.si.poo2.projetounikahair.exemplos.PainelCRUDGenerico;
import br.com.fean.si.poo2.projetounikahair.exemplos.SpringUtilities;


public class ConfigurarBoleto extends PainelCRUDGenerico implements ActionListener{

	/* Descri��o: O sistema deve permitir ao usu�rio informar os dados para a gera��o do 
	 boleto, tais como: c�digo do banco, nro da conta, mensagem ao cliente... 
	*/
	
	//Componentes da Tabela

	private static final long serialVersionUID = 1L;
	private JTable tabTabela = new JTable ();
	private DefaultTableModel modelo = (DefaultTableModel) tabTabela.getModel();
	JScrollPane scroll = new JScrollPane(tabTabela);

	//Componentes do Formul�rio

	private JTextField texCodigoBanco = new JTextField();
	private JTextField texNumeroConta = new JTextField();
	private JTextField texMensagemCliente = new JTextField();

	// Componentes dos Bot�es

	private JButton botSalvar = new JButton("Salvar");
	private JButton botCancelar = new JButton("Cancelar");

	// Componentes de Pesquisa

	private JLabel labPesquisaCodigoBanco = new JLabel("Pesquisar pelo C�digo do Banco: ");
	private JTextField texPesquisaCodigoBanco = new JTextField(20);
	private JButton botPesquisaCodigoBanco = new JButton("Pesquisar");


	public ConfigurarBoleto () {
		//Painel que vai o Rotulo da Funcionalidade
		paiModulo.add(new Label("Configurar Boleto"));

		//Painel de Pesquisa
		paiPesquisa.add(labPesquisaCodigoBanco);
		paiPesquisa.add(texPesquisaCodigoBanco);
		paiPesquisa.add(botPesquisaCodigoBanco);

		//Painel da Tabela
		setColunasTabela();
		paiTabela.add(scroll);
		
		//Painel do Formulario
		JLabel codigoBanco = new JLabel ("C�digo do Banco: ");
		paiFormulario.add(codigoBanco);
		codigoBanco.setLabelFor(texCodigoBanco);
		paiFormulario.add(texCodigoBanco);
		
		JLabel numeroConta = new JLabel ("N�mero da Conta: ");
		paiFormulario.add(numeroConta);
		numeroConta.setLabelFor(texNumeroConta);
		paiFormulario.add(texNumeroConta);
		
		JLabel mensagemCliente = new JLabel ("Mensagem ao Cliente: ");
		paiFormulario.add(mensagemCliente);
		mensagemCliente.setLabelFor(texMensagemCliente);
		paiFormulario.add(texMensagemCliente);
		
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(paiFormulario,
		3, 2, //rows, cols
		6, 6, //initX, initY
		6, 6); //xPad, yPad

		paiFormulario.setOpaque(true); //content panes must be opaque

		//Painel de Bot�es
		paiBotoes.add(botSalvar);
		paiBotoes.add(botCancelar);
		
		
		
	}

	public void setColunasTabela(){
		modelo.addColumn("C�digo do Banco");
		modelo.addColumn("Numero da Conta");
		modelo.addColumn("Mensagem ao Cliente");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}
