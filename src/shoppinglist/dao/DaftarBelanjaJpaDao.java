/**
 * DaftarBelanjaJpaDao.java
 *
 * Created on Feb 1, 2021, 2:10:49 PM
 */
package shoppinglist.dao;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import shoppinglist.entity.DaftarBelanja;

/**
 *
 * @author irfin
 */
public class DaftarBelanjaJpaDao 
{
    private EntityManagerFactory emf;

    public DaftarBelanjaJpaDao(EntityManagerFactory factory)
    {
        emf = factory;
    }
    
    public boolean simpan(DaftarBelanja daftarBelanja)
    {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(daftarBelanja);
            em.getTransaction().commit();
            
            return true;
        }
        catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
            return false;
        }
        finally {
            em.close();
        }
    }
    
    public List<DaftarBelanja> bacaSemua()
    {
        List<DaftarBelanja> retval = new LinkedList<>();
        EntityManager em = emf.createEntityManager();
        
        // Buat query dalam bentuk Java Persistence Query Language (JPQL)
        String jpql = "SELECT b FROM DaftarBelanja b ORDER BY b.tanggal DESC";
        
        try {
            Query query = em.createQuery(jpql);
            retval = query.getResultList();
            
            return retval;
        }
        catch (Exception ex) {
            System.out.println("Error saat insert data: " + ex.getMessage());
            ex.printStackTrace(System.out);
            return null;
        }
        finally {
            em.close();
        }
    }
}
