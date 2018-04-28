package br.com.fean.si.poo2.projetounikahair.main;

import java.awt.Container;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import br.com.fean.si.poo2.projetounikahair.view.ConfigurarBoleto;


public class Janela {
      public static void main(String[] args) {
    JFrame janela = new JFrame("Unika Hair");
    janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
    janela.setBounds(50,100,1000,700);
   
    Container caixa = janela.getContentPane();
    JPanel p = new ConfigurarBoleto();
    
    caixa.add(p);
    //Lay out the panel.
        

    //janela.pack();
    janela.setVisible(true);
  }

}