package br.com.fean.si.poo2.projetounikahair.view;

import br.com.fean.si.poo2.projetounikahair.model.CategoriaCurso;
import br.com.fean.si.poo2.projetounikahair.service.CategoriaCursoService;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PainelCategoriaCurso extends PainelCRUDGenerico  {
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
    private JLabel labPesquisa = new JLabel("Pesquisar por campo X:");
    private JTextField texPesquisa = new JTextField(20);
    private JButton botPesquisar = new JButton("pesquisar");
    
    
    
    
    public PainelCategoriaCurso(){
        //PAINEL TOPO VAI O ROTULO DA FUNCIONALIDADE E A PESQUISA
        paiModulo.add(new Label("CATEGORIA DE CURSO"));
        paiPesquisa.add(labPesquisa);
        paiPesquisa.add(texPesquisa);
        paiPesquisa.add(botPesquisar);
        
        
        
        paiTabela.add(scroll);
        
        //PAINEL FORMULARIO
        JLabel labNome = new JLabel("NOME:");
        paiFormulario.add(labNome);
        labNome.setLabelFor(texNome);
        paiFormulario.add(texNome);
        JLabel labDescricao = new JLabel("DESCRIÇÃO:");
        paiFormulario.add(labDescricao);
        labDescricao.setLabelFor(texDescricao);
        paiFormulario.add(texDescricao);
        
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(paiFormulario,
                                        2, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad
        
        paiFormulario.setOpaque(true);  //content panes must be opaque
                
        
        //PAINEL BOTOES
        paiBotoes.add(botNovo);
        paiBotoes.add(botSalvar);
        paiBotoes.add(botCancelar);
        paiBotoes.add(botApagar);
        
        modelo.addColumn("id");
        modelo.addColumn("nome");
        modelo.addColumn("descrição");
        
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

    public JTextField getTexNome() {
        return texNome;
    }

    public void setTexNome(JTextField texNome) {
        this.texNome = texNome;
    }

    public JTextField getTexDescricao() {
        return texDescricao;
    }

    public void setTexDescricao(JTextField texDescricao) {
        this.texDescricao = texDescricao;
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
