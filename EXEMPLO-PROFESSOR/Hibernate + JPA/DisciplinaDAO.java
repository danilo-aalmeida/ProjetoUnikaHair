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
public class DisciplinaDAO implements Serializable {
/*
    public DisciplinaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }*/
    private final EntityManager em = EntityManagerUtil.getEntityManager();

    public void create(Disciplina disciplina) {
        if (disciplina.getCursoList() == null) {
            disciplina.setCursoList(new ArrayList<Curso>());
        }
        //EntityManager em = null;
        try {
          //  em = getEntityManager();
            em.getTransaction().begin();
            List<Curso> attachedCursoList = new ArrayList<Curso>();
            for (Curso cursoListCursoToAttach : disciplina.getCursoList()) {
                cursoListCursoToAttach = em.getReference(cursoListCursoToAttach.getClass(), cursoListCursoToAttach.getId());
                attachedCursoList.add(cursoListCursoToAttach);
            }
            disciplina.setCursoList(attachedCursoList);
            em.persist(disciplina);
            for (Curso cursoListCurso : disciplina.getCursoList()) {
                cursoListCurso.getDisciplinaList().add(disciplina);
                cursoListCurso = em.merge(cursoListCurso);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "erro = "+ex);
        } 
        
        finally {
            if (em != null) {
                //em.close();
            }
        }
    }

    public void edit(Disciplina disciplina) throws NonexistentEntityException, Exception {
       // EntityManager em = null;
        try {
         //   em = getEntityManager();
            em.getTransaction().begin();
            Disciplina persistentDisciplina = em.find(Disciplina.class, disciplina.getId());
            List<Curso> cursoListOld = persistentDisciplina.getCursoList();
            List<Curso> cursoListNew = disciplina.getCursoList();
            List<Curso> attachedCursoListNew = new ArrayList<Curso>();
            for (Curso cursoListNewCursoToAttach : cursoListNew) {
                cursoListNewCursoToAttach = em.getReference(cursoListNewCursoToAttach.getClass(), cursoListNewCursoToAttach.getId());
                attachedCursoListNew.add(cursoListNewCursoToAttach);
            }
            cursoListNew = attachedCursoListNew;
            disciplina.setCursoList(cursoListNew);
            disciplina = em.merge(disciplina);
            for (Curso cursoListOldCurso : cursoListOld) {
                if (!cursoListNew.contains(cursoListOldCurso)) {
                    cursoListOldCurso.getDisciplinaList().remove(disciplina);
                    cursoListOldCurso = em.merge(cursoListOldCurso);
                }
            }
            for (Curso cursoListNewCurso : cursoListNew) {
                if (!cursoListOld.contains(cursoListNewCurso)) {
                    cursoListNewCurso.getDisciplinaList().add(disciplina);
                    cursoListNewCurso = em.merge(cursoListNewCurso);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = disciplina.getId();
                if (findDisciplina(id) == null) {
                    throw new NonexistentEntityException("The disciplina with id " + id + " no longer exists.");
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
            Disciplina disciplina;
            try {
                disciplina = em.getReference(Disciplina.class, id);
                disciplina.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The disciplina with id " + id + " no longer exists.", enfe);
            }
            List<Curso> cursoList = disciplina.getCursoList();
            for (Curso cursoListCurso : cursoList) {
                cursoListCurso.getDisciplinaList().remove(disciplina);
                cursoListCurso = em.merge(cursoListCurso);
            }
            em.remove(disciplina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                //em.close();
            }
        }
    }

    public List<Disciplina> findDisciplinaEntities() {
        return findDisciplinaEntities(true, -1, -1);
    }

    public List<Disciplina> findDisciplinaEntities(int maxResults, int firstResult) {
        return findDisciplinaEntities(false, maxResults, firstResult);
    }

    private List<Disciplina> findDisciplinaEntities(boolean all, int maxResults, int firstResult) {
        //EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Disciplina.class));
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

    public Disciplina findDisciplina(Integer id) {
       // EntityManager em = getEntityManager();
        try {
            return em.find(Disciplina.class, id);
        } finally {
            //em.close();
        }
    }

    public int getDisciplinaCount() {
       // EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Disciplina> rt = cq.from(Disciplina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            //em.close();
        }
    }
    
}
