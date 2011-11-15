/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.BankPos;
import apdol.model.exceptions.NonexistentEntityException;
import java.util.ArrayList;
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
        List<BankPos> banks = new ArrayList<BankPos>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM BankPos AS a");
            banks = q.getResultList();

        } finally {
            em.close();
        }
        return banks;
    }

    public BankPos findBankPos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BankPos.class, id);
        } finally {
            em.close();
        }
    }

    public boolean check(String kdbankpos) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(a) FROM BankPos AS a WHERE a.kdbankpos=:kdbank");
            q.setParameter("kdbank", kdbankpos);
            int jumlahBankPos = ((Long) q.getSingleResult()).intValue();
            if (jumlahBankPos == 1) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
    
    public void rekamBankPos(BankPos bank) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bank);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void updateBankPos(BankPos bank) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(bank);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void deleteBankPos(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BankPos bank;
            try {
                bank = em.getReference(BankPos.class, id);
                bank.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(bank);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public BankPos getUser(String kdbankpos) {
        BankPos bank = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(kdbankpos);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT a FROM BankPos AS a WHERE a.kdbankpos=:kdbank");
                q.setParameter("kdbank", kdbankpos);     
                bank = (BankPos) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return bank;
    }
    
}
