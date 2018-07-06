package br.com.fean.si.poo2.projetounikahair.view;


import java.awt.Container;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Janela {

    public Janela(PainelCRUDCategoriaCurso painelCRUDCategoriaCurso) {
        JFrame janela = new JFrame("Cadastro Categoria Curso");
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setBounds(50, 100, 1000, 630);
        
        Container caixa = janela.getContentPane();

        caixa.add(painelCRUDCategoriaCurso);
        janela.setVisible(true);
    }

}
