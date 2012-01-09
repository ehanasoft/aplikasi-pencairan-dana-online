/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Pejabat;
import apdol.entity.SatuanKerja;
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
 * @author AlfieSaHid
 */
public class DaftarPejabat {

    public DaftarPejabat() {
        emf = Persistence.createEntityManagerFactory("ApdolPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Pejabat> getPejabat() {
        List<Pejabat> pejabat = new ArrayList<Pejabat>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Pejabat AS a");
            pejabat = q.getResultList();

        } finally {
            em.close();
        }
        return pejabat;
    }

    public Pejabat findPejabat(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pejabat.class, id);
        } finally {
            em.close();
        }
    }

    public void rekamPejabat(Pejabat pejabat) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pejabat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pejabat pejabat) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pejabat = em.merge(pejabat);
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
            Pejabat pejabat;
            try {
                pejabat = em.getReference(Pejabat.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Pejabat belum dipilih.", enfe);
            }
            em.remove(pejabat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean isNipExist(String nip) {
        DaftarPejabat daftarPejabat = new DaftarPejabat();
        List<Pejabat> listPejabat = daftarPejabat.getPejabat();
        Iterator<Pejabat> iterator = listPejabat.iterator();
        Pejabat tes = new Pejabat();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (nip.equalsIgnoreCase(tes.getNip())) {
                return true;
            }
        }
        return false;
    }

    public boolean isNamaExist(String nama) {
        DaftarPejabat daftarPejabat = new DaftarPejabat();
        List<Pejabat> listPejabat = daftarPejabat.getPejabat();
        Iterator<Pejabat> iterator = listPejabat.iterator();
        Pejabat tes = new Pejabat();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (nama.equalsIgnoreCase(tes.getNama())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isJabatanExist(String ketjabatan, SatuanKerja satker) {
        DaftarPejabat daftarPejabat = new DaftarPejabat();
        List<Pejabat> listPejabat = daftarPejabat.getPejabat();
        Iterator<Pejabat> iterator = listPejabat.iterator();
        Pejabat tes = new Pejabat();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if ((ketjabatan.equals(tes.getKetjabatan())&&(ketjabatan.equals("KPA")||ketjabatan.equals("Penandatangan SPM")))
                    && tes.getSatker().getId()==satker.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean isKetjabatanExist(String ketjabatan) {
        DaftarPejabat daftarPejabat = new DaftarPejabat();
        List<Pejabat> listPejabat = daftarPejabat.getPejabat();
        Iterator<Pejabat> iterator = listPejabat.iterator();
        Pejabat tes = new Pejabat();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (ketjabatan.equals(tes.getKetjabatan())&&(ketjabatan.equals("Kasi Pencairan Dana")||ketjabatan.equals("Kasi Bank/Giro Pos"))) {
                return true;
            }
        }
        return false;
    }

}
