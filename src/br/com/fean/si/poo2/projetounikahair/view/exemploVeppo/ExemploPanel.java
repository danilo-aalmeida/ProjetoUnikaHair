package br.com.fean.si.poo2.projetounikahair.view.exemploVeppo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fean.si.poo2.projetounikahair.controller.exemploVeppo.ExemploManagerBean;
import br.com.fean.si.poo2.projetounikahair.exemplos.SpringUtilities;
import br.com.fean.si.poo2.projetounikahair.model.exemploVeppo.Exemplo;
import br.com.fean.si.poo2.projetounikahair.view.AbstractPanel;

/**
 * @author joao(jhveppo@gmail.com)
 *
 */
public class ExemploPanel extends AbstractPanel implements ActionListener {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	// COMPONENTES TABELA
	private JTable tabTabela = new JTable();
	private DefaultTableModel modelo = (DefaultTableModel) tabTabela.getModel();
	JScrollPane scroll = new JScrollPane(tabTabela);
	// COMPONENTES FORMULARIO
	private JTextField texCampo1 = new JTextField();
	private JTextField texCampo2 = new JTextField();
	// COMPONENTES BOTOES
	private JButton botSalvar = new JButton("salvar");
	private JButton botCancelar = new JButton("cancelar");
	// COMPONENTES PESQUISA
	private JLabel labPesquisa = new JLabel("Pesquisa Geral (Código / nome / valor):");
	private JTextField texPesquisa = new JTextField(20);
	private JButton botPesquisar = new JButton("pesquisar");
	private ExemploManagerBean exemploManager;
	private Exemplo sample;

	public ExemploPanel() {
		exemploManager = new ExemploManagerBean();
		resetarSample();
		
		// PAINEL TOPO VAI O ROTULO DA FUNCIONALIDADE E A PESQUISA
		paiModulo.add(new JLabel("CRUD Exemplo Veppo"));
		paiPesquisa.add(labPesquisa);
		paiPesquisa.add(texPesquisa);
		paiPesquisa.add(botPesquisar);

		// PAINEL TABELA
		setColunasTabela();
		paiTabela.add(scroll);

		// PAINEL FORMULARIO
		JLabel labCampo1 = new JLabel("Nome:");
		paiFormulario.add(labCampo1);
		labCampo1.setLabelFor(texCampo1);
		paiFormulario.add(texCampo1);
		JLabel labCampo2 = new JLabel("Valor:");
		paiFormulario.add(labCampo2);
		labCampo2.setLabelFor(texCampo2);
		paiFormulario.add(texCampo2);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(paiFormulario, 2, 2, // rows, cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		paiFormulario.setOpaque(true); // content panes must be opaque

		// PAINEL BOTOES
		paiBotoes.add(botSalvar);
		paiBotoes.add(botCancelar);

		botSalvar.addActionListener(this);
		botCancelar.addActionListener(this);
		botPesquisar.addActionListener(this);
		carregarRegistros();
	}

	private void carregarRegistros() {
		List<Exemplo> retorno = exemploManager.carregarRegistros();
		popularModelo(retorno);
	}

	private void popularModelo(List<Exemplo> retorno) {
		modelo.setRowCount(0);
		if(retorno != null) {
			for (Exemplo registro : retorno) {
				modelo.addRow(new String [] {registro.getId().toString(), registro.getNome(),registro.getValor().toString()});
			}
		}
	}

	public void setColunasTabela() {
		modelo.addColumn("Código");
		modelo.addColumn("Nome");
		modelo.addColumn("Valor");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(botSalvar)){
			processarRegistroNovoExemplo();
		} if (ae.getSource().equals(botPesquisar)){
			List<Exemplo> retorno = exemploManager.carregarRegistrosPorFiltro(texPesquisa.getText());
			popularModelo(retorno);
		}
	}

	private void processarRegistroNovoExemplo() {
		sample.setNome(texCampo1.getText());
		sample.setValor(Double.parseDouble(texCampo2.getText()));
		exemploManager.cadastrarRegistro(sample);
		carregarRegistros();
		resetarSample();
	}

	private void resetarSample() {
		sample = new Exemplo();
		texCampo1.setText("");
		texCampo2.setText("");
	}
}
