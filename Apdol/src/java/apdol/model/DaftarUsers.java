/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Users;
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
public class DaftarUsers {
    
    public DaftarUsers() {
        emf = Persistence.createEntityManagerFactory("persistence"); 
    }
    
    private EntityManagerFactory emf = null;
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Users> getUsers() {
        List<Users> users = new ArrayList<Users>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Users AS a");
            users = q.getResultList();

        } finally {
            em.close();
        }
        return users;
    }
    
    public Users findUsers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }
    
        public boolean check(String username, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(a) FROM Users AS a WHERE a.username=:usr AND a.password=:pswd");
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
        
        public Users getUsers(String username, String password) {
        Users users = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(username, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT a FROM Users AS a WHERE a.username=:usr AND a.password=:pswd");
                q.setParameter("usr", username);
                q.setParameter("pswd", password);
                users = (Users) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return users;
    }



}
