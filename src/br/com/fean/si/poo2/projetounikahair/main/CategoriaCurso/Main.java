package br.com.fean.si.poo2.projetounikahair.main;


import br.com.fean.si.poo2.projetounikahair.controller.CategoriaCursoController;
import br.com.fean.si.poo2.projetounikahair.view.Janela;
import br.com.fean.si.poo2.projetounikahair.view.PainelCRUDCategoriaCurso;
import java.sql.SQLException;





public class Principal {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
  PainelCRUDCategoriaCurso painelCRUDCategoriaCurso = new PainelCRUDCategoriaCurso();
  Janela janela= new Janela(painelCRUDCategoriaCurso);
    CategoriaCursoController categoriaCursoController = 
        new CategoriaCursoController(painelCRUDCategoriaCurso);       
        
    }
}
