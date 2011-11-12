/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.User;
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
public class DaftarUser {

    public DaftarUser() {
        emf = Persistence.createEntityManagerFactory("ApdolPU"); 
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<User> getUser() {
        List<User> users = new ArrayList<User>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM User AS a");
            users = q.getResultList();

        } finally {
            em.close();
        }
        return users;
    }

    public User findUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public boolean check(String username, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(a) FROM User AS a WHERE a.username=:uname AND a.password=:pass");
            q.setParameter("uname", username);
            q.setParameter("pass", password);
            int jumlahUser = ((Long) q.getSingleResult()).intValue();
            if (jumlahUser == 1) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
    
    public void rekamUser(User user) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void updateUser(User user) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void deleteUser(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User user;
            try {
                user = em.getReference(User.class, id);
                user.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public User getUser(String username, String password) {
        User user = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(username, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT a FROM User AS a WHERE a.username=:uname AND a.password=:pass");
                q.setParameter("uname", username);
                q.setParameter("pass", password);
                user = (User) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return user;
    }
}
