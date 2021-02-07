/**
 * DbUtil.java
 *
 * Created on Feb 1, 2021, 2:12:42 PM
 */
package shoppinglist.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author irfin
 */
public class DbUtil 
{
    private static EntityManagerFactory emf;
    
    public static void inisialisasiKoneksi()
    {
        emf = Persistence.createEntityManagerFactory("applicationPU");
    }
    
    public static EntityManagerFactory getEntityManagerFactory()
    {
        if (emf == null)
            inisialisasiKoneksi();
        
        return emf;
    }
}
