
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jordan
 */
public class TesteRemovendoDisciplinasCursoEListandoDisciplinasCurso {
    public static void main(String[] args) {
        try {
            CursoDAO cursoDAO = new CursoDAO();
            //RECUPERANDO O CURSO COM ID = 7
            Curso curso1 = cursoDAO.findCurso(7);
            ArrayList<Disciplina> lista1 = new ArrayList<Disciplina>();
            //REMOVENDO TODAS AS DISCIPLINAS DO CURSO CUJO ID É 7
            curso1.setDisciplinaList(lista1);
            cursoDAO.edit(curso1);
            //LISTANDO AS DISCIPLINAS DO CURSO CUJO ID EH 7
            Curso curso2 = cursoDAO.findCurso(6);
            List<Disciplina> lista2 =  curso2.getDisciplinaList();
            for (Disciplina al:lista2){
                JOptionPane.showMessageDialog(null, al.getNome());
            }
        } catch (Exception e) {
            System.out.println("erro e = "+e);
        }
    }
}
