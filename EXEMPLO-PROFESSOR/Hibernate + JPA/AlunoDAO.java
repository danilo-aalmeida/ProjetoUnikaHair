/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author jordan
 */
public class AlunoDAO {
    
    
    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    public void inserirAluno(Aluno aluno) throws Exception{
        EntityTransaction tx = entityManager.getTransaction();
		 
        try {
            tx.begin();
            entityManager.persist(aluno);
            //JOptionPane.showMessageDialog(null,"vai inserir");
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
            JOptionPane.showMessageDialog(null,t);
        } finally {
            
        }
    }
    
    public void alterarAluno(Aluno aluno) throws Exception{
    EntityTransaction tx = entityManager.getTransaction();
		 
        try {
            tx.begin();
            entityManager.merge(aluno);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            
        }
        
    }
   public void deletarAluno(Aluno aluno) throws Exception{
    
EntityTransaction tx = entityManager.getTransaction();
		 
        try {
            tx.begin();
            entityManager.remove(aluno);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            
        }
        
    }

   public Aluno retornarAluno(int id) throws Exception{
   
    Aluno aluno = null;
    try {
            aluno = entityManager.find(Aluno.class, id);
    } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
    }
            return aluno;   
       
   

   }
   public Aluno retornarAluno(String nome) throws Exception{
   
    Aluno aluno = null;
    try {
            aluno = entityManager.find(Aluno.class, nome);
    } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
    }
            return aluno;  

   }
   public ArrayList<Aluno> retornarAlunos() throws Exception{
    ArrayList<Aluno> lista = new ArrayList<Aluno>();   
    Query query = entityManager.createQuery("select ddd from Aluno ddd");
    lista = (ArrayList<Aluno>) 
            query.getResultList();
    return lista;

   }
    
}
