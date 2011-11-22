/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Kegiatan;
import apdol.model.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author AlfieSaHid
 */
public class DaftarKegiatan {
    
    public DaftarKegiatan() {
        emf = Persistence.createEntityManagerFactory("ApdolPU"); 
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Kegiatan> getKegiatan() {
        List<Kegiatan> kegiatan = new ArrayList<Kegiatan>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Kegiatan AS a");
            kegiatan = q.getResultList();

        } finally {
            em.close();
        }
        return kegiatan;
    }

    public Kegiatan findKegiatan(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Kegiatan.class, id);
        } finally {
            em.close();
        }
    }
    
    public void rekamKegiatan(Kegiatan kegiatan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(kegiatan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

   public void edit(Kegiatan kegiatan)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            kegiatan = em.merge(kegiatan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long  id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Kegiatan kegiatan;
            try {
                kegiatan = em.getReference(Kegiatan.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("kegiatan belum dipilih.", enfe);
            }
            em.remove(kegiatan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
