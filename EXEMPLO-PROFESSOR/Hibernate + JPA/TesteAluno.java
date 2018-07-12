
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
public class TesteAluno {
    public static void main(String[] args) {
        try {
            
            
            
            
            
            
            AlunoDAO alunoDAO = new AlunoDAO();
            Aluno aluno1 = new Aluno();
            aluno1.setNome("joao 111");
            aluno1.setEmail("joao111@joao.com.br");
            
            //PARA INSERÇÃO
            alunoDAO.inserirAluno(aluno1);
            

            
            
            
            //PARA EDIÇÃO
            //aluno.setMatricula(1);
            //alunoDAO.alterarAluno(aluno);
            //PARA LISTAR
            /*
            ArrayList<Aluno> lista = alunoDAO.retornarAlunos();
            for (Aluno al:lista){
                JOptionPane.showMessageDialog(null, al.getNome());
            }*/
            JOptionPane.showMessageDialog(null,"ok");
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
