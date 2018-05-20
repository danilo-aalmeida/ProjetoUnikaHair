package br.com.fean.si.poo2.projetounikahair.exemplos;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class PainelCRUDExemplo extends PainelCRUDGenerico implements ActionListener {
	//COMPONENTES TABELA
	private JTable tabTabela = new JTable();
	private DefaultTableModel modelo = (DefaultTableModel) tabTabela.getModel();
	JScrollPane scroll = new JScrollPane(tabTabela);
	//COMPONENTES FORMULARIO
	private JTextField texNome = new JTextField();
	private JTextField texDescricao = new JTextField();
	// COMPONENTES BOTOES
	private JButton botSalvar = new JButton("salvar");
	private JButton botCancelar = new JButton("cancelar");
	private JButton botNovo = new JButton("novo");
	private JButton botApagar = new JButton("apagar");
	//COMPONENTES PESQUISA
	private JLabel labPesquisa = new JLabel("Pesquisar por campanha:");
	private JTextField texPesquisa = new JTextField(20);
	private JButton botPesquisar = new JButton("pesquisar");
	private int idSelecionado=0;

	public PainelCRUDExemplo(){
		//PAINEL TOPO VAI O ROTULO DA FUNCIONALIDADE E A PESQUISA
		paiModulo.add(new Label("Campanhas promocionais"));
		paiPesquisa.add(labPesquisa);
		paiPesquisa.add(texPesquisa);
		paiPesquisa.add(botPesquisar);


		//PAINEL TABELA
		setColunasTabela();
		paiTabela.add(scroll);

		//PAINEL FORMULARIO
		JLabel labCampo1 = new JLabel("Nome:");
		paiFormulario.add(labCampo1);
		labCampo1.setLabelFor(texNome);
		paiFormulario.add(texNome);
		JLabel labCampo2 = new JLabel("Descrição:");
		paiFormulario.add(labCampo2);
		labCampo2.setLabelFor(texDescricao);
		paiFormulario.add(texDescricao);

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(paiFormulario,
				2, 2, //rows, cols
				6, 6, //initX, initY
				6, 6); //xPad, yPad

		paiFormulario.setOpaque(true); //content panes must be opaque


		//PAINEL BOTOES
		paiBotoes.add(botNovo);
		paiBotoes.add(botSalvar);
		paiBotoes.add(botCancelar);
		paiBotoes.add(botApagar);

		botSalvar.addActionListener(this);
		botPesquisar.addActionListener(this);
		botCancelar.addActionListener(this);
		botApagar.addActionListener(this);
		botNovo.addActionListener(this);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				// Implementação.
				JOptionPane.showMessageDialog(null, "Tecla "+evt.getKeyCode()+" foi pressionada");
			}
		});

		// Quando uma tecla for pressionada (Nesse exemplo escolhi a tecla 'B').
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		.addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent event) {
				if(event.getID() == KeyEvent.KEY_RELEASED 
						&& event.getKeyCode() == KeyEvent.VK_DELETE){
					// JOptionPane.showMessageDialog(null,"foi1");
					clicouApagar();
				}

				return false;
			}
		}); 
		tabTabela.addMouseListener(new MouseAdapter(){
			private int linha;
			private int coluna;
			@Override 
			public void mouseClicked(MouseEvent e) { 
				linha = tabTabela.getSelectedRow(); 
				coluna = tabTabela.getSelectedColumn(); 
				tabTabela.getColumnName(1);
				System.out.println(tabTabela.getColumnName(1));
				String id=(String) tabTabela.getValueAt(tabTabela.getSelectedRow(), 0);
				String nome=(String) tabTabela.getValueAt(tabTabela.getSelectedRow(), 1);
				String descricao=(String) tabTabela.getValueAt(tabTabela.getSelectedRow(), 2);
				//JOptionPane.showMessageDialog(null,"id = "+id+
				// " nome = "+nome+" email = "+email);
				texNome.setText(nome);
				texDescricao.setText(descricao);
				idSelecionado = Integer.parseInt(id);
				alterarStatusBotoesCampos(true,true,false,true, true, true,false); 
			} 
		});
		carregarDadosTabela();
		alterarStatusBotoesCampos(false,false,true,false, false, false,true);

	}

	public void clicouApagar(){
		if (idSelecionado!=0){
			apagar();
			carregarDadosTabela();
			alterarStatusBotoesCampos(false,false,true,false, false, false,true);
		}else{
			JOptionPane.showMessageDialog(null,"Para apagar você precisa selecionar uma linha na tabela");
		}
	}

	public void setColunasTabela(){
		modelo.addColumn("id");
		modelo.addColumn("nome");
		modelo.addColumn("descricao");


	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JOptionPane.showMessageDialog(null,"clicou");
		if (ae.getSource()==botSalvar){
			if (idSelecionado==0){
				inserir();
			}else{
				editar();
			}
			carregarDadosTabela();
			alterarStatusBotoesCampos(false,false,true,false, false, false,true);
		}else if (ae.getSource()==botPesquisar){
			pesquisar();
		}else if (ae.getSource()==botNovo){
			alterarStatusBotoesCampos(true,true,false,false, true, true,true);
		}else if (ae.getSource()==botApagar){
			apagar();
			carregarDadosTabela();
			alterarStatusBotoesCampos(false,false,true,false, false, false,true);
		}else if (ae.getSource()==botCancelar){
			alterarStatusBotoesCampos(false,false,true,false, false, false,true);
		}

	}
	public void alterarStatusBotoesCampos(boolean nome,
			boolean descricao, boolean novo, boolean apagar,
			boolean salvar, boolean cancelar, boolean limpaCampos){
		texNome.setEnabled(nome);
		texDescricao.setEnabled(descricao);
		botNovo.setVisible(novo);
		botApagar.setVisible(apagar);
		botSalvar.setVisible(salvar);
		botCancelar.setVisible(cancelar);
		if (limpaCampos){
			idSelecionado=0;
			texNome.setText("");
			texDescricao.setText("");
		}
	}
	public void inserir(){
		try {

			Class.forName ("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/teste?user=root");

			PreparedStatement ps = con.prepareStatement("INSERT INTO promocao (nome, descricao) VALUES (?,?)"); 
			ps.setString(1,texNome.getText()); 
			ps.setString(2,texDescricao.getText()); 
			ps.execute ();
			JOptionPane.showMessageDialog(null,"dado inserido");

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PainelCRUDExemplo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(PainelCRUDExemplo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void editar(){
		try {

			Class.forName ("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/teste?user=root");

			PreparedStatement ps = con.prepareStatement("update teste set nome=?, descricao=? where id=?"); 
			ps.setString(1,texNome.getText()); 
			ps.setString(2,texDescricao.getText()); 
			ps.setInt(3,idSelecionado); 
			ps.execute ();
			JOptionPane.showMessageDialog(null,"dado alterado");


		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PainelCRUDExemplo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(PainelCRUDExemplo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void apagar(){
		try {


			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar a linha selecionada ?", "Informe", JOptionPane.YES_NO_OPTION);

			if (resposta == JOptionPane.YES_OPTION) { 
				Class.forName ("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/teste?user=root");

				PreparedStatement ps = con.prepareStatement("delete from promocao where id=?"); 
				ps.setInt(1,idSelecionado); 
				ps.execute ();
				JOptionPane.showMessageDialog(null,"dado apagado");
			}

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PainelCRUDExemplo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(PainelCRUDExemplo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	public void pesquisar(){
		modelo.setRowCount(0);
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/teste?user=root");

			PreparedStatement ps = con.prepareStatement("select * from promocao where nome like '%"+texPesquisa.getText()+"%'"); 
			ResultSet rs = ps.executeQuery ();
			while (rs.next()){
				//JOptionPane.showMessageDialog(null,"nome: "+rs.getString("nome") + " EMAIL: "+rs.getString("email"));
				modelo.addRow(new String[]{rs.getString("id"), rs.getString("nome"), rs.getString("descricao")});
			}


		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"erro "+e);
		}
	}

	public void carregarDadosTabela(){
		modelo.setRowCount(0);
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/teste?user=root");

			PreparedStatement ps = con.prepareStatement("select * from promocao ORDER BY NOME ASC"); 
			ResultSet rs = ps.executeQuery ();
			while (rs.next()){
				//JOptionPane.showMessageDialog(null,"nome: "+rs.getString("nome") + " EMAIL: "+rs.getString("email"));
				modelo.addRow(new String[]{rs.getString("id"), rs.getString("nome"), rs.getString("descricao")});
			}


		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"erro "+e);
		}

	}

}