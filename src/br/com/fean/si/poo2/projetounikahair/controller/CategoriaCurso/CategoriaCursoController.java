/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.projetounikahair.controller;

import br.com.fean.si.poo2.projetounikahair.model.CategoriaCurso;
import br.com.fean.si.poo2.projetounikahair.services.CategoriaCursoService;
import br.com.fean.si.poo2.projetounikahair.view.PainelCRUDCategoriaCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class CategoriaCursoController implements ActionListener {

    PainelCRUDCategoriaCurso painel = null;
    CategoriaCursoService categoriaCursoService = new CategoriaCursoService();
    int idSelecionado = 0;

    public CategoriaCursoController(PainelCRUDCategoriaCurso painelCrudCategoriaCurso) {
        painel = painelCrudCategoriaCurso;
        painel.getBotSalvar().addActionListener(this);
        painel.getBotPesquisar().addActionListener(this);
        painel.getBotCancelar().addActionListener(this);
        painel.getBotApagar().addActionListener(this);
        painel.getBotNovo().addActionListener(this);
        
        painel.getTabTabela().addMouseListener(new MouseAdapter() {
            private int linha;
            private int coluna;

            @Override
            public void mouseClicked(MouseEvent e) {
                linha = painel.getTabTabela().getSelectedRow();
                coluna = painel.getTabTabela().getSelectedColumn();
                painel.getTabTabela().getColumnName(1);
                String id = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 0);
                String nomeCC = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 1);
                String descricao = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 2);
              
                painel.getTexNomeCC().setText(nomeCC);
                painel.getTexDesc().setText(descricao);
                idSelecionado = Integer.parseInt(id);
                StatusBotoes(true, true, false, true, true, true, false);
            }
        });
        carregarDadosTabela();
        StatusBotoes(false, false, true, false, false, false, true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == painel.getBotSalvar()) {
            if (idSelecionado == 0) {

                inserir();

            } else {

                editar();

            }
            StatusBotoes(false, false, true, false, false, false, true);
            carregarDadosTabela();

        } else if (ae.getSource() == painel.getBotPesquisar()) {

            pesquisar();

        } else if (ae.getSource() == painel.getBotApagar()) {
            excluir();
            carregarDadosTabela();
            StatusBotoes(false, false, true, false, false, false, true);

        } else if (ae.getSource() == painel.getBotCancelar()) {
            StatusBotoes(false, false, true, false, false, false, true);
        } else if (ae.getSource() == painel.getBotNovo()) {
            StatusBotoes(true, true, false, false, true, true, true);

        }
    }

    public void StatusBotoes(boolean nome, boolean descricao, boolean novo, boolean apagar, boolean salvar, boolean cancelar, boolean limparcampos) {
        painel.getTexNomeCC().setEnabled(nome);
        painel.getTexDesc().setEnabled(descricao);
        painel.getBotNovo().setVisible(novo);
        painel.getBotApagar().setVisible(apagar);
        painel.getBotSalvar().setVisible(salvar);
        painel.getBotCancelar().setVisible(cancelar);
        if (limparcampos) {
            idSelecionado = 0;
            painel.getTexNomeCC().setText("");
            painel.getTexDesc().setText("");
        }

    }

    public void carregarDadosTabela() {
        painel.getModelo().setRowCount(0);
        ArrayList<CategoriaCurso> lista = new ArrayList<CategoriaCurso>();
        lista = categoriaCursoService.listar("");
        try {
            for (CategoriaCurso categoriaCurso : lista) {
                painel.getModelo().addRow(new String[]{categoriaCurso.getId() + "", categoriaCurso.getNomeCC(), categoriaCurso.getDescricao()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro " + e);

        }
    }

    public void inserir() {
        String retorno = "";
        try {
            retorno = categoriaCursoService.inserir(painel.getTexNomeCC().getText(), painel.getTexDesc().getText());
            JOptionPane.showMessageDialog(null, retorno);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, retorno);
        }
    }

    public void editar() {
        String retorno = "";
        try {
            retorno = categoriaCursoService.editar(idSelecionado, painel.getTexNomeCC().getText(), painel.getTexDesc().getText());
            JOptionPane.showMessageDialog(null, retorno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, retorno);
        }
    }

    public void excluir() {
        String retorno = "";
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar a linha selecionada ?", "Informe", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                retorno = categoriaCursoService.apagar(idSelecionado);
                JOptionPane.showMessageDialog(null, retorno);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, retorno);
        }

    }

    public void pesquisar() {
        painel.getModelo().setRowCount(0);
        ArrayList<CategoriaCurso> lista = new ArrayList<CategoriaCurso>();;
        lista = categoriaCursoService.listar(painel.getTexPesquisa().getText());
        try {
            for (CategoriaCurso categoriaCurso : lista) {
           painel.getModelo().addRow(new String[]{categoriaCurso.getId()+"", categoriaCurso.getNomeCC(), categoriaCurso.getDescricao()});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro " + e);
        }
    }
}
