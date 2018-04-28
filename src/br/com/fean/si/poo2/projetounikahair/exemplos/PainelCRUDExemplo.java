package br.com.fean.si.poo2.projetounikahair.exemplos;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author jordan
*/
public class PainelCRUDExemplo extends PainelCRUDGenerico implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//COMPONENTES TABELA
private JTable tabTabela = new JTable();
private DefaultTableModel modelo = (DefaultTableModel) tabTabela.getModel();
JScrollPane scroll = new JScrollPane(tabTabela);
//COMPONENTES FORMULARIO
private JTextField texCampo1 = new JTextField();
private JTextField texCampo2 = new JTextField();
// COMPONENTES BOTOES
private JButton botSalvar = new JButton("salvar");
private JButton botBotao2 = new JButton("cancelar");
//COMPONENTES PESQUISA
private JLabel labPesquisa = new JLabel("Pesquisar por campo X:");
private JTextField texPesquisa = new JTextField(20);
private JButton botPesquisar = new JButton("pesquisar");

public PainelCRUDExemplo(){
//PAINEL TOPO VAI O ROTULO DA FUNCIONALIDADE E A PESQUISA
paiModulo.add(new Label("NOME DO MÓDULO"));
paiPesquisa.add(labPesquisa);
paiPesquisa.add(texPesquisa);
paiPesquisa.add(botPesquisar);


//PAINEL TABELA
setColunasTabela();
paiTabela.add(scroll);

//PAINEL FORMULARIO
JLabel labCampo1 = new JLabel("nome campo 1:");
paiFormulario.add(labCampo1);
labCampo1.setLabelFor(texCampo1);
paiFormulario.add(texCampo1);
JLabel labCampo2 = new JLabel("nome campo 2:");
paiFormulario.add(labCampo2);
labCampo2.setLabelFor(texCampo2);
paiFormulario.add(texCampo2);

//Lay out the panel.
SpringUtilities.makeCompactGrid(paiFormulario,
2, 2, //rows, cols
6, 6, //initX, initY
6, 6); //xPad, yPad

paiFormulario.setOpaque(true); //content panes must be opaque


//PAINEL BOTOES
paiBotoes.add(botSalvar);
paiBotoes.add(botBotao2);

botSalvar.addActionListener(this);
}

public void setColunasTabela(){
modelo.addColumn("Coluna1");
modelo.addColumn("Coluna2");
modelo.addColumn("Coluna3");

}

@Override
public void actionPerformed(ActionEvent ae) {

//if (ae.getSource()==botSalvar)
JOptionPane.showMessageDialog(null,"o campo 1 é:"
+texCampo1.getText()+ " e o campo 2 é:"
+ texCampo2.getText() );

}
}
