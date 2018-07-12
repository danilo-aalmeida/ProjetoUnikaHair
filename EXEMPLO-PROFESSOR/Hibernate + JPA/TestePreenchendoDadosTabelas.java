
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jordan
 */
public class TestePreenchendoDadosTabelas {
    public static void main(String[] args) {
        try {
            
            CursoDAO cursoDAO = new CursoDAO();
            Curso curso1 = new Curso();
            curso1.setNome("Sistema de informação");
            cursoDAO.create(curso1);
            
            Curso curso2 = new Curso();
            curso2.setNome("Administração");
            cursoDAO.create(curso2);
            
            AlunoDAO alunoDAO = new AlunoDAO();
            Aluno aluno1 = new Aluno();
            aluno1.setNome("joao 111");
            aluno1.setEmail("joao111@joao.com.br");
            aluno1.setIdCurso(curso1);
            alunoDAO.inserirAluno(aluno1);
            
            Aluno aluno2 = new Aluno();
            aluno2.setNome("maria");
            aluno2.setEmail("maria@joao.com.br");
            aluno2.setIdCurso(curso2);
            alunoDAO.inserirAluno(aluno2);
            
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            Disciplina disciplina1 = new Disciplina();
            disciplina1.setNome("Teoria geral da adm");
            disciplinaDAO.create(disciplina1);
            
            Disciplina disciplina2 = new Disciplina();
            disciplina2.setNome("Introdução aos Sistema de informação");
            disciplinaDAO.create(disciplina2);
            
            List<Disciplina> listaDisciplinas1 = new ArrayList<Disciplina>();
            listaDisciplinas1.add(disciplina1);
            listaDisciplinas1.add(disciplina2);
            curso1.setDisciplinaList(listaDisciplinas1);
            cursoDAO.edit(curso1);
            
            List<Disciplina> listaDisciplinas2 = new ArrayList<Disciplina>();
            listaDisciplinas2.add(disciplina1);
            curso2.setDisciplinaList(listaDisciplinas2);

            cursoDAO.edit(curso2);
            
        } catch (Exception e) {
        }
            
    }
}
