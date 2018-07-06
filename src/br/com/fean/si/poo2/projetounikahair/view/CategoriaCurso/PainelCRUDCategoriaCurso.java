package br.com.fean.si.poo2.projetounikahair.view;


import java.awt.Label;


import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

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
public class PainelCRUDCategoriaCurso extends PainelCRUDGenerico {

    //COMPONENTES TABELA
    private JTable tabTabela = new JTable();
    private DefaultTableModel modelo = (DefaultTableModel) tabTabela.getModel();
    JScrollPane scroll = new JScrollPane(tabTabela);
    //COMPONENTES FORMULARIO
    private JTextField texNomeCC = new JTextField();
    private JTextField texDesc = new JTextField();
    // COMPONENTES BOTOES
    private JButton botNovo = new JButton("Novo");
    private JButton botCancelar = new JButton("Cancelar");
    private JButton botSalvar = new JButton("Salvar");
    private JButton botApagar = new JButton("Excluir");

    //COMPONENTES PESQUISA
    private JLabel labPesquisa = new JLabel("Pesquisar por campo X:");
    private JTextField texPesquisa = new JTextField(20);
    private JButton botPesquisar = new JButton("pesquisar");

    public PainelCRUDCategoriaCurso() {
        //PAINEL TOPO VAI O ROTULO DA FUNCIONALIDADE E A PESQUISA
        paiModulo.add(new Label("Categoria de Curso"));
        paiPesquisa.add(labPesquisa);
        paiPesquisa.add(texPesquisa);
        paiPesquisa.add(botPesquisar);

        paiTabela.add(scroll);

        //PAINEL FORMULARIO
        JLabel labCampo1 = new JLabel("Nome da categoria de curso: ");
        paiFormulario.add(labCampo1);
        labCampo1.setLabelFor(texNomeCC);
        paiFormulario.add(texNomeCC);
        JLabel labCampo2 = new JLabel("Descrição: ");
        paiFormulario.add(labCampo2);
        labCampo2.setLabelFor(texDesc);
        paiFormulario.add(texDesc);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(paiFormulario,
                2, 2, //rows, cols
                6, 6, //initX, initY
                6, 6);       //xPad, yPad

        paiFormulario.setOpaque(true);  //content panes must be opaque

        //PAINEL BOTOES
        paiBotoes.add(botNovo);
        paiBotoes.add(botSalvar);
        paiBotoes.add(botCancelar);
        paiBotoes.add(botApagar);

        modelo.addColumn("ID");
        modelo.addColumn("Categoria de Curso");
        modelo.addColumn("Descrição");
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

    public JTextField getTexNomeCC() {
        return texNomeCC;
    }

    public void setTexNomeCC(JTextField texNomeCC) {
        this.texNomeCC = texNomeCC;
    }

    public JTextField getTexDesc() {
        return texDesc;
    }

    public void setTexDesc(JTextField texDesc) {
        this.texDesc = texDesc;
    }

    public JButton getBotNovo() {
        return botNovo;
    }

    public void setBotNovo(JButton botNovo) {
        this.botNovo = botNovo;
    }

    public JButton getBotCancelar() {
        return botCancelar;
    }

    public void setBotCancelar(JButton botCancelar) {
        this.botCancelar = botCancelar;
    }

    public JButton getBotSalvar() {
        return botSalvar;
    }

    public void setBotSalvar(JButton botSalvar) {
        this.botSalvar = botSalvar;
    }

    public JButton getBotApagar() {
        return botApagar;
    }

    public void setBotApagar(JButton botApagar) {
        this.botApagar = botApagar;
    }

    public JLabel getLabPesquisa() {
        return labPesquisa;
    }

    public void setLabPesquisa(JLabel labPesquisa) {
        this.labPesquisa = labPesquisa;
    }

    public JTextField getTexPesquisa() {
        return texPesquisa;
    }

    public void setTexPesquisa(JTextField texPesquisa) {
        this.texPesquisa = texPesquisa;
    }

    public JButton getBotPesquisar() {
        return botPesquisar;
    }

    public void setBotPesquisar(JButton botPesquisar) {
        this.botPesquisar = botPesquisar;
    }

}
