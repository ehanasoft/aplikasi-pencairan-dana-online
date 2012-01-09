/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.model;

import apdol.entity.Dipa;
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
public class DaftarDipaTest {
    
    public DaftarDipaTest() {
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
     * Test of getEntityManager method, of class DaftarDipa.
     
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarDipa instance = new DaftarDipa();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDipa method, of class DaftarDipa.
     
    @Test
    public void testGetDipa() {
        System.out.println("getDipa");
        DaftarDipa instance = new DaftarDipa();
        List expResult = null;
        List result = instance.getDipa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDipa method, of class DaftarDipa.
     
    @Test
    public void testFindDipa() {
        System.out.println("findDipa");
        Long id = null;
        DaftarDipa instance = new DaftarDipa();
        Dipa expResult = null;
        Dipa result = instance.findDipa(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDipaByRincianKegiatan method, of class DaftarDipa.
     
    @Test
    public void testFindDipaByRincianKegiatan() {
        System.out.println("findDipaByRincianKegiatan");
        RincianKegiatan rincianKegiatan = null;
        DaftarDipa instance = new DaftarDipa();
        Dipa expResult = null;
        Dipa result = instance.findDipaByRincianKegiatan(rincianKegiatan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rekamDipa method, of class DaftarDipa.
     */
    @Test
    public void testRekamDipa() {
        System.out.println("rekamDipa");
        Dipa dipa = new Dipa();
        dipa.setNomorDipa("12345");
        dipa.setPagu("45231");
        dipa.setRealisasi("4523");
       
        DaftarDipa instance = new DaftarDipa();
        try {
            instance.rekamDipa(dipa);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class DaftarDipa.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Dipa dipa;
        
        DaftarDipa instance = new DaftarDipa();
        List<Dipa> list = instance.getDipa();
        dipa = list.get(1);
        dipa.setNomorDipa("45231");
        dipa.setPagu("10000");
        dipa.setRealisasi("1000");
        try {
            instance.edit(dipa);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class DaftarDipa.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        DaftarDipa instance = new DaftarDipa();
        List<Dipa> list = instance.getDipa();
        Dipa dipa = list.get(1);
        Long id = dipa.getId();
        try {
            instance.destroy(id);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    /**
     * Test of isNomorExist method, of class DaftarDipa.
     */
    @Test
    public void testIsNomorExist() {
        System.out.println("isNomorExist");
        DaftarDipa instance = new DaftarDipa();
        List<Dipa> list = instance.getDipa();
        Dipa dipa = list.get(0);
        String nomor = dipa.getNomorDipa();
        boolean expResult = true;
        boolean result = instance.isNomorExist(nomor);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
}
