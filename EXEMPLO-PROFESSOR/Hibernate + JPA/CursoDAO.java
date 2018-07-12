/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import hibernatealuno.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author jordan
 */
public class CursoDAO implements Serializable {

    
    private final EntityManager em = EntityManagerUtil.getEntityManager();
    /*
    public CursoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }*/

    public int  create(Curso curso) {
        
        if (curso.getDisciplinaList() == null) {
            curso.setDisciplinaList(new ArrayList<Disciplina>());
        }
        //EntityManager em = null;
        try {
            //em = getEntityManager();
            em.getTransaction().begin();
            List<Disciplina> attachedDisciplinaList = new ArrayList<Disciplina>();
            for (Disciplina disciplinaListDisciplinaToAttach : curso.getDisciplinaList()) {
                disciplinaListDisciplinaToAttach = em.getReference(disciplinaListDisciplinaToAttach.getClass(), disciplinaListDisciplinaToAttach.getId());
                attachedDisciplinaList.add(disciplinaListDisciplinaToAttach);
            }
            curso.setDisciplinaList(attachedDisciplinaList);
            em.persist(curso);
            for (Disciplina disciplinaListDisciplina : curso.getDisciplinaList()) {
                disciplinaListDisciplina.getCursoList().add(curso);
                disciplinaListDisciplina = em.merge(disciplinaListDisciplina);
            }
            em.getTransaction().commit();
          }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "erro = "+ex);
          } finally {
            if (em != null) {
                //em.close();
            }
            return curso.getId();
        }
    }

    public void edit(Curso curso) throws NonexistentEntityException, Exception {
        //EntityManager em = null;
        try {
            //em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getId());
            List<Disciplina> disciplinaListOld = persistentCurso.getDisciplinaList();
            List<Disciplina> disciplinaListNew = curso.getDisciplinaList();
            List<Disciplina> attachedDisciplinaListNew = new ArrayList<Disciplina>();
            for (Disciplina disciplinaListNewDisciplinaToAttach : disciplinaListNew) {
                disciplinaListNewDisciplinaToAttach = em.getReference(disciplinaListNewDisciplinaToAttach.getClass(), disciplinaListNewDisciplinaToAttach.getId());
                attachedDisciplinaListNew.add(disciplinaListNewDisciplinaToAttach);
            }
            disciplinaListNew = attachedDisciplinaListNew;
            curso.setDisciplinaList(disciplinaListNew);
            curso = em.merge(curso);
            for (Disciplina disciplinaListOldDisciplina : disciplinaListOld) {
                if (!disciplinaListNew.contains(disciplinaListOldDisciplina)) {
                    disciplinaListOldDisciplina.getCursoList().remove(curso);
                    disciplinaListOldDisciplina = em.merge(disciplinaListOldDisciplina);
                }
            }
            for (Disciplina disciplinaListNewDisciplina : disciplinaListNew) {
                if (!disciplinaListOld.contains(disciplinaListNewDisciplina)) {
                    disciplinaListNewDisciplina.getCursoList().add(curso);
                    disciplinaListNewDisciplina = em.merge(disciplinaListNewDisciplina);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = curso.getId();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        //EntityManager em = null;
        try {
            //em = getEntityManager();
            em.getTransaction().begin();
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            List<Disciplina> disciplinaList = curso.getDisciplinaList();
            for (Disciplina disciplinaListDisciplina : disciplinaList) {
                disciplinaListDisciplina.getCursoList().remove(curso);
                disciplinaListDisciplina = em.merge(disciplinaListDisciplina);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        //EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            //em.close();
        }
    }

    public Curso findCurso(Integer id) {
        //EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            //em.close();
        }
    }

    public int getCursoCount() {
        //EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            //em.close();
        }
    }
    
}
