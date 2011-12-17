/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.SP2D;
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
public class DaftarSP2D {
    public DaftarSP2D() {
        emf = Persistence.createEntityManagerFactory("ApdolPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<SP2D> getSP2D() {
        List<SP2D> sp2d = new ArrayList<SP2D>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM SP2D AS a");
            sp2d = q.getResultList();

        } finally {
            em.close();
        }
        return sp2d;
    }

    public SP2D findSP2D(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SP2D.class, id);
        } finally {
            em.close();
        }
    }

    public void rekamSP2D(SP2D sp2d) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sp2d);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SP2D sp2d) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sp2d = em.merge(sp2d);
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
            SP2D sp2d;
            try {
                sp2d = em.getReference(SP2D.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("sp2d belum dipilih.", enfe);
            }
            em.remove(sp2d);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }    
}
