/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Lokasi;
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
 * @author Accio
 */
public class DaftarLokasi {

    public DaftarLokasi() {
        emf = Persistence.createEntityManagerFactory("ApdolPU"); 
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Lokasi> getLokasi() {
        List<Lokasi> lokasi = new ArrayList<Lokasi>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Lokasi AS a");
            lokasi = q.getResultList();

        } finally {
            em.close();
        }
        return lokasi;
    }

    public Lokasi findLokasi(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lokasi.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Lokasi> findLokasiByKode(String kode){
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Lokasi.findByKode");
            query.setParameter("kodeLokasi", "%"+kode+"%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public void rekamLokasi(Lokasi lokasi) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lokasi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

   public void edit(Lokasi lokasi)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lokasi = em.merge(lokasi);
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
            Lokasi lokasi;
            try {
                lokasi = em.getReference(Lokasi.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("lokasi belum dipilih.", enfe);
            }
            em.remove(lokasi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public boolean isKodeExist(String kode) {
        DaftarLokasi daftarLokasi = new DaftarLokasi();
        List<Lokasi> listLokasi = daftarLokasi.getLokasi();
        Iterator<Lokasi> iterator = listLokasi.iterator();
        Lokasi tes = new Lokasi();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getKodeLokasi())) {
                return true;
            }
        } return false;
    }
    
    public boolean isKotaExist(String nama) {
        DaftarLokasi daftarLokasi = new DaftarLokasi();
        List<Lokasi> listLokasi = daftarLokasi.getLokasi();
        Iterator<Lokasi> iterator = listLokasi.iterator();
        Lokasi tes = new Lokasi();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (nama.equalsIgnoreCase(tes.getNamaKota())) {
                return true;
            }
        } return false;
    }
}
