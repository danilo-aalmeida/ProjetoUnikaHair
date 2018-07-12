package br.com.fean.si.poo2.projetounikahair.view.produto;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fean.si.poo2.projetounikahair.util.DAOException;
import br.com.fean.si.poo2.projetounikahair.view.PainelCRUDGenerico;
import br.com.fean.si.poo2.projetounikahair.view.SpringUtilities;

public class PainelProduto extends PainelCRUDGenerico{

	/* Descrição: O sistema deve permitir ao usuário informar os dados para a geração do 
	 boleto, tais como: código do banco, nro da conta, mensagem ao cliente... 
	 */

	//Componentes da Tabela
	private static final long serialVersionUID = 1L;
	private JTable tabTabela = new JTable ();
	private DefaultTableModel modelo = (DefaultTableModel) tabTabela.getModel();
	JScrollPane scroll = new JScrollPane(tabTabela);

	//Componentes do Formulário
	private JTextField texCodigoProduto = new JTextField();
	private JTextField texNomeProduto = new JTextField();
	private JTextField texPrecoVenda = new JTextField();
	private JTextField texEstoqueMinimo = new JTextField();
	private JTextField texQuantidadeEstoque = new JTextField();
	private JTextField texMarca = new JTextField();
	private JTextField texCategoriaProduto = new JTextField();

	// Componentes dos Botões
	private JButton botSalvar = new JButton("Salvar");
	private JButton botCancelar = new JButton("Cancelar");
	private JButton botNovo = new JButton("Novo");
	private JButton botApagar = new JButton("Apagar");

	// Componentes de Pesquisa
	private JLabel labPesquisaNomeProduto = new JLabel("Pesquisar pelo Nome do Produto: ");
	private JTextField texPesquisaNomeProduto = new JTextField(50);
	private JButton botPesquisaNomeProduto = new JButton("Pesquisar");
	//private int codigoSelecionado = 0 ;
	
	// Instanciando Classe de Manipulação DAO
	/*private JDBCBoletoDAO jdbcBoleto = new JDBCBoletoDAO(); */

	public PainelProduto () {
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
		paiModulo.add(new Label("Cadastrar Produto"));
	}
	
	public void setPainelDePesquisa () {
		//Painel de Pesquisa
		paiPesquisa.add(labPesquisaNomeProduto);
		paiPesquisa.add(texPesquisaNomeProduto);
		paiPesquisa.add(botPesquisaNomeProduto);
	}
	
	public void setPainelDaTabela() {
		//Painel da Tabela
		setColunasTabela();
		paiTabela.add(scroll);
	}
	
	public void setPainelDoFormulario() {
		//Painel do Formulario
		JLabel codigoProduto = new JLabel ("Código do Produto: ");
		paiFormulario.add(codigoProduto);
		codigoProduto.setLabelFor(texCodigoProduto);
		paiFormulario.add(texCodigoProduto);

		JLabel nomeProduto = new JLabel ("Nome do Produto: ");
		paiFormulario.add(nomeProduto);
		nomeProduto.setLabelFor(texNomeProduto);
		paiFormulario.add(texNomeProduto);		

		JLabel precoVenda = new JLabel ("Preço de Venda: ");
		paiFormulario.add(precoVenda);
		precoVenda.setLabelFor(texPrecoVenda);
		paiFormulario.add(texPrecoVenda);

		JLabel estoqueMinimo = new JLabel ("Estoque Mínimo: ");
		paiFormulario.add(estoqueMinimo);
		estoqueMinimo.setLabelFor(texEstoqueMinimo);
		paiFormulario.add(texEstoqueMinimo);
		
		JLabel quantidadeEstoque = new JLabel ("Quantidade em Estoque: ");
		paiFormulario.add(quantidadeEstoque);
		quantidadeEstoque.setLabelFor(texQuantidadeEstoque);
		paiFormulario.add(texQuantidadeEstoque);
		
		JLabel marcaProduto = new JLabel ("Marca: ");
		paiFormulario.add(marcaProduto);
		marcaProduto.setLabelFor(texMarca);
		paiFormulario.add(texMarca);
		
		JLabel categoriaProduto = new JLabel ("Categoria do Produto: ");
		paiFormulario.add(categoriaProduto);
		categoriaProduto.setLabelFor(texCategoriaProduto);
		paiFormulario.add(texCategoriaProduto);

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(paiFormulario,
				7, 2, //rows, cols
				6, 6, //initX, initY
				6, 6); //xPad, yPad

		paiFormulario.setOpaque(true); //content panes must be opaque
	}
	
	public void setColunasTabela(){
		modelo.addColumn("Código do Produto");
		modelo.addColumn("Nome do Produto");
		modelo.addColumn("Preço de Venda");
		modelo.addColumn("Estoque Mínimo");
		modelo.addColumn("Quantidade em Estoque");
		modelo.addColumn("Marca");
		modelo.addColumn("Categoria do Produto");
	}
	
	public void setPainelDeBotoes() throws DAOException {
		//Painel de Botões
		paiBotoes.add(botNovo);
		paiBotoes.add(botSalvar);
		paiBotoes.add(botCancelar);
		paiBotoes.add(botApagar);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public JTextField getTexCodigoProduto() {
		return texCodigoProduto;
	}

	public void setTexCodigoProduto(JTextField texCodigoProduto) {
		this.texCodigoProduto = texCodigoProduto;
	}

	public JTextField getTexNomeProduto() {
		return texNomeProduto;
	}

	public void setTexNomeProduto(JTextField texNomeProduto) {
		this.texNomeProduto = texNomeProduto;
	}

	public JTextField getTexPrecoVenda() {
		return texPrecoVenda;
	}

	public void setTexPrecoVenda(JTextField texPrecoVenda) {
		this.texPrecoVenda = texPrecoVenda;
	}

	public JTextField getTexEstoqueMinimo() {
		return texEstoqueMinimo;
	}

	public void setTexEstoqueMinimo(JTextField texEstoqueMinimo) {
		this.texEstoqueMinimo = texEstoqueMinimo;
	}

	public JTextField getTexQuantidadeEstoque() {
		return texQuantidadeEstoque;
	}

	public void setTexQuantidadeEstoque(JTextField texQuantidadeEstoque) {
		this.texQuantidadeEstoque = texQuantidadeEstoque;
	}

	public JTextField getTexMarca() {
		return texMarca;
	}

	public void setTexMarca(JTextField texMarca) {
		this.texMarca = texMarca;
	}

	public JTextField getTexCategoriaProduto() {
		return texCategoriaProduto;
	}

	public void setTexCategoriaProduto(JTextField texCategoriaProduto) {
		this.texCategoriaProduto = texCategoriaProduto;
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

	public JLabel getLabPesquisaNomeProduto() {
		return labPesquisaNomeProduto;
	}

	public void setLabPesquisaNomeProduto(JLabel labPesquisaNomeProduto) {
		this.labPesquisaNomeProduto = labPesquisaNomeProduto;
	}

	public JTextField getTexPesquisaNomeProduto() {
		return texPesquisaNomeProduto;
	}

	public void setTexPesquisaNomeProduto(JTextField texPesquisaNomeProduto) {
		this.texPesquisaNomeProduto = texPesquisaNomeProduto;
	}

	public JButton getBotPesquisaNomeProduto() {
		return botPesquisaNomeProduto;
	}

	public void setBotPesquisaNomeProduto(JButton botPesquisaNomeProduto) {
		this.botPesquisaNomeProduto = botPesquisaNomeProduto;
	}

	
	
}