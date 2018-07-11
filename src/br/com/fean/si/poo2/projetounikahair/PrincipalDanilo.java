package br.com.fean.si.poo2.projetounikahair;

import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.controller.boleto.ConfigurarBoletoController;
import br.com.fean.si.poo2.projetounikahair.controller.categoriacurso.CategoriaCursoController;
import br.com.fean.si.poo2.projetounikahair.dao.DAOException;
import br.com.fean.si.poo2.projetounikahair.view.boleto.JanelaConfigurarBoleto;
import br.com.fean.si.poo2.projetounikahair.view.boleto.PainelConfigurarBoleto;
import br.com.fean.si.poo2.projetounikahair.view.categoriacurso.JanelaCategoriaCurso;
import br.com.fean.si.poo2.projetounikahair.view.categoriacurso.PainelCategoriaCurso;

public class PrincipalDanilo {

	PainelConfigurarBoleto painelConfigurarBoleto = new PainelConfigurarBoleto();
	PainelCategoriaCurso painelCategoriaCurso = new PainelCategoriaCurso();


	public static void main(String[] args) throws DAOException {

		PrincipalDanilo principal = new PrincipalDanilo();
		principal.mostrarMenu();



	}


	@SuppressWarnings({ "unused" })
	private void mostrarMenu() throws DAOException{
		int opcao = 0;
		String opUsuario = null;
		do{
			opUsuario = JOptionPane.showInputDialog("Selecione uma opção:\n"
					+ "1 - Painel Configurar Boleto\n"
					+ "2 - Painel Categoria Curso\n"
					+ "3 - Painel Cadastrar Produto");
			if(opUsuario != null){
				opcao = new Integer (opUsuario);
			};
			if (opcao == 1) {

				JanelaConfigurarBoleto janelaConfigurarBoleto = new JanelaConfigurarBoleto(painelConfigurarBoleto);
				ConfigurarBoletoController configurarBoletoController = new ConfigurarBoletoController(painelConfigurarBoleto);
			} else if (opcao == 2) {
				JanelaCategoriaCurso janelaCategoriaCurso = new JanelaCategoriaCurso(painelCategoriaCurso);
				CategoriaCursoController categoriaCursoController = new CategoriaCursoController(painelCategoriaCurso);
			} else if (opcao == 3) {
				JOptionPane.showMessageDialog(null, "Opção em andamento");
			}else {
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
			opcao = 0;
			opUsuario = null;

		} while (opUsuario != null);
	}

}
