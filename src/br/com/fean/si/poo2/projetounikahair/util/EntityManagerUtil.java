package br.com.fean.si.poo2.projetounikahair.util;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class EntityManagerUtil {
  private static EntityManagerFactory emf;
         public static EntityManager getEntityManager() {
                 if (emf == null){
                          emf = Persistence.createEntityManagerFactory("ProjetoUnikaHairPU");
                 }
                 return emf.createEntityManager();
         }
}
