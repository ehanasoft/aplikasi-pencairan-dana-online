/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.SPM;
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
 * @author Accio
 */
public class DaftarSPM {

    public DaftarSPM() {
        emf = Persistence.createEntityManagerFactory("ApdolPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<SPM> getSPM() {
        List<SPM> spm = new ArrayList<SPM>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM SPM AS a");
            spm = q.getResultList();

        } finally {
            em.close();
        }
        return spm;
    }

    public SPM findSPM(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SPM.class, id);
        } finally {
            em.close();
        }
    }

    public void rekamSPM(SPM spm) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(spm);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SPM spm) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            spm = em.merge(spm);
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
            SPM spm;
            try {
                spm = em.getReference(SPM.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("spm belum dipilih.", enfe);
            }
            em.remove(spm);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
