/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jordan
 */
public class TesteAlunoCurso {
    public static void main(String[] args) {
        try {
            //CRIAR CURSO
            CursoDAO cursoDAO = new CursoDAO();
            Curso curso1 = new Curso();
            curso1.setNome("Sistema de informação");
            cursoDAO.create(curso1);
            
            //CRIAR ALUNO
            AlunoDAO alunoDAO = new AlunoDAO();
            Aluno aluno1 = new Aluno();
            aluno1.setNome("joao 111");
            aluno1.setEmail("joao111@joao.com.br");
            //DEFINIR O CURSO DO ALUNO
            aluno1.setIdCurso(curso1);
            alunoDAO.inserirAluno(aluno1);
        } catch (Exception e) {
            System.out.println("erro e = "+e);
        }
        
    }
}
