package br.com.fean.si.poo2.projetounikahair.view.boleto;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Container;

import javax.swing.JFrame;

public class JanelaConfigurarBoleto {


	public JanelaConfigurarBoleto (PainelConfigurarBoleto painelConfigurarBoleto) {
	
		JFrame janela = new JFrame("Unika Hair");
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.setBounds(50,100,1000,700);

		Container caixa = janela.getContentPane();
		

		caixa.add(painelConfigurarBoleto);
		//Lay out the panel.

		//janela.pack();
		janela.setVisible(true);
	}
}