package br.com.fean.si.poo2.projetounikahair.view;


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

import br.com.fean.si.poo2.projetounikahair.exemplos.PainelCRUDGenerico;
import br.com.fean.si.poo2.projetounikahair.exemplos.SpringUtilities;


public class PainelCRUDExemplo extends PainelCRUDGenerico implements ActionListener {
    //COMPONENTES TABELA
    private JTable tabTabela = new JTable();
    private DefaultTableModel modelo = (DefaultTableModel) tabTabela.getModel();
    JScrollPane scroll = new JScrollPane(tabTabela);
    //COMPONENTES FORMULARIO
    private JTextField texCampo1 = new JTextField();
    private JTextField texCampo2 = new JTextField();
    // COMPONENTES BOTOES
    private JButton botSalvar = new JButton("salvar");
    private JButton botCancelar = new JButton("cancelar");
    //COMPONENTES PESQUISA
    private JLabel labPesquisa = new JLabel("Pesquisar campanha:");
    private JTextField texPesquisa = new JTextField(20);
    private JButton botPesquisar = new JButton("pesquisar");
    
    public PainelCRUDExemplo(){
        //PAINEL TOPO VAI O ROTULO DA FUNCIONALIDADE E A PESQUISA
        paiModulo.add(new Label("Cadastro de campanhas promocionais"));
        paiPesquisa.add(labPesquisa);
        paiPesquisa.add(texPesquisa);
        paiPesquisa.add(botPesquisar);
        
        
        //PAINEL TABELA
        setColunasTabela();
        paiTabela.add(scroll);
        
        //PAINEL FORMULARIO
        JLabel labCampo1 = new JLabel("Nome:");
        paiFormulario.add(labCampo1);
        labCampo1.setLabelFor(texCampo1);
        paiFormulario.add(texCampo1);
        JLabel labCampo2 = new JLabel("Descrição:");
        paiFormulario.add(labCampo2);
        labCampo2.setLabelFor(texCampo2);
        paiFormulario.add(texCampo2);
        
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(paiFormulario,
                                        2, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad
        
        paiFormulario.setOpaque(true);  //content panes must be opaque
                
        
        //PAINEL BOTOES
        paiBotoes.add(botSalvar);
        paiBotoes.add(botCancelar);
        
        botSalvar.addActionListener(this);
    }
    
    public void setColunasTabela(){
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Descrição");
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null,"Nome: "+texCampo1.getText()+
                "\nDescrição: "+texCampo2.getText());
        
    }
}
