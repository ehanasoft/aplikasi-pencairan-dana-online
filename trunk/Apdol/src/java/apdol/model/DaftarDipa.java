/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Dipa;
import apdol.entity.RincianKegiatan;
import apdol.model.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wahid
 */
public class DaftarDipa {

    public DaftarDipa() {
        emf = Persistence.createEntityManagerFactory("ApdolPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Dipa> getDipa() {
        List<Dipa> dipa = new ArrayList<Dipa>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Dipa AS a");
            dipa = q.getResultList();

        } finally {
            em.close();
        }
        return dipa;
    }

    public Dipa findDipa(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dipa.class, id);
        } finally {
            em.close();
        }
    }
    
    public Dipa findDipaByRincianKegiatan(RincianKegiatan rincianKegiatan){
        DaftarDipa daftarDipa = new DaftarDipa();
        List <Dipa> listDipa= daftarDipa.getDipa();
        Iterator<Dipa> it = listDipa.iterator();
        Dipa dipa = new Dipa();
        while (it.hasNext()) {
            dipa = it.next();
            if (dipa.getRincianKegiatan().equals(rincianKegiatan))
                return dipa;
        }
        return dipa;
    }

    public void rekamDipa(Dipa dipa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dipa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dipa dipa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dipa = em.merge(dipa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dipa dipa;
            try {
                dipa = em.getReference(Dipa.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("dipa belum dipilih.", enfe);
            }
            em.remove(dipa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean equals(Dipa other) {
        DaftarDipa daftarDipa = new DaftarDipa();
        List<Dipa> listDipa = daftarDipa.getDipa();
        Iterator<Dipa> iterator = listDipa.iterator();
        Dipa tes = new Dipa();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (tes.getRincianKegiatan().equals(other.getRincianKegiatan()))                    
            {
                return true;
            }
        }
        return false;
    }
    public boolean isNomorExist(String nomorDipa) {
        DaftarDipa daftarDipa = new DaftarDipa();
        List<Dipa> listDipa = daftarDipa.getDipa();
        Iterator<Dipa> iterator = listDipa.iterator();
        Dipa tes = new Dipa();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (nomorDipa.equalsIgnoreCase(tes.getNomorDipa())) {
                return true;
            }
        } return false;
    }
    
    //public void kurangiDipa (Long idDipa,)
}
