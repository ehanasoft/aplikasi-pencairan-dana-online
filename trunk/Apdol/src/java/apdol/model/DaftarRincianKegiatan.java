/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.RincianKegiatan;
import apdol.entity.SatuanKerja;
import apdol.entity.Kegiatan;
import apdol.entity.MataAnggaran;
import apdol.entity.Output;
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
public class DaftarRincianKegiatan {

    public DaftarRincianKegiatan() {
        emf = Persistence.createEntityManagerFactory("ApdolPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<RincianKegiatan> getRincianKegiatan() {
        List<RincianKegiatan> rincianKegiatan = new ArrayList<RincianKegiatan>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM RincianKegiatan AS a");
            rincianKegiatan = q.getResultList();

        } finally {
            em.close();
        }
        return rincianKegiatan;
    }

    public RincianKegiatan findRincianKegiatan(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RincianKegiatan.class, id);
        } finally {
            em.close();
        }
    }

    public void rekamRincianKegiatan(RincianKegiatan rincianKegiatan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rincianKegiatan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RincianKegiatan rincianKegiatan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rincianKegiatan = em.merge(rincianKegiatan);
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
            RincianKegiatan rincianKegiatan;
            try {
                rincianKegiatan = em.getReference(RincianKegiatan.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("rincian kegiatan belum dipilih.", enfe);
            }
            em.remove(rincianKegiatan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean equals(RincianKegiatan other) {
        DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
        List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
        Iterator<RincianKegiatan> iterator = listRincianKegiatan.iterator();
        RincianKegiatan tes = new RincianKegiatan();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (tes.getKegiatan().equals(other.getKegiatan())
                    && tes.getMataAnggaran().equals(other.getMataAnggaran())
                    && tes.getOutput().equals(other.getOutput())) {
                return true;
            }
        }
        return false;
    }
}
