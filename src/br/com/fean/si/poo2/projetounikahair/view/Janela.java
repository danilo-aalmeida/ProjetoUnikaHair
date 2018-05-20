package br.com.fean.si.poo2.projetounikahair.view;

import java.awt.Container;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import br.com.fean.si.poo2.projetounikahair.exemplos.PainelCRUDExemplo;


public class Janela {
      public static void main(String[] args) {
    JFrame janela = new JFrame("Titulo");
    janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
    janela.setBounds(50,100,1000,700);
    //janela.getContentPane().add(new Situacao3());
    Container caixa = janela.getContentPane();
    JPanel p = new PainelCRUDExemplo();
    
    caixa.add(p);
    //Lay out the panel.
        

    //janela.pack();X
    janela.setVisible(true);
  }

}
