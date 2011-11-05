/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
            Query q = em.createQuery("SELECT count(a) FROM User AS a WHERE a.username=:usr AND a.password=:pswd");
            q.setParameter("usr", username);
            q.setParameter("pswd", password);
            int jumlahUser = ((Long) q.getSingleResult()).intValue();
            if (jumlahUser > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
    
    public void rekamUser(User users) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(users);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public User getUser(String username, String password) {
        User users = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(username, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT a FROM User AS a WHERE a.username=:usr AND a.password=:pswd");
                q.setParameter("usr", username);
                q.setParameter("pswd", password);
                users = (User) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return users;
    }
}
