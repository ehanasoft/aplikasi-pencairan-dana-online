/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.MataAnggaran;
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
public class DaftarMataAnggaran {

    public DaftarMataAnggaran() {
        emf = Persistence.createEntityManagerFactory("ApdolPU"); 
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<MataAnggaran> getMataAnggaran() {
        List<MataAnggaran> mataAnggaran = new ArrayList<MataAnggaran>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM MataAnggaran AS a");
            mataAnggaran = q.getResultList();

        } finally {
            em.close();
        }
        return mataAnggaran;
    }

    public MataAnggaran findMataAnggaran(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MataAnggaran.class, id);
        } finally {
            em.close();
        }
    }
    
    public void rekamMataAnggaran(MataAnggaran mataAnggaran) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mataAnggaran);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

   public void edit(MataAnggaran mataAnggaran)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mataAnggaran = em.merge(mataAnggaran);
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
            MataAnggaran mataAnggaran;
            try {
                mataAnggaran = em.getReference(MataAnggaran.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Mata Anggaran belum dipilih.", enfe);
            }
            em.remove(mataAnggaran);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
