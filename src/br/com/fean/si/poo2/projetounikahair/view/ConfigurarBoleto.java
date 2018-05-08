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

	// Componentes de Pesquisa

	private JLabel labPesquisaNomeBanco = new JLabel("Pesquisar pelo Nome do Banco: ");
	private JTextField texPesquisaNomeBanco = new JTextField(50);
	private JButton botPesquisaNomeBanco = new JButton("Pesquisar");


	public ConfigurarBoleto () {
		//Painel que vai o Rotulo da Funcionalidade
		paiModulo.add(new Label("Configurar Boleto"));

		//Painel de Pesquisa
		paiPesquisa.add(labPesquisaNomeBanco);
		paiPesquisa.add(texPesquisaNomeBanco);
		paiPesquisa.add(botPesquisaNomeBanco);

		//Painel da Tabela
		setColunasTabela();
		paiTabela.add(scroll);
		
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

		//Painel de Botões
		paiBotoes.add(botSalvar);
		paiBotoes.add(botCancelar);
		
		
		
	}

	public void setColunasTabela(){
		modelo.addColumn("Código do Banco");
		modelo.addColumn("Nome do Banco");
		modelo.addColumn("Numero da Conta");
		modelo.addColumn("Mensagem ao Cliente");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}
