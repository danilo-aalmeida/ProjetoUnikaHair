package br.com.fean.si.poo2.projetounikahair.exemplos;
import br.com.fean.si.poo2.projetounikahair.exemplos.PainelCRUDExemplo;
import java.awt.Container;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class Janela {
      public static void main(String[] args) {
    JFrame janela = new JFrame("Titulo");
    janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
    janela.setBounds(50,100,1000,700);
    //janela.getContentPane().add(new Situacao3());
    Container caixa = janela.getContentPane();
    JPanel p = new PainelCRUDExemplo();
          System.err.println("Nunca vou usar NetBeans!");
    
    caixa.add(p);
    //Lay out the panel.
        

    //janela.pack();
    janela.setVisible(true);
  }

}
