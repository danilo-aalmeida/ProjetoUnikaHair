package br.com.fean.si.poo2.projetounikahair.main;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.fean.si.poo2.projetounikahair.view.exemploVeppo.ExemploPanel;

/**
 * @author joao(jhveppo@gmail.com)
 *
 */
public class Principal {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Unika Hair");
	    janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    janela.setBounds(50,100,1000,700);
	    //janela.getContentPane().add(new Situacao3());
	    Container caixa = janela.getContentPane();
	    JPanel p = new ExemploPanel();
	    
	    caixa.add(p);
	    //Lay out the panel.
	        

	    //janela.pack();
	    janela.setVisible(true);
		
		/*ExemploDAO exemploDao = DAOFactory.cadastreExemploDAO();
		Exemplo novoEx = new Exemplo();
		novoEx.setNome("João Henrique Veppo");
		novoEx.setValor(50.0);
		
		try {
			exemploDao.cadastrarNovoExemplo(novoEx);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
