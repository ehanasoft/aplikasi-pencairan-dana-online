/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wahid
 */
public class DaftarUserTest {
    
    public DaftarUserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAdmin method, of class DaftarUser.
     
    @Test
    public void testAddAdmin() {
        System.out.println("addAdmin");
        DaftarUser instance = new DaftarUser();
        instance.addAdmin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityManager method, of class DaftarUser.
     
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarUser instance = new DaftarUser();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class DaftarUser.
     
    @Test
    public void testGetUser_0args() {
        System.out.println("getUser");
        DaftarUser instance = new DaftarUser();
        List expResult = null;
        List result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     
     /**
     * Test of findUser method, of class DaftarUser.
     */
    @Test
    public void testFindUser_Long() {
        System.out.println("findUser");
        Long id = Long.parseLong("7"); // id pada database
        DaftarUser instance = new DaftarUser();
        String expResult = "aaa";
        User result = instance.findUser(id);
        String hasil = result.getUsername();
        try {
            assertEquals(expResult, hasil);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of rekamUser method, of class DaftarUser.
     */
    @Test
    public void testRekamUser() {
        System.out.println("rekamUser");
        User user = new User();
        user.setUsername("aaaa");
        user.setPassword("aaaa");
        user.setJabatan("bendahara");
        user.setNama("udin");

        DaftarUser instance = new DaftarUser();
        try {
            instance.rekamUser(user);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isUsernameExist method, of class DaftarUser.
     */
    @Test
    public void testIsUsernameExist() {
        System.out.println("isUsernameExist");
        DaftarUser instance = new DaftarUser();
        List<User> list = instance.getUser();
        User user = list.get(0);
        String username = user.getUsername();
        boolean expResult = true;
        boolean result = instance.isUsernameExist(username);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isPasswordExist method, of class DaftarUser.
     */
    @Test
    public void testIsPasswordExist() {
        System.out.println("isPasswordExist");
        DaftarUser instance = new DaftarUser();
        List<User> list = instance.getUser();
        User user = list.get(0);
        String password = user.getPassword();
        boolean expResult = true;
        boolean result = instance.isPasswordExist(password);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarUser.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        User user;

        DaftarUser instance = new DaftarUser();
        List<User> list = instance.getUser();
        user = list.get(1);
        user.setUsername("aaaa");
        user.setPassword("aaaa");
        user.setJabatan("bendahara");
        user.setNama("udin");
        try {
            instance.edit(user);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarUser.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        DaftarUser instance = new DaftarUser();
        List<User> list = instance.getUser();
        User user = list.get(1);
        Long id = user.getId();
        try {
            instance.destroy(id);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
}
