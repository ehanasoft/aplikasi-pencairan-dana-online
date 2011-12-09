/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Program;
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
public class DaftarProgram {
    
    public DaftarProgram() {
        emf = Persistence.createEntityManagerFactory("ApdolPU"); 
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Program> getProgram() {
        List<Program> program = new ArrayList<Program>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Program AS a");
            program = q.getResultList();

        } finally {
            em.close();
        }
        return program;
    }

    public Program findProgram(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Program.class, id);
        } finally {
            em.close();
        }
    }
    
    public void rekamProgram(Program program) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(program);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(Program program)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            program = em.merge(program);
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
            Program program;
            try {
                program = em.getReference(Program.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Program belum dipilih.", enfe);
            }
            em.remove(program);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public boolean isKodeExist(String kode) {
        DaftarProgram daftarProgram = new DaftarProgram();
        List<Program> listProgram = daftarProgram.getProgram();
        Iterator<Program> iterator = listProgram.iterator();
        Program tes = new Program();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getKdprogram())) {
                return true;
            }
        } return false;
    }
    
    public boolean isNamaExist(String nama) {
        DaftarProgram daftarProgram = new DaftarProgram();
        List<Program> listProgram = daftarProgram.getProgram();
        Iterator<Program> iterator = listProgram.iterator();
        Program tes = new Program();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (nama.equalsIgnoreCase(tes.getNmprogram())) {
                return true;
            }
        } return false;
    }
}
