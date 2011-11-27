/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.BankPos;
import apdol.model.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author AlfieSaHid
 */
public class DaftarBankPos {
    
    public DaftarBankPos() {
        emf = Persistence.createEntityManagerFactory("ApdolPU"); 
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<BankPos> getBankPos() {
        List<BankPos> bankpos = new ArrayList<BankPos>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM BankPos AS a");
            bankpos = q.getResultList();

        } finally {
            em.close();
        }
        return bankpos;
    }

    public BankPos findBankPos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BankPos.class, id);
        } finally {
            em.close();
        }
    }
    
    public void rekamBankPos(BankPos bankpos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bankpos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(BankPos bankpos)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bankpos = em.merge(bankpos);
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
            BankPos bankpos;
            try {
                bankpos = em.getReference(BankPos.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Bank Pos belum dipilih.", enfe);
            }
            em.remove(bankpos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public boolean isKodeExist(String kode) {
        DaftarBankPos daftarBankPos = new DaftarBankPos();
        List<BankPos> listBankPos = daftarBankPos.getBankPos();
        Iterator<BankPos> iterator = listBankPos.iterator();
        BankPos tes = new BankPos();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getKdbankpos())) {
                return true;
            }
        } return false;
    }
    
    public boolean isNamaExist(String nama) {
        DaftarBankPos daftarBankPos = new DaftarBankPos();
        List<BankPos> listBankPos = daftarBankPos.getBankPos();
        Iterator<BankPos> iterator = listBankPos.iterator();
        BankPos tes = new BankPos();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (nama.equalsIgnoreCase(tes.getNmbankpos())) {
                return true;
            }
        } return false;
    }
    
}
