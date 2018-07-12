
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
public class TesteDisciplinaCurso {
    public static void main(String[] args) {
        try {
            //CRIA O CURSO 1
            CursoDAO cursoDAO = new CursoDAO();
            Curso curso1 = new Curso();
            curso1.setNome("Sistema de informação");
            cursoDAO.create(curso1);
            
            //CRIA O CURSO 2
            Curso curso2 = new Curso();
            curso2.setNome("Administração");
            cursoDAO.create(curso2);
            
            //CRIA DISCIPLINA 1
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            Disciplina disciplina1 = new Disciplina();
            disciplina1.setNome("Teoria geral da adm");
            disciplinaDAO.create(disciplina1);
            
            //CRIA DISCIPLINA 2
            Disciplina disciplina2 = new Disciplina();
            disciplina2.setNome("Introdução aos Sistema de informação");
            disciplinaDAO.create(disciplina2);
            
            //CRIANDO UMA LISTA DE DISCIPLINAS E ADICINANDO AS DISCIPLINAS 1 E 2
            List<Disciplina> listaDisciplinas1 = new ArrayList<Disciplina>();
            listaDisciplinas1.add(disciplina1);
            listaDisciplinas1.add(disciplina2);
            
            //SETANDO AS DISCIPLINAS PARA O CURSO 1
            curso1.setDisciplinaList(listaDisciplinas1);
            cursoDAO.edit(curso1);
            
            //CRIANDO UMA LISTA DE DISCIPLINAS E ADICINANDO A DISCIPLINAS 1
            List<Disciplina> listaDisciplinas2 = new ArrayList<Disciplina>();
            listaDisciplinas2.add(disciplina1);
            //SETANDO A DISCIPLINAS PARA O CURSO 2
            curso2.setDisciplinaList(listaDisciplinas2);
            cursoDAO.edit(curso2);
        } catch (Exception e) {
            System.out.println("erro e = "+e);
        }
        
    }
}
