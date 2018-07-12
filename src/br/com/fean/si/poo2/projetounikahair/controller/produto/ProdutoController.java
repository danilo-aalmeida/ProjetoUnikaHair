package br.com.fean.si.poo2.projetounikahair.controller.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.model.produto.Produto;
import br.com.fean.si.poo2.projetounikahair.service.produto.ProdutoService;
import br.com.fean.si.poo2.projetounikahair.util.DAOException;
import br.com.fean.si.poo2.projetounikahair.view.produto.PainelProduto;

public class ProdutoController implements ActionListener{
	PainelProduto painel = null;
	ProdutoService produtoService = new ProdutoService();
	int codigoSelecionado = 0;

	
	public ProdutoController (PainelProduto painelProduto) throws DAOException {
		painel = painelProduto;
		painel.getBotApagar().addActionListener(this);
		painel.getBotCancelar().addActionListener(this);
		painel.getBotNovo().addActionListener(this);
		painel.getBotPesquisaNomeProduto().addActionListener(this);
		painel.getBotSalvar().addActionListener(this);
		
		
		painel.getTabTabela().addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			private int linha;

			@SuppressWarnings("unused")
			private int coluna;
		
			@Override
			public void mouseClicked (MouseEvent e) {
				linha = painel.getTabTabela().getSelectedRow();
				coluna = painel.getTabTabela().getSelectedColumn();
				painel.getTabTabela().getColumnName(1);
				
				String codigoProduto = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 0);
				String nomeProduto = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 1);
				String precoVenda = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 2);
				String estoqueMinimo = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 3);
				String quantidadeEstoque = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 4);
				String marca = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 5);
				String categoriaProduto = (String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 6);

				painel.getTexCodigoProduto().setText(codigoProduto);
				painel.getTexNomeProduto().setText(nomeProduto);
				painel.getTexPrecoVenda().setText(precoVenda);
				painel.getTexEstoqueMinimo().setText(estoqueMinimo);
				painel.getTexQuantidadeEstoque().setText(quantidadeEstoque);
				painel.getTexMarca().setText(marca);
				painel.getTexCategoriaProduto().setText(categoriaProduto);
				codigoSelecionado = Integer.parseInt(codigoProduto);

				alterarStatusBotoesCampos(true,true,true,true,true,true,true,false,true, true, true,false);
			}
		});
		carregarTabelaTotal();
		alterarStatusBotoesCampos(false,false,false,false,false,false,false,true,false,false,false,true);
		
	}
	
	public void preencherTabela(List<Produto> listaProdutos) {
		painel.getModelo().setRowCount(0);
		for (Produto produto : listaProdutos) {
			painel.getModelo().addRow(new String[]{produto.getCodigoProduto().toString(), produto.getNomeProduto(), 
					produto.getPrecoVenda().toString(), produto.getEstoqueMinimo().toString(), produto.getQuantidadeEstoque().toString(), 
					produto.getMarca(), produto.getCategoriaProduto()});
		}
	}
	
	public void carregarTabelaTotal() throws DAOException {
		painel.getModelo().setRowCount(0);
		List<Produto> listaTodosProdutos = new ArrayList<Produto>();
		listaTodosProdutos = produtoService.listarTodos();
		preencherTabela(listaTodosProdutos);
	}
		
		public void limparCampos () {
			painel.getTexCodigoProduto().setText("");
			painel.getTexNomeProduto().setText("");
			painel.getTexPrecoVenda().setText("");
			painel.getTexEstoqueMinimo().setText("");
			painel.getTexQuantidadeEstoque().setText("");
			painel.getTexMarca().setText("");
			painel.getTexCategoriaProduto().setText("");
			painel.getTexPesquisaNomeProduto().setText("");
		}
		
		public void alterarStatusBotoesCampos(boolean codigoProduto, boolean nomeProduto, boolean precoVenda, 
				boolean estoqueMinimo, boolean quantidadeEstoque, boolean marca, boolean categoriaProduto, boolean novo, boolean apagar, boolean salvar, boolean cancelar,
				boolean limpaCampos) {

			painel.getTexCodigoProduto().setEnabled(codigoProduto); 
			painel.getTexNomeProduto().setEnabled(nomeProduto); 
			painel.getTexPrecoVenda().setEnabled(precoVenda); 
			painel.getTexEstoqueMinimo().setEnabled(estoqueMinimo); 
			painel.getTexQuantidadeEstoque().setEnabled(quantidadeEstoque); 
			painel.getTexMarca().setEnabled(marca); 
			painel.getTexCategoriaProduto().setEnabled(categoriaProduto); 

			painel.getBotNovo().setVisible(novo); 
			painel.getBotApagar().setVisible(apagar); 
			painel.getBotSalvar().setVisible(salvar); 
			painel.getBotCancelar().setVisible(cancelar); 

			if (limpaCampos) {
				codigoSelecionado = 0;
				limparCampos();
			}
		}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(painel.getBotSalvar())) {
			
			if(codigoSelecionado==0) {
				try {
					
					produtoService.inserir(Integer.parseInt(painel.getTexCodigoProduto().getText()),
					painel.getTexNomeProduto().getText(),
					Double.parseDouble(painel.getTexPrecoVenda().getText()),
					Integer.parseInt(painel.getTexEstoqueMinimo().getText()),
					Integer.parseInt(painel.getTexQuantidadeEstoque().getText()),
					painel.getTexMarca().getText(),
					painel.getTexCategoriaProduto().getText());
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					
					produtoService.editar(Integer.parseInt(painel.getTexCodigoProduto().getText()),
							painel.getTexNomeProduto().getText(),
							Double.parseDouble(painel.getTexPrecoVenda().getText()),
							Integer.parseInt(painel.getTexEstoqueMinimo().getText()),
							Integer.parseInt(painel.getTexQuantidadeEstoque().getText()),
							painel.getTexMarca().getText(),
							painel.getTexCategoriaProduto().getText(), codigoSelecionado);
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
			}
			alterarStatusBotoesCampos(false, false, false, false,false,false,false, true, false, false, false,true);
		} else if (ae.getSource().equals(painel.getBotPesquisaNomeProduto())) {
			try {
				List<Produto> listaProdutosPesquisados = new ArrayList<Produto>();
				listaProdutosPesquisados = produtoService.listarPorNome(painel.getTexPesquisaNomeProduto().getText());
				limparCampos();
				preencherTabela(listaProdutosPesquisados);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} else if (ae.getSource().equals(painel.getBotNovo())) {
			alterarStatusBotoesCampos(true,true,true,true,true,true,true,false,false,true,true,true);
		} else if (ae.getSource().equals(painel.getBotApagar())) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar o produto selecionado ?", "Informe", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				try {
					produtoService.apagar(codigoSelecionado);
					limparCampos();
					carregarTabelaTotal();
				} catch (DAOException e) {
					e.printStackTrace();
				}
				alterarStatusBotoesCampos(false,false,false,false,false,false,false,true,false,false,false,true);
			}
		} else if (ae.getSource().equals(painel.getBotCancelar())) {
			alterarStatusBotoesCampos(false,false,false,false,false,false,false,true,false,false,false,true);
		}
		
	}
	
	
	
}
